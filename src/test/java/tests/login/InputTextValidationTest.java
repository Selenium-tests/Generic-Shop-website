package tests.login;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.pageobject.loginform.LoginForm;
import tests.base.BaseTest;

public class InputTextValidationTest extends BaseTest {

    private LoginForm loginForm;
    private final String text = "This is the text";

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.LOGIN_PAGE.getName());
        loginForm = new LoginForm(getDriver());
    }

    @Test
    public void usernameField() throws IllegalAccessException {

        loginForm.setUsername(text);

        Assert.assertEquals(loginForm.getUsername(), text, "Incorrect username");
    }

    @Test
    public void emailField() throws IllegalAccessException {

        loginForm.setPassword(text);

        Assert.assertEquals(loginForm.getPassword(), text, "Incorrect email");
    }
}
