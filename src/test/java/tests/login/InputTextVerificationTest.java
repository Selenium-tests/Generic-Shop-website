package tests.login;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.support.constans.URLs;
import qa.pageobject.loginform.LoginForm;
import tests.base.BaseTest;

public class InputTextVerificationTest extends BaseTest {

    private LoginForm loginForm;
    private final String text = "This is the text!";

    @BeforeMethod
    public void create() {

        goToPage(URLs.LOGIN_PAGE);
        loginForm = new LoginForm(getDriver());
    }

    @Test(priority = 1)

    @Severity(SeverityLevel.CRITICAL)
    @Owner("Paweł Aksman")
    @Tag("Login")
    @Tag("Fields")
    @Link(name = "Login page", value = URLs.LOGIN_PAGE)
    @QaseId(61)
    @QaseTitle("Verification of the \"Username or email address\" field text input")
    @Description("Verification of the \"Username or email address\" field text input")
    public void usernameField() throws IllegalAccessException {

        Allure.parameter("Text", text);

        loginForm.setUsername(text);
        Assert.assertEquals(loginForm.getUsername(), text, "Incorrect the \"Username or email address\" field output");
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Login")
    @Tag("Fields")
    @Link(name = "Login page", value = URLs.LOGIN_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(62)
    @QaseTitle("Verification of the \"Password\" field text input")
    @Description("Verification of the \"Password\" field text input")
    public void emailField() throws IllegalAccessException {

        Allure.parameter("Text", text);

        loginForm.setPassword(text);
        Assert.assertEquals(loginForm.getPassword(), text, "Incorrect the \"Password\" field output");
    }
}
