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


public class FooterTagTests extends BaseTest {

    private Footer footer;

    @BeforeMethod
    private void create() {

        footer = new Footer(getDriver());
    }

    @Test(priority = 3, dataProvider = "tags", dataProviderClass = MyDataProvider.class)
    public void tags(Pair<String, String> data) throws JSONException {

        ExtentReportsManager.setName("CLicking the \"" + data.first() + "\" button");

        footer.getTagsSection().clickLink(data.first());

        Assert.assertEquals(getDriver().getCurrentUrl(), data.second(),
                "The page with the address \"" + data.second() + "\" has not been opened");
    }
}
