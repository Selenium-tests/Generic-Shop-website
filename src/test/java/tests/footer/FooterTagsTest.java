package tests.footer;

import org.testng.Assert;
import qa.base.BaseTest;
import org.json.JSONException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.pageobject.footer.Footer;
import qa.provider.MyDataProvider;
import qa.data.Link;


public class FooterTagsTest extends BaseTest {

    private Footer footer;

    @BeforeMethod
    private void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
        footer = new Footer(getDriver());
    }

    @Test(priority = 3, dataProvider = "tags", dataProviderClass = MyDataProvider.class)
    public void tags(Link link) throws JSONException, IllegalAccessException {

        //ExtentReportsManager.setName("CLicking the \"" + link.linkText() + "\" button");

        footer.getTagsSection().clickLink(link.getLinkText());

        Assert.assertEquals(getDriver().getCurrentUrl(), link.getPageURL(),
                "The page with the address \"" + link.getPageURL() + "\" has not been opened");
    }
}