package tests.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.pageobject.header.Header;
import qa.pageobject.productpage.ProductPage;
import qa.pageobject.shoppingcart.Row;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.provider.MyDataProvider;
import qa.extentreports.ExtentReportsManager;
import qa.records.Link;


public class AddingProductToTheCartFromProductPageTest extends BaseTest {

    private ProductPage productPage;
    private ShoppingCart shoppingCart;
    private Header header;

    @BeforeMethod
    public void create() {

        productPage = new ProductPage(getDriver());
        shoppingCart = new ShoppingCart(getDriver());
        header = new Header(getDriver());
    }

    private void check() throws IllegalAccessException {

        String name = productPage.getProductTitle();
        String price = productPage.getPrice();

        productPage.getQuantityField().setQuantity("1");
        productPage.clickAddToCart();
        header.clickCartButton();

        Assert.assertFalse(shoppingCart.getContentsLocator().isEmpty(), "The shopping cart is empty");

        Row row = shoppingCart.getTable().getRow(0);

        Assert.assertEquals(row.getName(), name, "Incorrect product name in the shopping cart");
        Assert.assertEquals(row.getPrice(), price, "Incorrect price in the shopping cart");
    }

    @Test(dataProvider = "allBlackTops", dataProviderClass = MyDataProvider.class)
    public void allBlackTops(Link link) throws IllegalAccessException {

        ExtentReportsManager.setName("Adding the \"" + link.getLinkText() + "\" product from the \"ALL BLACK TOPS\" category");

        goToSpecificPage(link.getPageURL());
        check();
    }

    @Test(dataProvider = "highHeelShoesProducts", dataProviderClass = MyDataProvider.class)
    public void highHeelShoes(Link link) throws IllegalAccessException {

        ExtentReportsManager.setName("Adding the \"" + link.getLinkText() + "\" product from the \"HIGH HEEL SHOES\" category");

        goToSpecificPage(link.getPageURL());
        check();
    }

    @Test(dataProvider = "mostWantedProducts", dataProviderClass = MyDataProvider.class)
    public void mostWanted(Link link) throws IllegalAccessException {

        ExtentReportsManager.setName("Adding the \"" + link.getLinkText() + "\" product from the \"MOST WANTED\" category");

        goToSpecificPage(link.getPageURL());
        check();
    }

    @Test(dataProvider = "scarfsProducts", dataProviderClass = MyDataProvider.class)
    public void scarfs(Link link) throws IllegalAccessException {

        ExtentReportsManager.setName("Adding the \"" + link.getLinkText() + "\" product from the \"SCARFS\" category");

        goToSpecificPage(link.getPageURL());
        check();
    }

    @Test(dataProvider = "onSaleProducts", dataProviderClass = MyDataProvider.class)
    public void onSale(Link link) throws IllegalAccessException {

        ExtentReportsManager.setName("Adding the \"" + link.getLinkText() + "\" product from the \"ON SALE\" category");

        goToSpecificPage(link.getPageURL());
        check();
    }

    @Test(dataProvider = "featuredProducts", dataProviderClass = MyDataProvider.class)
    public void featured(Link link) throws IllegalAccessException {

        ExtentReportsManager.setName("Adding the \"" + link.getLinkText() + "\" product from the \"FEATURED\" category");

        goToSpecificPage(link.getPageURL());
        check();
    }

    @Test(dataProvider = "trendsProducts", dataProviderClass = MyDataProvider.class)
    public void trends(Link link) throws IllegalAccessException {

        ExtentReportsManager.setName("Adding the \"" + link.getLinkText() + "\" product from the \"TRENDS\" category");

        goToSpecificPage(link.getPageURL());
        check();
    }
}
