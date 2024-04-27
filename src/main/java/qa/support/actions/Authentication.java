package qa.support.actions;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.openqa.selenium.WebDriver;
import qa.support.constans.DataProviderNames;
import qa.support.modelsbuilder.ModelsBuilder;
import qa.models.Credentials;
import qa.pageobject.loginform.LoginForm;
import qa.support.testdataloader.TestdataLoader;

public class Authentication {

    public static void loginWithCredentials(WebDriver driver) throws IllegalAccessException, JsonProcessingException {

        Credentials[] credentials = ModelsBuilder.getCredentials(TestdataLoader.loadQuickly("GSS_Credentials"), DataProviderNames.CORRECT);
        LoginForm loginForm = new LoginForm(driver);
        loginForm.setUsername(credentials[0].getEmailOrUsername());
        loginForm.setPassword(credentials[0].getPassword());
        loginForm.clickLoginButton();
    }
}
