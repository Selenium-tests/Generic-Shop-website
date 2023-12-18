package qa.base;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import qa.browsermanager.BrowserManager;
import qa.driver.WebDriverProvider;
import qa.enums.Browser;
import qa.jsonreader.JSONReader;
import java.io.IOException;


public class BaseTest {

    private static WebDriver driver;

    @BeforeClass
    public void readJSONFile() throws JSONException, IOException, ParseException {

        JSONReader.read();
    }

    @BeforeMethod
    public void startDriver() {

        driver = WebDriverProvider.getDriver(Browser.CHROME).createDriver();
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
