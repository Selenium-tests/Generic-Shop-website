package qa.helpers;

import org.openqa.selenium.WebDriver;
import qa.pageobject.LoginPage;


public class Authentication {

    public static void loginWithCredentials(WebDriver driver) throws IllegalAccessException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("karen@gmail.com");
        loginPage.setPassword("Kvc$11324#");
        loginPage.clickLoginButton();
    }
}
