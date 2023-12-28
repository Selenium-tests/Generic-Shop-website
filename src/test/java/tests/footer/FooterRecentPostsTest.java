package tests.footer;

import org.testng.Assert;
import qa.base.BaseTest;
import org.json.JSONException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.pageobject.footer.Footer;
import qa.provider.MyDataProvider;
import qa.extentreports.ExtentReportsManager;
import qa.data.Link;


public class FooterRecentPostsTest extends BaseTest {

    private Footer footer;

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
        footer = new Footer(getDriver());
    }

    @Test(dataProvider = "recentPosts", dataProviderClass = MyDataProvider.class)
    public void recentPostLinks(Link link) throws JSONException, IllegalAccessException {

        ExtentReportsManager.setName("Clicking the \"" + link.getLinkText() + "\" link");

        footer.getRecentPostsSection().clickLink(link.getLinkText());

        Assert.assertEquals(getDriver().getCurrentUrl(), link.getPageURL(),
                "The page with the address \"" + link.getPageURL() + "\" has not been opened");
    }
}
