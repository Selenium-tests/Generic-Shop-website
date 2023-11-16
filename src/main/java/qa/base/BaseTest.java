package qa.base;


import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import qa.enums.Browser;
import qa.driver.DriverType;
import qa.pageobject.LoginPage;
import qa.pageobject.header.Header;
import qa.utils.JSONReader;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    private static WebDriver driver;
    private WebDriverWait webDriverWait;
    private LoginPage loginPage;

    @BeforeClass
    public void readJSONFile() throws JSONException, IOException, ParseException {

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

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
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

    public void waitUntilPageIsLoaded() {

        webDriverWait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
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
