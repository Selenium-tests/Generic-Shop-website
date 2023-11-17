package qa.browsermanager;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class BrowserManager {

    public static void openBrowser(WebDriver driver, String url) {

        Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();

        System.out.println("The " + capabilities.getBrowserName() + " " + capabilities.getBrowserVersion() + " is running...");

        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public static void closeBrowser(WebDriver driver) {

        Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();

        System.out.println("The " + capabilities.getBrowserName() + " " + capabilities.getBrowserVersion() + " is closing");

        driver.quit();
    }
}
