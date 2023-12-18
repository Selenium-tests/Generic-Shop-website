package qa.browsermanager;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class BrowserManager {

    public static void goToPage(WebDriver driver, String url) {

        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void closeBrowser(WebDriver driver) {

        driver.quit();
    }
}
