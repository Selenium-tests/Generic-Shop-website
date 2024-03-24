package tests.base;

import lombok.Getter;
import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import qa.browsermanager.BrowserManager;
import qa.driver.WebDriverProvider;
import qa.enums.Browser;
import qa.support.testdataloader.TestdataLoader;

import java.time.Duration;

public class BaseTest {

    @Getter
    private static WebDriver driver;
    @Getter
    private WebDriverWait webDriverWait;

    @Parameters({"fileName"})
    @BeforeClass
    public void readJSONFile(@Optional("noFileName") String fileName) throws JSONException {

        if (!fileName.equals("noFileName")) {

            TestdataLoader.load(fileName);
        }
    }

    @BeforeMethod
    public void startDriver() {

        driver = WebDriverProvider.getDriver(Browser.CHROME).createDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        BrowserManager.start(driver);
    }

    @AfterMethod
    public void quitDriver() {

        BrowserManager.closeBrowser(driver);
    }

    protected void goToPage(String url) {

        BrowserManager.goToPage(driver, url);
    }
}
