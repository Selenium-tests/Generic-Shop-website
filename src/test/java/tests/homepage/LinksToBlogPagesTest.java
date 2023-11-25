package tests.homepage;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.ThumbnailCategory;
import qa.enums.ThumbnailType;
import qa.extentreports.ExtentReportsManager;
import qa.pageobject.thumbnails.Thumbnail;
import qa.provider.MyDataProvider;
import qa.records.Link;
import qa.thumbnailgenerators.ThumbnailProvider;

public class LinksToBlogPagesTest extends BaseTest {

    private void check(ThumbnailCategory category, Link link) {

        Thumbnail thumbnail = ThumbnailProvider
                .getFactory(ThumbnailType.BLOG)
                .createThumbnail(getDriver(), category, link.linkText());

        thumbnail.clickLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), link.pageURL(),
                "The page with the address \"" + link.pageURL() + "\" has not been found");
    }

    @Test(dataProvider = "blogs1", dataProviderClass = MyDataProvider.class)
    public void group1(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.linkText() + "\" link in the \"BLOGS\" section");

        check(ThumbnailCategory.RECENT_1, link);
    }

    @Test(dataProvider = "blogs2", dataProviderClass = MyDataProvider.class)
    public void group2(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.linkText() + "\" link in the \"BLOGS\" section");

        check(ThumbnailCategory.RECENT_2, link);
    }
}
