package tests;

import qa.base.BaseTest;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.account.AccountPage;
import qa.provider.MyDataProvider;
import qa.utils.ExtentReportsManager;
import qa.utils.Link;


public class AccountNavigationTest extends BaseTest {

    private AccountPage accountPage;

    @BeforeMethod
    private void init() throws JSONException {

        accountPage = new AccountPage(getDriver());

        login("karen@gmail.com", "Kvc$11324#");
    }

    @Test(dataProvider = "accountNavigation", dataProviderClass = MyDataProvider.class)
    public void link(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.getLinkText() + "\" link");

        accountPage.getAccountNavigation().clickLink(link.getLinkText());

        Assert.assertEquals(getDriver().getCurrentUrl(), link.getPageURL(),
                "The page with the address \"" + link.getPageURL() + "\" has not been found");
    }
}