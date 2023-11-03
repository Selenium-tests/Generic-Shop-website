package tests;

import qa.base.BaseTest;
import qa.enums.SiteContentSections;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.SiteContentSection;
import qa.provider.MyDataProvider;
import qa.utils.ExtentReportsManager;
import qa.utils.Pair;

public class LinksTest extends BaseTest {

    private SiteContentSection siteContentSection;

    @BeforeMethod
    public void create() {

        siteContentSection = new SiteContentSection(getDriver());
    }

    private void check(SiteContentSections sections, Pair<String, String> data) {

        siteContentSection.clickLink(data.first(), sections);

        Assert.assertEquals(getDriver().getCurrentUrl(), data.second(),
                "The page with the address \"" + data.second() + "\" has not been found");
    }

    @Test(dataProvider = "allBlackTops", dataProviderClass = MyDataProvider.class)
    public void allBlackTops(Pair<String, String> data) {

        ExtentReportsManager.setName("Clicking the \"" + data.first() + "\" link in the \"ALL BLACK TOP\" section");

        check(SiteContentSections.ALL_BLACK_TOPS, data);
    }

    @Test(dataProvider = "highHeelShoesProducts", dataProviderClass = MyDataProvider.class)
    public void highHeelShoes(Pair<String, String> data) {

        ExtentReportsManager.setName("Clicking the \"" + data.first() + "\" link in the \"HIGH HEEL SHOES\" section");

        check(SiteContentSections.HIGH_HEEL_SHOES, data);
    }

    @Test(dataProvider = "mostWantedProducts", dataProviderClass = MyDataProvider.class)
    public void mostWanted(Pair<String, String> data) {

        ExtentReportsManager.setName("Clicking the \"" + data.first() + "\" link in the \"MOST WANTED\" section");

        check(SiteContentSections.MOST_WANTED, data);
    }

    @Test(dataProvider = "featuredProducts", dataProviderClass = MyDataProvider.class)
    public void featured(Pair<String, String> data) {

        ExtentReportsManager.setName("Clicking the \"" + data.first() + "\" link in the \"FEATURED\" section");

        check(SiteContentSections.FEATURED, data);
    }

    @Test(dataProvider = "trendsProducts", dataProviderClass = MyDataProvider.class)
    public void trends(Pair<String, String> data) {

        ExtentReportsManager.setName("Clicking the \"" + data.first() + "\" link in the \"TRENDS\" section");

        check(SiteContentSections.TRENDS, data);
    }

    @Test(dataProvider = "blogs", dataProviderClass = MyDataProvider.class)
    public void blogs(Pair<String, String> data) {

        ExtentReportsManager.setName("Clicking the \"" + data.first() + "\" link in the \"BLOGS\" section");

        check(SiteContentSections.FROM_THE_BLOG, data);
    }
}
