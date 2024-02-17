package tests.base;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import qa.browsermanager.BrowserManager;
import qa.driver.WebDriverProvider;
import qa.enums.Browser;
import qa.testdataloader.TestdataLoader;

public class BaseTest {

    private static WebDriver driver;

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
        BrowserManager.start(driver);
    }

    @AfterMethod
    public void quitDriver() {

        BrowserManager.closeBrowser(driver);
    }

    protected void goToSpecificPage(String url) {

        BrowserManager.goToPage(driver, url);
    }

    public void setDriver(WebDriver driver) {

        BaseTest.driver = driver;
    }

    public static WebDriver getDriver() {

        return driver;
    }
}
