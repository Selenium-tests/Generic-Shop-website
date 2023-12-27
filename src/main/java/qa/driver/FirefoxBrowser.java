package qa.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxBrowser extends WebDriverFactory {
    @Override
    public WebDriver createDriver() {

        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless=new");
        options.merge(getCapabilities(FirefoxOptions.FIREFOX_OPTIONS, options));

        return new FirefoxDriver(options);
    }
}
