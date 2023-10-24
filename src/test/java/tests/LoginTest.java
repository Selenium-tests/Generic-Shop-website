package tests;

import qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.account.AccountPage;
import qa.pageobject.LoginPage;
import qa.pageobject.header.Header;
import qa.provider.MyDataProvider;
import qa.utils.Pair;
import java.awt.*;
import java.util.function.Consumer;

public class LoginTest extends BaseTest {

    @BeforeMethod
    private void create() {

        Header header = new Header(getDriver());
        header.clickAccountButton();
    }

    private <T> void check(Consumer<T> consumer, T object, Pair<String, String> data) {

        getLoginPage().clearAll();
        getLoginPage().setUsername(data.first());
        getLoginPage().setPassword(data.second());
        getLoginPage().clickLoginButton();

        consumer.accept(object);
    }

    @Test(priority = 1, dataProvider = "incorrectEmailFormat", dataProviderClass = MyDataProvider.class)
    public void incorrectUsername(Pair<String, String> data) {

        //ExtentReportsManager.setName("Incorrect email address");

        check((LoginPage lp)-> Assert.assertTrue(lp.isErrorMessageDisplayed()), getLoginPage(), data);
    }

    @Test(priority = 3, dataProvider = "blankEmailField", dataProviderClass = MyDataProvider.class)
    public void blankUsernameField(Pair<String, String> data) {

        //ExtentReportsManager.setName("Blank username field");

        check((LoginPage lp)-> Assert.assertTrue(lp.isErrorMessageDisplayed()), getLoginPage(), data);
    }

    @Test(priority = 2, dataProvider = "incorrectPassword", dataProviderClass = MyDataProvider.class)
    public void incorrectPassword(Pair<String, String> data) {

        //ExtentReportsManager.setName("Incorrect password");

        check((LoginPage lp)-> Assert.assertTrue(lp.isErrorMessageDisplayed()), getLoginPage(), data);
    }

    @Test(priority = 4, dataProvider = "blankPasswordField", dataProviderClass = MyDataProvider.class)
    public void blankPasswordField(Pair<String, String> data) {

        //ExtentReportsManager.setName("Blank password field");

        check((LoginPage lp)-> Assert.assertTrue(lp.isErrorMessageDisplayed()), getLoginPage(), data);
    }

    @Test(priority = 5, dataProvider = "correctCredentials", dataProviderClass = MyDataProvider.class)
    public void correctCredentials(Pair<String, String> data) throws AWTException {

        //ExtentReportsManager.setName("Correct credentials");

        check((AccountPage ap)-> Assert.assertTrue(ap.isDashboardLinkDisplayed()), new AccountPage(getDriver()), data);
    }
}
