package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.components.header.Header;
import provider.MyDataProvider;
import utils.ExtentReportsManager;

import java.util.List;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeClass
    private void init() {

        Header header = new Header(getDriver());
        loginPage = new LoginPage(getDriver());
        header.clickAccountButton();
    }

    private void fillAndCheck(List<String[]> data) {

        for (String[] datum : data) {

            loginPage.clearAll();
            loginPage.setUsername(datum[0]);
            loginPage.setPassword(datum[1]);
            loginPage.clickLoginButton();

            Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        }
    }
    @Test(priority = 1, dataProvider = "getIncorrectUsernameData", dataProviderClass = MyDataProvider.class)
    public void incorrectEmailAddress(List<String[]> data) {

        ExtentReportsManager.setName("Incorrect email address");
        fillAndCheck(data);
    }

    @Test(priority = 3, dataProvider = "getBlankUsernameFieldData", dataProviderClass = MyDataProvider.class)
    public void blankUsernameField(List<String[]> data) {

        ExtentReportsManager.setName("Blank username field");
        fillAndCheck(data);
    }

    @Test(priority = 2, dataProvider = "getIncorrectPasswordData", dataProviderClass = MyDataProvider.class)
    public void incorrectPassword(List<String[]> data) {

        ExtentReportsManager.setName("Incorrect password");
        fillAndCheck(data);
    }

    @Test(priority = 4, dataProvider = "getBlankPasswordFieldData", dataProviderClass = MyDataProvider.class)
    public void blankPasswordField(List<String[]> data) {

        ExtentReportsManager.setName("Blank password field");
        fillAndCheck(data);
    }

    @Test(priority = 5, dataProvider = "getCorrectLoginData", dataProviderClass = MyDataProvider.class)
    public void correctData(List<String[]> data) {

        ExtentReportsManager.setName("Correct data");

        loginPage.clearAll();
        loginPage.setUsername(data.get(0)[0]);
        loginPage.setPassword(data.get(0)[0]);
        loginPage.clickLoginButton();

        Assert.assertFalse(loginPage.isErrorMessageDisplayed());
    }
}
