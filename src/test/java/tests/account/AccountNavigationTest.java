package tests.account;

import qa.base.BaseTest;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.extentreports.ExtentReportsManager;
import qa.helpers.Authentication;
import qa.pageobject.account.AccountPage;
import qa.provider.MyDataProvider;
import qa.records.Link;


public class AccountNavigationTest extends BaseTest {

    private AccountPage accountPage;

    @BeforeMethod
    private void init() throws JSONException, IllegalAccessException {

        goToSpecificPage(URLs.LOGIN_PAGE.getName());
        accountPage = new AccountPage(getDriver());
        Authentication.loginWithCredentials(getDriver());
    }

    @Test(dataProvider = "accountNavigation", dataProviderClass = MyDataProvider.class)
    public void link(Link link) throws IllegalAccessException {

        ExtentReportsManager.setName("Clicking the \"" + link.linkText() + "\" link");

        accountPage.getAccountNavigation().clickLink(link.linkText());

        Assert.assertEquals(getDriver().getCurrentUrl(), link.pageURL(),
                "The page with the address \"" + link.pageURL() + "\" has not been found");
    }
}