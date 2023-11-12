package tests.shoppingcart;

import org.testng.Assert;
import qa.pageobject.shoppingcart.Row;
import qa.base.BaseTest;
import qa.enums.SiteContentSections;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.pageobject.SiteContentSection;
import qa.pageobject.header.Header;
import qa.pageobject.thumbnails.ProductThumbnail;
import qa.provider.MyDataProvider;
import qa.utils.ExtentReportsManager;
import qa.utils.Pair;

public class AddingProductToCartFromHomePageTest extends BaseTest {

    private Header header;
    private SiteContentSection section;
    private ShoppingCart shoppingCart;

    @BeforeMethod
    private void create() {

        header = new Header(getDriver());
        section = new SiteContentSection(getDriver());
        shoppingCart = new ShoppingCart(getDriver());
    }

    public void check(String productName, SiteContentSections sections) {

        ProductThumbnail productThumbnail = section.getProductThumbnail(getDriver(), productName, sections);

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
    public void allBlackTopsSection(Pair<String, String> data) {

        ExtentReportsManager.setName("Adding the \"" + data.first() + "\" product from the \"ALL BLACK TOPS\" category");

        check(data.first(), SiteContentSections.ALL_BLACK_TOPS);
    }

    @Test(dataProvider = "highHeelShoesProducts", dataProviderClass = MyDataProvider.class)
    public void highHeelShoesSection(Pair<String, String> data) {

        ExtentReportsManager.setName("Adding the \"" + data.first() + "\" product from the \"HIGH HEEL SHOES\" category");

        check(data.first(), SiteContentSections.HIGH_HEEL_SHOES);
    }

    @Test(dataProvider = "mostWantedProducts", dataProviderClass = MyDataProvider.class)
    public void mostWantedSection(Pair<String, String> data) {

        ExtentReportsManager.setName("Adding the \"" + data.first() + "\" product from the \"MOST WANTED\" category");

        check(data.first(), SiteContentSections.MOST_WANTED);
    }

    @Test(dataProvider = "featuredProducts", dataProviderClass = MyDataProvider.class)
    public void featuredSection(Pair<String, String> data) {

        ExtentReportsManager.setName("Adding the \"" + data.first() + "\" product from the \"FEATURED\" category");

        check(data.first(), SiteContentSections.FEATURED);
    }

    @Test(dataProvider = "trendsProducts", dataProviderClass = MyDataProvider.class)
    public void trendsSection(Pair<String, String> data) {

        ExtentReportsManager.setName("Adding the \"" + data.first() + "\" product from the \"TRENDS\" category");

        check(data.first(), SiteContentSections.TRENDS);
    }
}
