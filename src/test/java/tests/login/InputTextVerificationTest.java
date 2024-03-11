package tests.login;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.pageobject.loginform.LoginForm;
import tests.base.BaseTest;

public class InputTextVerificationTest extends BaseTest {

    private LoginForm loginForm;
    private final String TEXT = "This is the text!";

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.LOGIN_PAGE.getName());
        loginForm = new LoginForm(getDriver());
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(61)
    @QaseTitle("Verification of the \"Username or email address\" field text input")
    @Description("Verification of the \"Username or email address\" field text input")
    public void usernameField() throws IllegalAccessException {

        loginForm.setUsername(TEXT);
        Assert.assertEquals(loginForm.getUsername(), TEXT, "Incorrect username");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(62)
    @QaseTitle("Verification of the \"Password\" field text input")
    @Description("Verification of the \"Password\" field text input")
    public void emailField() throws IllegalAccessException {

        loginForm.setPassword(TEXT);
        Assert.assertEquals(loginForm.getPassword(), TEXT, "Incorrect email");
    }
}
