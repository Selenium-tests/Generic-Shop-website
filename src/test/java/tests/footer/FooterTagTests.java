package tests.footer;

import org.testng.Assert;
import qa.base.BaseTest;
import org.json.JSONException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.footer.Footer;
import qa.provider.MyDataProvider;
import qa.extentreports.ExtentReportsManager;
import qa.records.Link;


public class FooterTagTests extends BaseTest {

    private Footer footer;

    @BeforeMethod
    private void create() {

        footer = new Footer(getDriver());
    }

    @Test(priority = 3, dataProvider = "tags", dataProviderClass = MyDataProvider.class)
    public void tags(Link link) throws JSONException {

        ExtentReportsManager.setName("CLicking the \"" + link.linkText() + "\" button");

        footer.getTagsSection().clickLink(link.linkText());

        Assert.assertEquals(getDriver().getCurrentUrl(), link.pageURL(),
                "The page with the address \"" + link.pageURL() + "\" has not been opened");
    }
}
