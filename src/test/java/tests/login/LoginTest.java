package tests.login;

import qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.pageobject.account.AccountNavigation;
import qa.pageobject.LoginForm;
import qa.dataproviders.DataProviders;
import qa.data.Credentials;

public class LoginTest extends BaseTest {

    private LoginForm loginForm;

    @BeforeMethod
    private void create() {

        goToSpecificPage(URLs.LOGIN_PAGE.getName());
        loginForm = new LoginForm(getDriver());
    }

    private void fill(Credentials credentials) throws IllegalAccessException {

        loginForm.setUsername(credentials.getEmail());
        loginForm.setPassword(credentials.getPassword());
        loginForm.clickLoginButton();
    }

    private void waitForErrorMessage() {

        try {
            loginForm.waitForErrorMessage();
        } catch (Exception e) {
            Assert.fail("No error message displayed");
        }
    }

    private void checkErrorMessageContent(String errorMessageContent) {

        Assert.assertTrue(loginForm.getErrorMessageContent().contains(errorMessageContent));
    }

    private void waitForAccountPage() {

        try {
            AccountNavigation accountNavigation = new AccountNavigation(getDriver());
            accountNavigation.waitForContent();
        } catch (Exception e) {
            Assert.fail("The account page has not been opened");
        }
    }

    private void actionsForIncorrectCredentials(Credentials credentials) throws IllegalAccessException {

        fill(credentials);
        waitForErrorMessage();
        checkErrorMessageContent(credentials.getErrorMessage());
    }

    @Test(priority = 1, dataProvider = "incorrectEmailFormat", dataProviderClass = DataProviders.class)
    public void incorrectUsername(Credentials credentials) throws IllegalAccessException {

        actionsForIncorrectCredentials(credentials);
    }

    @Test(priority = 3, dataProvider = "blankEmailField", dataProviderClass = DataProviders.class)
    public void blankUsernameField(Credentials credentials) throws IllegalAccessException {

        actionsForIncorrectCredentials(credentials);
    }

    @Test(priority = 2, dataProvider = "incorrectPassword", dataProviderClass = DataProviders.class)
    public void incorrectPassword(Credentials credentials) throws IllegalAccessException {

        actionsForIncorrectCredentials(credentials);
    }

    @Test(priority = 4, dataProvider = "blankPasswordField", dataProviderClass = DataProviders.class)
    public void blankPasswordField(Credentials credentials) throws IllegalAccessException {

        actionsForIncorrectCredentials(credentials);
    }

    @Test(priority = 5, dataProvider = "correctCredentials", dataProviderClass = DataProviders.class)
    public void correctCredentials(Credentials credentials) throws IllegalAccessException {

        fill(credentials);
        waitForAccountPage();
    }
}
