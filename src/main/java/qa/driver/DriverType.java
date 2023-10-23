package qa.driver;

import qa.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.utils.Pair;

import java.util.Arrays;
import java.util.List;


public class DriverType {

    private static WebDriver driver = null;

    private static final List<Pair<String, String>> properties = Arrays.asList(

        new Pair<>("chromedriver.exe", "webdriver.chrome.driver"),
        new Pair<>("geckodriver.exe", "webdriver.gecko.driver"),
        new Pair<>("msedgedriver.exe", "webdriver.edge.driver")
    );
    DriverType() { }

    public static WebDriver createDriver(Browser browser) {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (browser) {

            case CHROME: {

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                options.merge(capabilities);

                driver = new ChromeDriver(options);
            } break;

            case FIREFOX: {

                FirefoxOptions options = new FirefoxOptions();
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
                options.merge(capabilities);

                driver = new FirefoxDriver(options);
            } break;

            case EDGE: {

                EdgeOptions options = new EdgeOptions();
                capabilities.setCapability(EdgeOptions.CAPABILITY, options);
                options.merge(capabilities);

                driver = new EdgeDriver(options);
            }
        }

        System.setProperty(properties.get(browser.ordinal()).first(), properties.get(browser.ordinal()).second());

        return driver;
    }
}
