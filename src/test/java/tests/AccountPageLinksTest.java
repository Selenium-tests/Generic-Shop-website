package tests;

import base.BaseTest;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.components.header.Header;
import provider.MyDataProvider;
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
    }

    @Test(priority = 1, dataProvider = "correctLoginData", dataProviderClass = MyDataProvider.class)
    public void correctLogin(List<Pair<String, String>> data) {

        ExtentReportsManager.setName("Correct login");

        Header header = new Header(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        header.clickAccountButton();

        loginPage.setUsername(data.get(0).first());
        loginPage.setPassword(data.get(0).second());
        loginPage.clickLoginButton();
    }

    @Test(priority = 2)
    private void linkToDashboardPage() {

        ExtentReportsManager.setName("Link to Dashboard page");

        accountPage.clickDashboardLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURLs[0]);
    }

    @Test(priority = 3)
    private void linkToOrdersPage() {

        ExtentReportsManager.setName("Link to Orders page");

        accountPage.clickOrdersLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURLs[1]);
    }

    @Test(priority = 4)
    private void linkToDownloadsPage() {

        ExtentReportsManager.setName("Link to Downloads page");

        accountPage.clickDownloadsLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURLs[2]);
    }

    @Test(priority = 5)
    private void linkToAddressesPage() {

        ExtentReportsManager.setName("Link to Addresses page");

        accountPage.clickAddressesLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURLs[3]);
    }

    @Test(priority = 6)
    private void linkToAccountDetailsPage() {

        ExtentReportsManager.setName("Link to Account details page");

        accountPage.clickAccountDetailsLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURLs[4]);
    }

    @Test(priority = 7)
    private void linkToLogoutPage() {

        ExtentReportsManager.setName("Link to Logout page");

        accountPage.clickLogoutLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURLs[5]);
    }
}
