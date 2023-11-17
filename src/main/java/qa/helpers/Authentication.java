package qa.helpers;

import org.openqa.selenium.WebDriver;
import qa.pageobject.LoginPage;
import qa.pageobject.header.Header;

public class Authentication {

    public static void loginWithCredentials(WebDriver driver) {

        Header header = new Header(driver);
        LoginPage loginPage = new LoginPage(driver);

        header.clickAccountButton();
        loginPage.setUsername("karen@gmail.com");
        loginPage.setPassword("Kvc$11324#");
        loginPage.clickLoginButton();
    }
}
