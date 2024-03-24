package qa.support.actions;

import org.openqa.selenium.WebDriver;
import qa.support.modelsbuilder.ModelsBuilder;
import qa.models.Credentials;
import qa.pageobject.loginform.LoginForm;

public class Authentication {

    public static void loginWithCredentials(WebDriver driver) throws IllegalAccessException {

        Credentials[] credentials = ModelsBuilder.getCorrectCredentials();
        LoginForm loginForm = new LoginForm(driver);
        loginForm.setUsername(credentials[0].getEmailOrUsername());
        loginForm.setPassword(credentials[0].getPassword());
        loginForm.clickLoginButton();
    }
}
