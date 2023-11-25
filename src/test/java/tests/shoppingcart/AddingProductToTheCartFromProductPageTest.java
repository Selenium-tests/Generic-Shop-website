package tests.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.ThumbnailCategory;
import qa.enums.ThumbnailType;
import qa.pageobject.header.Header;
import qa.pageobject.productpage.ProductPage;
import qa.pageobject.shoppingcart.Row;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.pageobject.thumbnails.ProductThumbnail;
import qa.pageobject.thumbnails.Thumbnail;
import qa.provider.MyDataProvider;
import qa.extentreports.ExtentReportsManager;
import qa.records.Link;
import qa.thumbnailgenerators.ThumbnailProvider;


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

    private void check(String productName, ThumbnailCategory category) {

        Thumbnail thumbnail = ThumbnailProvider
                .getFactory(ThumbnailType.PRODUCT)
                .createThumbnail(getDriver(), category, productName);

        if (thumbnail instanceof ProductThumbnail) {

            String name = thumbnail.getLinkText();
            String price = ((ProductThumbnail) thumbnail).getPrice();

            thumbnail.clickLink();

            productPage.getQuantityField().setQuantity("1");
            productPage.clickAddToCart();
            header.clickCartButton();

            Assert.assertFalse(shoppingCart.getContentsLocator().isEmpty(), "The shopping cart is empty");

            Row row = shoppingCart.getTable().getRow(0);

            Assert.assertEquals(row.getName(), name, "Incorrect product name in the shopping cart");
            Assert.assertEquals(row.getPrice(), price, "Incorrect price in the shopping cart");
        }
    }

    @Test(dataProvider = "allBlackTops", dataProviderClass = MyDataProvider.class)
    public void allBlackTops(Link link) {

        ExtentReportsManager.setName("Adding the \"" + link.linkText() + "\" product from the \"ALL BLACK TOPS\" category");

        check(link.linkText(), ThumbnailCategory.ALL_BLACK_TOPS);
    }

    @Test(dataProvider = "highHeelShoesProducts", dataProviderClass = MyDataProvider.class)
    public void highHeelShoes(Link link) {

        ExtentReportsManager.setName("Adding the \"" + link.linkText() + "\" product from the \"HIGH HEEL SHOES\" category");

        check(link.linkText(), ThumbnailCategory.HIGH_HEEL_SHOES);
    }

    @Test(dataProvider = "mostWantedProducts", dataProviderClass = MyDataProvider.class)
    public void mostWanted(Link link) {

        //ExtentReportsManager.setName("Adding the \"" + link.linkText() + "\" product from the \"MOST WANTED\" category");

        check(link.linkText(), ThumbnailCategory.MOST_WANTED);
    }

    @Test(dataProvider = "scarfsProducts", dataProviderClass = MyDataProvider.class)
    public void scarfs(Link link) {

        ExtentReportsManager.setName("Adding the \"" + link.linkText() + "\" product from the \"SCARFS\" category");

        check(link.linkText(), ThumbnailCategory.SCARFS);
    }

    @Test(dataProvider = "onSaleProducts", dataProviderClass = MyDataProvider.class)
    public void onSale(Link link) {

         ExtentReportsManager.setName("Adding the \"" + link.linkText() + "\" product from the \"ON SALE\" category");

        check(link.linkText(), ThumbnailCategory.ON_SALE);
    }

    @Test(dataProvider = "featuredProducts", dataProviderClass = MyDataProvider.class)
    public void featured(Link link) {

        ExtentReportsManager.setName("Adding the \"" + link.linkText() + "\" product from the \"FEATURED\" category");

        check(link.linkText(), ThumbnailCategory.FEATURED);
    }

    @Test(dataProvider = "trendsProducts", dataProviderClass = MyDataProvider.class)
    public void trends(Link link) {

        ExtentReportsManager.setName("Adding the \"" + link.linkText() + "\" product from the \"TRENDS\" category");

        check(link.linkText(), ThumbnailCategory.TRENDS);
    }
}
