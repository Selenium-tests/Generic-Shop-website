package qa.base;


import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import qa.enums.Browser;
import qa.driver.DriverType;
import qa.pageobject.LoginPage;
import qa.pageobject.header.Header;
import qa.utils.JSONReader;

import java.time.Duration;

public class BaseTest {

    private static WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void readJSONFile() throws JSONException {

        JSONReader.read();
    }

    @BeforeMethod
    public void startDriver() {

        System.out.println("Starting driver...");

        driver = DriverType.createDriver(Browser.CHROME);
        driver.navigate().to("http://skleptest.pl/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void quitDriver() {

        System.out.println("Quit driver");
        driver.quit();
    }

    protected void back() {

        driver.navigate().back();
    }
    public void setDriver(WebDriver driver) {

        BaseTest.driver = driver;
    }

    public static WebDriver getDriver() {

        return driver;
    }

    public void login(String username, String password) {

        Header header = new Header(driver);

        header.clickAccountButton();

        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();

    }
    public LoginPage getLoginPage() {

        return loginPage;
    }
}
