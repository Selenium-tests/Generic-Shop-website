package base;

import enums.Browser;
import driver.DriverType;
import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import pages.components.header.Header;
import utils.JSONReader;
import utils.Pair;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;

public class BaseTest {

    private static WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void startDriver() throws FileNotFoundException, JSONException {

        System.out.println("Starting driver...");

        driver = DriverType.createDriver(Browser.CHROME);
        driver.navigate().to("http://skleptest.pl/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        JSONReader.read();

        loginPage = new LoginPage(driver);
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

    @AfterClass
    public void tearDown() {

        System.out.println("Quit driver");
        driver.quit();
    }
}
