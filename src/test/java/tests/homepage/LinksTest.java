package tests.homepage;

import qa.base.BaseTest;
import qa.enums.ProductCategory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.SiteContentSection;
import qa.provider.MyDataProvider;
import qa.extentreports.ExtentReportsManager;
import qa.records.Link;


public class LinksTest extends BaseTest {

    private SiteContentSection siteContentSection;

    @BeforeMethod
    public void create() {

        siteContentSection = new SiteContentSection(getDriver());
    }

    private void check(ProductCategory category, Link link) {

        siteContentSection.clickLink(link.linkText(), category);

        Assert.assertEquals(getDriver().getCurrentUrl(), link.pageURL(),
                "The page with the address \"" + link.pageURL() + "\" has not been found");
    }

    @Test(dataProvider = "allBlackTops", dataProviderClass = MyDataProvider.class)
    public void allBlackTops(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.linkText() + "\" link in the \"ALL BLACK TOP\" section");

        check(ProductCategory.ALL_BLACK_TOPS, link);
    }

    @Test(dataProvider = "highHeelShoesProducts", dataProviderClass = MyDataProvider.class)
    public void highHeelShoes(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.linkText() + "\" link in the \"HIGH HEEL SHOES\" section");

        check(ProductCategory.HIGH_HEEL_SHOES, link);
    }

    @Test(dataProvider = "mostWantedProducts", dataProviderClass = MyDataProvider.class)
    public void mostWanted(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.linkText() + "\" link in the \"MOST WANTED\" section");

        check(ProductCategory.MOST_WANTED, link);
    }

    @Test(dataProvider = "featuredProducts", dataProviderClass = MyDataProvider.class)
    public void featured(Link link) {

        //ExtentReportsManager.setName("Clicking the \"" + link.linkText() + "\" link in the \"FEATURED\" section");

        check(ProductCategory.FEATURED, link);
    }

    @Test(dataProvider = "trendsProducts", dataProviderClass = MyDataProvider.class)
    public void trends(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.linkText() + "\" link in the \"TRENDS\" section");

        check(ProductCategory.TRENDS, link);
    }

    @Test(dataProvider = "blogs", dataProviderClass = MyDataProvider.class)
    public void blogs(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.linkText() + "\" link in the \"BLOGS\" section");

        check(ProductCategory.FROM_THE_BLOG, link);
    }
}
