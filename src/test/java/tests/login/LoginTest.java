package tests.login;

import tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.CredentialsDataProviders;
import qa.enums.URLs;
import qa.pageobject.account.AccountNavigation;
import qa.pageobject.loginform.LoginForm;
import qa.models.Credentials;
import qa.support.constans.DataProviderNames;

public class LoginTest extends BaseTest {

    private LoginForm loginForm;

    @BeforeMethod
    private void create() {

        goToSpecificPage(URLs.LOGIN_PAGE.getName());
        loginForm = new LoginForm(getDriver());
    }

    private void fill(Credentials credentials) throws IllegalAccessException {

        loginForm.setUsername(credentials.getEmailOrUsername());
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
        checkErrorMessageContent(credentials.getMessage());
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_USERNAME, dataProviderClass = CredentialsDataProviders.class)
    public void incorrectUsername(Credentials credentials) throws IllegalAccessException {

        actionsForIncorrectCredentials(credentials);
    }

    @Test(dataProvider = DataProviderNames.BLANK_USERNAME_FIELD, dataProviderClass = CredentialsDataProviders.class)
    public void blankUsernameField(Credentials credentials) throws IllegalAccessException {

        actionsForIncorrectCredentials(credentials);
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_PASSWORD, dataProviderClass = CredentialsDataProviders.class)
    public void incorrectPassword(Credentials credentials) throws IllegalAccessException {

        actionsForIncorrectCredentials(credentials);
    }

    @Test(dataProvider = DataProviderNames.BLANK_PASSWORD_FIELD, dataProviderClass = CredentialsDataProviders.class)
    public void blankPasswordField(Credentials credentials) throws IllegalAccessException {

        actionsForIncorrectCredentials(credentials);
    }

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = CredentialsDataProviders.class)
    public void correct(Credentials credentials) throws IllegalAccessException {

        fill(credentials);
        waitForAccountPage();
    }
}
