package tests;

import base.BaseTest;
import enums.SiteContentSections;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.components.SiteContentSection;
import provider.MyDataProvider;
import utils.Pair;

public class LinksTest extends BaseTest {

    private SiteContentSection siteContentSection;

    @BeforeMethod
    public void create() {

        siteContentSection = new SiteContentSection(getDriver());
    }

    private void check(SiteContentSections sections, Pair<String, String> data) {

        siteContentSection.clickLink(data.first(), sections);

        Assert.assertEquals(getDriver().getCurrentUrl(), data.second());
    }

    @Test(dataProvider = "allBlackTops", dataProviderClass = MyDataProvider.class)
    public void allBlackTops(Pair<String, String> data) {

        check(SiteContentSections.ALL_BLACK_TOPS, data);
    }

    @Test(dataProvider = "highHeelShoesProducts", dataProviderClass = MyDataProvider.class)
    public void highHeelShoes(Pair<String, String> data) {

        check(SiteContentSections.HIGH_HEEL_SHOES, data);
    }

    @Test(dataProvider = "mostWantedProducts", dataProviderClass = MyDataProvider.class)
    public void mostWanted(Pair<String, String> data) {

        check(SiteContentSections.MOST_WANTED, data);
    }

    @Test(dataProvider = "featuredProducts", dataProviderClass = MyDataProvider.class)
    public void featured(Pair<String, String> data) {

        check(SiteContentSections.FEATURED, data);
    }

    @Test(dataProvider = "trendsProducts", dataProviderClass = MyDataProvider.class)
    public void trends(Pair<String, String> data) {

        check(SiteContentSections.TRENDS, data);
    }

    @Test(dataProvider = "blogs", dataProviderClass = MyDataProvider.class)
    public void blogs(Pair<String, String> data) {

        check(SiteContentSections.FROM_THE_BLOG, data);
    }
}
