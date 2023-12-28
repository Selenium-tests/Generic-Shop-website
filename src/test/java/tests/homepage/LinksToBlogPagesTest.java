package tests.homepage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.ThumbnailCategory;
import qa.enums.ThumbnailType;
import qa.enums.URLs;
import qa.extentreports.ExtentReportsManager;
import qa.pageobject.thumbnails.Thumbnail;
import qa.provider.MyDataProvider;
import qa.data.Link;
import qa.thumbnailgenerators.ThumbnailProvider;

public class LinksToBlogPagesTest extends BaseTest {

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
    }

    private void check(ThumbnailCategory category, Link link) throws IllegalAccessException {

        Thumbnail thumbnail = ThumbnailProvider
                .getFactory(ThumbnailType.BLOG)
                .createThumbnail(getDriver(), category, link.getLinkText());

        thumbnail.clickLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), link.getPageURL(),
                "The page with the address \"" + link.getPageURL() + "\" has not been found");
    }

    @Test(dataProvider = "blogs1", dataProviderClass = MyDataProvider.class)
    public void group1(Link link) throws IllegalAccessException {

        ExtentReportsManager.setName("Clicking the \"" + link.getLinkText() + "\" link in the \"BLOGS\" section");

        check(ThumbnailCategory.RECENT_1, link);
    }

    @Test(dataProvider = "blogs2", dataProviderClass = MyDataProvider.class)
    public void group2(Link link) throws IllegalAccessException {

        ExtentReportsManager.setName("Clicking the \"" + link.getLinkText() + "\" link in the \"BLOGS\" section");

        check(ThumbnailCategory.RECENT_2, link);
    }
}
