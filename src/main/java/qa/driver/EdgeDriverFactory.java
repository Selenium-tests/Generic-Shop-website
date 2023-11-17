package qa.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverFactory extends WebDriverFactory {
    @Override
    public WebDriver createWebDriver() {

        EdgeOptions options = new EdgeOptions();

        options.merge(getCapabilities(EdgeOptions.CAPABILITY, options));

        setProperty("msedgedriver.exe", "webdriver.edge.driver");

        return new EdgeDriver(options);
    }
}
