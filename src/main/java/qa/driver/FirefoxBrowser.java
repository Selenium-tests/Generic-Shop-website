package qa.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxBrowser extends WebDriverFactory {
    @Override
    public WebDriver createDriver() {

        FirefoxOptions options = new FirefoxOptions();
        options.merge(getCapabilities(FirefoxOptions.FIREFOX_OPTIONS, options));

        setProperty("geckodriver.exe", "webdriver.gecko.driver");

        return new FirefoxDriver(options);
    }
}
