package tests.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.URLs;
import qa.pageobject.productpage.ProductPage;
import qa.pageobject.shoppingcart.Row;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.dataproviders.DataProviders;
import qa.data.Link;


public class AddingProductToTheCartFromProductPageTest extends BaseTest {

    private ProductPage productPage;
    private ShoppingCart shoppingCart;
    private String productName;
    private String productPrice;

    @BeforeMethod
    public void create() {

        productPage = new ProductPage(getDriver());
        shoppingCart = new ShoppingCart(getDriver());
    }

    private void addToCart() throws IllegalAccessException {

        productName = productPage.getProductTitle();
        productPrice = productPage.getPrice();

        productPage.getQuantityField().setQuantity("1");
        productPage.clickAddToCart();
    }

    private void checkShoppingCartContents() {

        Assert.assertFalse(shoppingCart.getContentsLocator().isEmpty(), "The shopping cart is empty");
    }

    private void checkRow() {

        Row row = shoppingCart.getTable().getRow(0);

        Assert.assertEquals(row.getName(), productName, "Incorrect product name in the shopping cart");
        Assert.assertEquals(row.getPrice(), productPrice, "Incorrect price in the shopping cart");
    }

    private void actions(String productPageUrl) throws IllegalAccessException {

        goToSpecificPage(productPageUrl);
        addToCart();
        goToSpecificPage(URLs.SHOPPING_CART.getName());
        checkShoppingCartContents();
        checkRow();
    }

    @Test(dataProvider = "allBlackTops", dataProviderClass = DataProviders.class)
    public void allBlackTops(Link link) throws IllegalAccessException {

        actions(link.getPageURL());
    }

    @Test(dataProvider = "highHeelShoesProducts", dataProviderClass = DataProviders.class)
    public void highHeelShoes(Link link) throws IllegalAccessException {

        actions(link.getPageURL());
    }

    @Test(dataProvider = "mostWantedProducts", dataProviderClass = DataProviders.class)
    public void mostWanted(Link link) throws IllegalAccessException {

        actions(link.getPageURL());
    }

    @Test(dataProvider = "scarfsProducts", dataProviderClass = DataProviders.class)
    public void scarfs(Link link) throws IllegalAccessException {

        actions(link.getPageURL());
    }

    @Test(dataProvider = "onSaleProducts", dataProviderClass = DataProviders.class)
    public void onSale(Link link) throws IllegalAccessException {

        actions(link.getPageURL());
    }

    @Test(dataProvider = "featuredProducts", dataProviderClass = DataProviders.class)
    public void featured(Link link) throws IllegalAccessException {

        actions(link.getPageURL());
    }

    @Test(dataProvider = "trendsProducts", dataProviderClass = DataProviders.class)
    public void trends(Link link) throws IllegalAccessException {

        actions(link.getPageURL());
    }
}
