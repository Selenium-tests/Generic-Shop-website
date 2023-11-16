package tests;

import qa.base.BaseTest;
import qa.enums.SiteContentSections;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.SiteContentSection;
import qa.provider.MyDataProvider;
import qa.utils.ExtentReportsManager;
import qa.utils.Link;


public class LinksTest extends BaseTest {

    private SiteContentSection siteContentSection;

    @BeforeMethod
    public void create() {

        siteContentSection = new SiteContentSection(getDriver());
    }

    private void check(SiteContentSections sections, Link link) {

        siteContentSection.clickLink(link.getLinkText(), sections);

        Assert.assertEquals(getDriver().getCurrentUrl(), link.getPageURL(),
                "The page with the address \"" + link.getPageURL() + "\" has not been found");
    }

    @Test(dataProvider = "allBlackTops", dataProviderClass = MyDataProvider.class)
    public void allBlackTops(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.getLinkText() + "\" link in the \"ALL BLACK TOP\" section");

        check(SiteContentSections.ALL_BLACK_TOPS, link);
    }

    @Test(dataProvider = "highHeelShoesProducts", dataProviderClass = MyDataProvider.class)
    public void highHeelShoes(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.getLinkText() + "\" link in the \"HIGH HEEL SHOES\" section");

        check(SiteContentSections.HIGH_HEEL_SHOES, link);
    }

    @Test(dataProvider = "mostWantedProducts", dataProviderClass = MyDataProvider.class)
    public void mostWanted(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.getLinkText() + "\" link in the \"MOST WANTED\" section");

        check(SiteContentSections.MOST_WANTED, link);
    }

    @Test(dataProvider = "featuredProducts", dataProviderClass = MyDataProvider.class)
    public void featured(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.getLinkText() + "\" link in the \"FEATURED\" section");

        check(SiteContentSections.FEATURED, link);
    }

    @Test(dataProvider = "trendsProducts", dataProviderClass = MyDataProvider.class)
    public void trends(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.getLinkText() + "\" link in the \"TRENDS\" section");

        check(SiteContentSections.TRENDS, link);
    }

    @Test(dataProvider = "blogs", dataProviderClass = MyDataProvider.class)
    public void blogs(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.getLinkText() + "\" link in the \"BLOGS\" section");

        check(SiteContentSections.FROM_THE_BLOG, link);
    }
}
