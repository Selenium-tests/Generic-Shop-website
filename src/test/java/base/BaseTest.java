package base;

import driver.Browser;
import driver.DriverType;
import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.JSONReader;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static WebDriver driver;

    @BeforeClass
    public void startDriver() throws FileNotFoundException, JSONException {

        System.out.println("Starting driver...");

        driver = DriverType.createDriver(Browser.CHROME);
        driver.navigate().to("http://skleptest.pl/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        JSONReader.read();
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

    @AfterClass
    public void tearDown() {

        System.out.println("Quit driver");
        driver.quit();
    }
}
