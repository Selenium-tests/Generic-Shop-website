package qa.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeBrowser extends WebDriverFactory {

    @Override
    public WebDriver createDriver() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remove-allow-origins=*");
        options.merge(getCapabilities(ChromeOptions.CAPABILITY, options));

        return new ChromeDriver();
    }
}
