package tests;

import base.BaseTest;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import provider.MyDataProvider;
import utils.Pair;
import java.awt.*;

public class AccountNavigationTest extends BaseTest {

    private AccountPage accountPage;

    @BeforeMethod
    private void init() throws AWTException, JSONException {

        accountPage = new AccountPage(getDriver());

        login("karen@gmail.com", "Kvc$11324#");
    }

    @Test(dataProvider = "accountNavigation", dataProviderClass = MyDataProvider.class)
    public void link(Pair<String, String> data) {

        //ExtentReportsManager.setName("Link to Dashboard page");

        accountPage.getAccountNavigation().clickLink(data.first());

        Assert.assertEquals(getDriver().getCurrentUrl(), data.second());
    }
}