package qa.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverFactory extends WebDriverFactory {

    @Override
    public WebDriver createWebDriver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remove-allow-origins=*");

        DesiredCapabilities capabilities = getCapabilities(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);

        setProperty("chromedriver.exe", "webdriver.chrome.driver");

        return new ChromeDriver(options);
    }
}
