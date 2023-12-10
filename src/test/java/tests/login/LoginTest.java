package tests.login;

import qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.pageobject.account.AccountPage;
import qa.pageobject.LoginPage;
import qa.provider.MyDataProvider;
import qa.records.Credentials;
import qa.extentreports.ExtentReportsManager;
import java.util.function.Consumer;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    private void create() {

        goToSpecificPage(URLs.LOGIN_PAGE.getName());
        loginPage = new LoginPage(getDriver());
    }

    private <T> void check(Consumer<T> consumer, T object, Credentials credentials) throws IllegalAccessException {

        loginPage.clearAll();
        loginPage.setUsername(credentials.email());
        loginPage.setPassword(credentials.password());
        loginPage.clickLoginButton();

        consumer.accept(object);
    }

    @Test(priority = 1, dataProvider = "incorrectEmailFormat", dataProviderClass = MyDataProvider.class)
    public void incorrectUsername(Credentials credentials) throws IllegalAccessException {

        ExtentReportsManager.setName("Incorrect email address");

        check((LoginPage lp)-> Assert.assertTrue(lp.isErrorMessageDisplayed(),
                "No error message during login with \"" + credentials.email() + "\" as an incorrect email address"),
                loginPage, credentials);
    }

    @Test(priority = 3, dataProvider = "blankEmailField", dataProviderClass = MyDataProvider.class)
    public void blankUsernameField(Credentials credentials) throws IllegalAccessException {

        ExtentReportsManager.setName("Blank username field");

        check((LoginPage lp)-> Assert.assertTrue(lp.isErrorMessageDisplayed(),
                "No error message during login with the blank username field"), loginPage, credentials);
    }

    @Test(priority = 2, dataProvider = "incorrectPassword", dataProviderClass = MyDataProvider.class)
    public void incorrectPassword(Credentials credentials) throws IllegalAccessException {

        ExtentReportsManager.setName("Incorrect password");

        check((LoginPage lp)-> Assert.assertTrue(lp.isErrorMessageDisplayed(),
                "No error message during login with \"" + credentials.password() + "\" as an incorrect password"),
                loginPage, credentials);
    }

    @Test(priority = 4, dataProvider = "blankPasswordField", dataProviderClass = MyDataProvider.class)
    public void blankPasswordField(Credentials credentials) throws IllegalAccessException {

        ExtentReportsManager.setName("Blank password field");

        check((LoginPage lp)-> Assert.assertTrue(lp.isErrorMessageDisplayed(),
                "No error message during login with blank password field"), loginPage, credentials);
    }

    @Test(priority = 5, dataProvider = "correctCredentials", dataProviderClass = MyDataProvider.class)
    public void correctCredentials(Credentials credentials) throws IllegalAccessException {

        ExtentReportsManager.setName("Correct credentials");

        check((AccountPage ap)-> Assert.assertTrue(ap.isDashboardLinkDisplayed(),
               "Failure to log in with valid credentials"), new AccountPage(getDriver()), credentials);
    }
}
