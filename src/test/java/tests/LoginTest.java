package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.components.Header;
import provider.MyDataProvider;
import java.util.List;

public class LoginTest extends BaseTest {

    private void helper(List<String[]> data) {

        Header header = new Header(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        header.clickAccountButton();

        for (String[] datum : data) {

            loginPage.clearAll();
            loginPage.setUsername(datum[0]);
            loginPage.setPassword(datum[1]);
            loginPage.clickLoginButton();

            getSoftAssert().assertTrue(loginPage.isErrorMessageDisplayed());
        }
    }
    @Test(dataProvider = "getIncorrectUsernameData", dataProviderClass = MyDataProvider.class)
    public void incorrectEmailAddress(List<String[]> data) {

        helper(data);
    }

    @Test(dataProvider = "getBlankUsernameFieldData", dataProviderClass = MyDataProvider.class)
    public void blankUsernameField(List<String[]> data) {

        helper(data);
    }

    @Test(dataProvider = "getIncorrectPasswordData", dataProviderClass = MyDataProvider.class)
    public void incorrectPassword(List<String[]> data) {

        helper(data);
    }

    @Test(dataProvider = "getBlankPasswordFieldData", dataProviderClass = MyDataProvider.class)
    public void blankPasswordField(List<String[]> data) {

        helper(data);
    }

    @Test(dataProvider = "getCorrectLoginData", dataProviderClass = MyDataProvider.class)
    public void correctData(List<String[]> data) {

        Header header = new Header(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        header.clickAccountButton();

        loginPage.setUsername(data.get(0)[0]);
        loginPage.setPassword(data.get(0)[0]);
        loginPage.clickLoginButton();
    }
}
