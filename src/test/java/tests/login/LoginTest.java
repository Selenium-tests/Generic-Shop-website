package tests.login;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.CredentialsDataProviders;
import qa.support.constans.URLs;
import qa.pageobject.account.AccountNavigation;
import qa.pageobject.loginform.LoginForm;
import qa.models.Credentials;
import qa.support.constans.DataProviderNames;

public class LoginTest extends BaseTest {

    private LoginForm loginForm;

    @BeforeMethod
    private void prepare() {

        goToPage(URLs.LOGIN_PAGE);
        loginForm = new LoginForm(getDriver());
    }

    private void setAllureParameters(Credentials credentials) {

        Allure.parameter("Username", credentials.getEmailOrUsername());
        Allure.parameter("Password", credentials.getPassword());
    }

    private void waitForErrorMessage() {

        try {
            loginForm.waitForErrorMessage();
        } catch (Exception e) {
            Assert.fail("No error message displayed");
        }
    }

    private void checkErrorMessageContent(String errorMessageContent) {

        Assert.assertTrue(loginForm.getErrorMessageContent().contains(errorMessageContent), "Incorrect the error message content");
    }

    private void waitForAccountPage() {

        try {
            AccountNavigation accountNavigation = new AccountNavigation(getDriver());
            accountNavigation.waitForContent();
        } catch (Exception e) {
            Assert.fail("The account page has not been opened");
        }
    }

    @Test(priority = 1, dataProvider = DataProviderNames.INCORRECT_USERNAME, dataProviderClass = CredentialsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Login")
    @Tag("Fields")
    @Link(name = "Login page", value = URLs.LOGIN_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(63)
    @QaseTitle("Attempting to log in using an incorrect username or email address")
    @Description("Attempting to log in using an incorrect username or email address")
    public void incorrectUsername(Credentials credentials) throws IllegalAccessException {

        setAllureParameters(credentials);

        loginForm
                .setUsername(credentials.getEmailOrUsername())
                .setPassword(credentials.getPassword())
                .clickLoginButton();

        waitForErrorMessage();
        checkErrorMessageContent(credentials.getMessage());
    }

    @Test(priority = 4, dataProvider = DataProviderNames.BLANK_USERNAME_FIELD, dataProviderClass = CredentialsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Login")
    @Tag("Fields")
    @Link(name = "Login page", value = URLs.LOGIN_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(64)
    @QaseTitle("Attempting to log in without providing input for the \"Username or email address\" field")
    @Description("Attempting to log in without providing input for the \"Username or email address\" field")
    public void blankUsernameField(Credentials credentials) throws IllegalAccessException {

        setAllureParameters(credentials);

        loginForm
                .setPassword(credentials.getPassword())
                .clickLoginButton();

        waitForErrorMessage();
        checkErrorMessageContent(credentials.getMessage());
    }

    @Test(priority = 3, dataProvider = DataProviderNames.INCORRECT_PASSWORD, dataProviderClass = CredentialsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Login")
    @Tag("Fields")
    @Link(name = "Login page", value = URLs.LOGIN_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(65)
    @QaseTitle("Attempting to log in using an incorrect password")
    @Description("Attempting to log in using an incorrect password")
    public void incorrectPassword(Credentials credentials) throws IllegalAccessException {

        setAllureParameters(credentials);

        loginForm
                .setUsername(credentials.getEmailOrUsername())
                .setPassword(credentials.getPassword())
                .clickLoginButton();

        waitForErrorMessage();
        checkErrorMessageContent(credentials.getMessage());
    }

    @Test(priority = 5, dataProvider = DataProviderNames.BLANK_PASSWORD_FIELD, dataProviderClass = CredentialsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Login")
    @Tag("Fields")
    @Link(name = "Login page", value = URLs.LOGIN_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(66)
    @QaseTitle("Attempting to log in without providing input for the \"Password\" field")
    @Description("Attempting to log in without providing input for the \"Password\" field")
    public void blankPasswordField(Credentials credentials) throws IllegalAccessException {

        setAllureParameters(credentials);

        loginForm
                .setUsername(credentials.getEmailOrUsername())
                .clickLoginButton();

        waitForErrorMessage();
        checkErrorMessageContent(credentials.getMessage());
    }

    @Test(priority = 2, dataProvider = DataProviderNames.CORRECT, dataProviderClass = CredentialsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Login")
    @Tag("Fields")
    @Link(name = "Login page", value = URLs.LOGIN_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(67)
    @QaseTitle("Logging in using correct credentials")
    @Description("Logging in using correct credentials")
    public void correct(Credentials credentials) throws IllegalAccessException {

        setAllureParameters(credentials);

        loginForm
                .setUsername(credentials.getEmailOrUsername())
                .setPassword(credentials.getPassword())
                .clickLoginButton();

        waitForAccountPage();
    }
}
