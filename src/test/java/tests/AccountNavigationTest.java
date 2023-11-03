package tests;

import qa.base.BaseTest;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.account.AccountPage;
import qa.provider.MyDataProvider;
import qa.utils.ExtentReportsManager;
import qa.utils.Pair;
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

        ExtentReportsManager.setName("Clicking the \"" + data.first() + "\" link");

        accountPage.getAccountNavigation().clickLink(data.first());

        Assert.assertEquals(getDriver().getCurrentUrl(), data.second(),
                "The page with the address \"" + data.second() + "\" has not been found");
    }
}