package tests.shoppingcart;

import org.testng.Assert;
import qa.enums.ProductCategory;
import qa.pageobject.shoppingcart.Row;
import qa.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.pageobject.SiteContentSection;
import qa.pageobject.header.Header;
import qa.pageobject.thumbnails.ProductThumbnail;
import qa.provider.MyDataProvider;
import qa.utils.ExtentReportsManager;
import qa.utils.Link;


public class AddingProductToCartFromHomePageTest extends BaseTest {

    private Header header;
    private SiteContentSection siteContentSection;
    private ShoppingCart shoppingCart;

    @BeforeMethod
    private void create() {

        header = new Header(getDriver());
        siteContentSection = new SiteContentSection(getDriver());
        shoppingCart = new ShoppingCart(getDriver());
    }

    public void check(String productName, ProductCategory category) {

        ProductThumbnail productThumbnail = siteContentSection.getProductThumbnail(getDriver(), productName, category);

        final String name = productThumbnail.getName();
        final String price = productThumbnail.getPrice();

        productThumbnail.clickButton();
        header.clickCartButton();

        Row row = shoppingCart.getTable().getRow(0);

        Assert.assertTrue(shoppingCart.hasContents());
        Assert.assertEquals(row.getName(), name, "Incorrect product name in the shopping cart");
        Assert.assertEquals(row.getPrice(), price, "Incorrect product price in the shopping cart");
    }

    @Test(dataProvider = "allBlackTops", dataProviderClass = MyDataProvider.class)
    public void allBlackTops(Link link) {

        ExtentReportsManager.setName("Adding the \"" + link.getLinkText() + "\" product from the \"ALL BLACK TOPS\" category");

        check(link.getLinkText(), ProductCategory.ALL_BLACK_TOPS);
    }

    @Test(dataProvider = "highHeelShoesProducts", dataProviderClass = MyDataProvider.class)
    public void highHeelShoes(Link link) {

        ExtentReportsManager.setName("Adding the \"" + link.getLinkText() + "\" product from the \"HIGH HEEL SHOES\" category");

        check(link.getLinkText(), ProductCategory.HIGH_HEEL_SHOES);
    }

    @Test(dataProvider = "mostWantedProducts", dataProviderClass = MyDataProvider.class)
    public void mostWanted(Link link) {

        ExtentReportsManager.setName("Adding the \"" + link.getLinkText() + "\" product from the \"MOST WANTED\" category");

        check(link.getLinkText(), ProductCategory.MOST_WANTED);
    }

    @Test(dataProvider = "featuredProducts", dataProviderClass = MyDataProvider.class)
    public void featured(Link link) {

        ExtentReportsManager.setName("Adding the \"" + link.getLinkText() + "\" product from the \"FEATURED\" category");

        check(link.getLinkText(), ProductCategory.FEATURED);
    }

    @Test(dataProvider = "trendsProducts", dataProviderClass = MyDataProvider.class)
    public void trends(Link link) {

        ExtentReportsManager.setName("Adding the \"" + link.getLinkText() + "\" product from the \"TRENDS\" category");

        check(link.getLinkText(), ProductCategory.TRENDS);
    }
}
