package tests.footer;

import org.testng.Assert;
import qa.base.BaseTest;
import org.json.JSONException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.footer.Footer;
import qa.provider.MyDataProvider;
import qa.utils.ExtentReportsManager;
import qa.utils.Link;


public class FooterRecentPostsTests extends BaseTest {

    private Footer footer;

    @BeforeMethod
    public void create() {

        footer = new Footer(getDriver());
    }

    @Test(dataProvider = "recentPosts", dataProviderClass = MyDataProvider.class)
    public void recentPostLinks(Link link) throws JSONException {

        ExtentReportsManager.setName("Clicking the \"" + link.getLinkText() + "\" link");

        footer.getRecentPostsSection().clickLink(link.getLinkText());

        Assert.assertEquals(getDriver().getCurrentUrl(), link.getPageURL(),
                "The page with the address \"" + link.getPageURL() + "\" has not been opened");
    }
}
