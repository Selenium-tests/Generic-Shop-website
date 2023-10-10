package tests;

/*import base.BaseTest;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountPage;
import utils.ExtentReportsManager;
import utils.JSONReader;
import utils.Pair;

import java.awt.*;
import java.util.List;

public class AccountPageLinksTest extends BaseTest {

    private AccountPage accountPage;
    private String[] expectedURLs;

    @BeforeClass
    private void init() throws AWTException, JSONException {

        accountPage = new AccountPage(getDriver());
        expectedURLs = JSONReader.get("URLs", "accountPage");

        List<Pair<String, String>> data = JSONReader.get("login", "correct", new Pair<>("email", "password"));
        login(data);
    }

    @Test(priority = 2)
    public void linkToDashboardPage() {

        ExtentReportsManager.setName("Link to Dashboard page");

        accountPage.clickDashboardLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURLs[0]);
    }

    @Test(priority = 3)
    public void linkToOrdersPage() {

        ExtentReportsManager.setName("Link to Orders page");

        accountPage.clickOrdersLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURLs[1]);
    }

    @Test(priority = 4)
    public void linkToDownloadsPage() {

        ExtentReportsManager.setName("Link to Downloads page");

        accountPage.clickDownloadsLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURLs[2]);
    }

    @Test(priority = 5)
    public void linkToAddressesPage() {

        ExtentReportsManager.setName("Link to Addresses page");

        accountPage.clickAddressesLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURLs[3]);
    }

    @Test(priority = 6)
    public void linkToAccountDetailsPage() {

        ExtentReportsManager.setName("Link to Account details page");

        accountPage.clickAccountDetailsLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURLs[4]);
    }

    @Test(priority = 7)
    public void linkToLogoutPage() {

        ExtentReportsManager.setName("Link to Logout page");

        accountPage.clickLogoutLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURLs[5]);
    }
}*/