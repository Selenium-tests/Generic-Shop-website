package tests;

import base.BaseTest;
import org.json.JSONException;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.components.footer.Footer;
import provider.MyDataProvider;
import utils.*;


public class FooterTagTests extends BaseTest {

    private Footer footer;

    @BeforeMethod
    private void create() {

        footer = new Footer(getDriver());
    }

    @Test(priority = 3, dataProvider = "tags", dataProviderClass = MyDataProvider.class)
    public void tags(Pair<String, String> data) throws JSONException {

        //ExtentReportsManager.setName("Tags");

        footer.getTagsSection().clickLink(data.first());

        Assert.assertEquals(getDriver().getCurrentUrl(), data.second());
    }
}
