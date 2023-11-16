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


public class FooterTagTests extends BaseTest {

    private Footer footer;

    @BeforeMethod
    private void create() {

        footer = new Footer(getDriver());
    }

    @Test(priority = 3, dataProvider = "tags", dataProviderClass = MyDataProvider.class)
    public void tags(Link link) throws JSONException {

        ExtentReportsManager.setName("CLicking the \"" + link.getLinkText() + "\" button");

        footer.getTagsSection().clickLink(link.getLinkText());

        Assert.assertEquals(getDriver().getCurrentUrl(), link.getPageURL(),
                "The page with the address \"" + link.getPageURL() + "\" has not been opened");
    }
}
