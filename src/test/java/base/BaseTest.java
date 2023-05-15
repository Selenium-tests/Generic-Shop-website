package base;

import driver.Browser;
import driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;

    private SoftAssert softAssert;

    @BeforeClass
    public void startDriver() {

        System.out.println("Starting driver...");

        driver = DriverType.createDriver(Browser.CHROME);
        driver.navigate().to("http://skleptest.pl/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        softAssert = new SoftAssert();
    }

    protected void back() {

        driver.navigate().back();
    }
    public void setDriver(WebDriver driver) {

        this.driver = driver;
    }

    public WebDriver getDriver() {

        return driver;
    }

    public SoftAssert getSoftAssert() {

        return softAssert;
    }

    @AfterClass
    public void tearDown() {

        System.out.println("Quit driver");
        //driver.quit();
    }
}
