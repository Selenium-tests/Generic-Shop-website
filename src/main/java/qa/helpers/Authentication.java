package qa.helpers;

import org.openqa.selenium.WebDriver;
import qa.pageobject.loginform.LoginForm;


public class Authentication {

    public static void loginWithCredentials(WebDriver driver) throws IllegalAccessException {

        LoginForm loginForm = new LoginForm(driver);
        loginForm.setUsername("karen@gmail.com");
        loginForm.setPassword("Kvc$11324#");
        loginForm.clickLoginButton();
    }
}
