package base;

import enums.Browser;
import driver.DriverType;
import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.components.header.Header;
import utils.JSONReader;
import utils.Pair;
import java.time.Duration;
import java.util.List;

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

    public void login(List<Pair<String, String>> data) {

        Header header = new Header(driver);

        header.clickAccountButton();

        loginPage.setUsername(data.get(0).first());
        loginPage.setPassword(data.get(0).second());
        loginPage.clickLoginButton();

    }
    public LoginPage getLoginPage() {

        return loginPage;
    }
}
