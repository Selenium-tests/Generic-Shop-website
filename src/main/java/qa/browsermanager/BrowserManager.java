package qa.browsermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BrowserManager {

    private static final Logger logger = LoggerFactory.getLogger(BrowserManager.class);

    public static void goToPage(WebDriver driver, String url) {

        logger.info("Browser: " + ((RemoteWebDriver) driver).getCapabilities().getBrowserName() + " " +
                ((RemoteWebDriver) driver).getCapabilities().getBrowserVersion());
        logger.info("Url: " + url);

        driver.get(url);
    }

    public static void closeBrowser(WebDriver driver) {

        driver.quit();
    }
}
