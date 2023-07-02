package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.components.header.Header;
import provider.MyDataProvider;
import utils.ExtentReportsManager;
import utils.FuncInterface;
import utils.Pair;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeClass
    private void init() {

        Header header = new Header(getDriver());
        loginPage = new LoginPage(getDriver());
        header.clickAccountButton();
    }

    private void fillAndCheck(List<Pair<String, String>> data, FuncInterface funcInterface) throws IOException {

        for (Pair<String, String> datum : data) {

            loginPage.clearAll();
            loginPage.setUsername(datum.first());
            loginPage.setPassword(datum.second());
            loginPage.clickLoginButton();

            funcInterface.run();
        }
    }
    @Test(priority = 1, dataProvider = "incorrectUsername", dataProviderClass = MyDataProvider.class)
    public void incorrectUsername(List<Pair<String, String>> data) throws IOException {

        ExtentReportsManager.setName("Incorrect email address");
        fillAndCheck(data, ()->{ Assert.assertTrue(loginPage.isErrorMessageDisplayed()); });
    }

    @Test(priority = 3, dataProvider = "noUsername", dataProviderClass = MyDataProvider.class)
    public void noUsername(List<Pair<String, String>> data) throws IOException {

        ExtentReportsManager.setName("Blank username field");
        fillAndCheck(data, ()->{ Assert.assertTrue(loginPage.isErrorMessageDisplayed()); });
    }

    @Test(priority = 2, dataProvider = "incorrectPassword", dataProviderClass = MyDataProvider.class)
    public void incorrectPassword(List<Pair<String, String>> data) throws IOException {

        ExtentReportsManager.setName("Incorrect password");
        fillAndCheck(data, ()->{ Assert.assertTrue(loginPage.isErrorMessageDisplayed()); });
    }

    @Test(priority = 4, dataProvider = "noPassword", dataProviderClass = MyDataProvider.class)
    public void noPassword(List<Pair<String, String>> data) throws IOException {

        ExtentReportsManager.setName("Blank password field");
        fillAndCheck(data, ()->{ Assert.assertTrue(loginPage.isErrorMessageDisplayed()); });
    }

    @Test(priority = 5, dataProvider = "correctLoginData", dataProviderClass = MyDataProvider.class)
    public void correctData(List<Pair<String, String>> data) throws AWTException, IOException {

        ExtentReportsManager.setName("Correct data");
        AccountPage accountPage = new AccountPage(getDriver());

        fillAndCheck(data, ()->{ Assert.assertTrue(accountPage.isDashboardLinkDisplayed()); });
    }
}
