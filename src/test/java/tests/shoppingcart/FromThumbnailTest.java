package tests.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.data.LinkData;
import qa.dataproviders.DataProviders;
import qa.enums.ThumbnailCategory;
import qa.enums.ThumbnailType;
import qa.enums.URLs;
import qa.pageobject.header.Header;
import qa.pageobject.shoppingcart.Row;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.pageobject.thumbnails.ProductThumbnail;
import qa.thumbnailgenerators.ThumbnailProvider;

public class FromThumbnailTest extends BaseTest {

    private Header header;
    private ProductThumbnail productThumbnail;
    private ShoppingCart shoppingCart;
    private String productName;
    private String productPrice;

    @BeforeMethod
    private void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
        header = new Header(getDriver());
        shoppingCart = new ShoppingCart(getDriver());
    }

    private void addToCart(ThumbnailCategory category, String name) throws IllegalAccessException {

        productThumbnail = (ProductThumbnail) ThumbnailProvider
                .getFactory(ThumbnailType.PRODUCT)
                .createThumbnail(getDriver(), category, name);

        productName = productThumbnail.getLinkText();
        productPrice = productThumbnail.getPrice();
        productThumbnail.clickAddToCartButton();

        /*if (thumbnail instanceof ProductThumbnail) {

            productName = ((ProductThumbnail) thumbnail).getLinkText();
            productPrice = ((ProductThumbnail) thumbnail).getPrice();

            ((ProductThumbnail) thumbnail).clickAddToCartButton();
            header.clickCartButton();
        }*/
    }

    private void checkShoppingCartContents() {

        Assert.assertTrue(shoppingCart.hasContents(),
                "The shopping cart is empty");
    }

    private void checkRow() {

        Row row = shoppingCart.getTable().getRow(0);

        Assert.assertEquals(row.getName(), productName, "Incorrect product name in the shopping cart");
        Assert.assertEquals(row.getPrice(), productPrice, "Incorrect product price in the shopping cart");
    }

    private void actions(ThumbnailCategory category, String productName) throws IllegalAccessException {

        addToCart(category, productName);
        productThumbnail.waitForViewCartButton();
        goToSpecificPage(URLs.SHOPPING_CART.getName());
        checkShoppingCartContents();
        checkRow();
    }

    @Test(dataProvider = "allBlackTops", dataProviderClass = DataProviders.class)
    public void allBlackTops(LinkData linkData) throws IllegalAccessException, InterruptedException {

        addToCart(ThumbnailCategory.ALL_BLACK_TOPS, linkData.getLink());
        //Thread.sleep(3000);
        productThumbnail.waitForViewCartButton();
        goToSpecificPage(URLs.SHOPPING_CART.getName());
        checkShoppingCartContents();
        checkRow();
        //actions(ThumbnailCategory.ALL_BLACK_TOPS, link.getLinkText());
    }

    @Test(dataProvider = "highHeelShoesProducts", dataProviderClass = DataProviders.class)
    public void highHeelShoes(LinkData linkData) throws IllegalAccessException {

        actions(ThumbnailCategory.HIGH_HEEL_SHOES, linkData.getLink());
    }

    @Test(dataProvider = "mostWantedProducts", dataProviderClass = DataProviders.class)
    public void mostWanted(LinkData linkData) throws IllegalAccessException {

        actions(ThumbnailCategory.MOST_WANTED, linkData.getLink());
    }

    @Test(dataProvider = "scarfsProducts", dataProviderClass = DataProviders.class)
    public void scarfs(LinkData linkData) throws IllegalAccessException {

        actions(ThumbnailCategory.SCARFS, linkData.getLink());
    }

    @Test(dataProvider = "onSaleProducts", dataProviderClass = DataProviders.class)
    public void onSale(LinkData linkData) throws IllegalAccessException {

        actions(ThumbnailCategory.ON_SALE, linkData.getLink());
    }

    @Test(dataProvider = "featuredProducts", dataProviderClass = DataProviders.class)
    public void featured(LinkData linkData) throws IllegalAccessException {

        actions(ThumbnailCategory.FEATURED, linkData.getLink());
    }

    @Test(dataProvider = "trendsProducts", dataProviderClass = DataProviders.class)
    public void trends(LinkData linkData) throws IllegalAccessException {

        actions(ThumbnailCategory.TRENDS, linkData.getLink());
    }
}
