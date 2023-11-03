package tests.footer;

import qa.base.BaseTest;
import org.json.JSONException;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.footer.Footer;
import qa.provider.MyDataProvider;
import qa.utils.ExtentReportsManager;
import qa.utils.Pair;

public class FooterRecentPostsTests extends BaseTest {

    private Footer footer;

    @BeforeMethod
    public void create() {

        footer = new Footer(getDriver());
    }

    @Test(dataProvider = "recentPosts", dataProviderClass = MyDataProvider.class)
    public void recentPostLinks(Pair<String, String> data) throws JSONException {

        ExtentReportsManager.setName("Clicking the \"" + data.first() + "\" link");

        footer.getRecentPostsSection().clickLink(data.first());

        Assert.assertEquals(getDriver().getCurrentUrl(), data.second(),
                "The page with the address \"" + data.second() + "\" has not been opened");
    }
}
