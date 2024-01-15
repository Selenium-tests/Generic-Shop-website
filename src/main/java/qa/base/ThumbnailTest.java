package qa.base;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import qa.data.Link;
import qa.enums.ThumbnailCategory;
import qa.enums.ThumbnailType;
import qa.enums.URLs;
import qa.pageobject.thumbnails.Thumbnail;
import qa.thumbnailgenerators.ThumbnailProvider;

public class ThumbnailTest extends BaseTest {

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
    }

    private Thumbnail getThumbnail(ThumbnailType type, ThumbnailCategory category, Link link) {

        return ThumbnailProvider.getFactory(type).createThumbnail(getDriver(), category, link.getLinkText());
    }

    protected void check(ThumbnailType type, ThumbnailCategory category, Link link) throws IllegalAccessException {

        getThumbnail(type, category, link).clickLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), link.getPageURL(),
                "The page with the address \"" + link.getPageURL() + "\" has not been found");
    }
}
