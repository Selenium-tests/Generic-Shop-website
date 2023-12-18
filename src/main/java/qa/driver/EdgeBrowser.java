package qa.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeBrowser extends WebDriverFactory {
    @Override
    public WebDriver createDriver() {

        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remove-allow-origins=*");
        options.merge(getCapabilities(EdgeOptions.CAPABILITY, options));

        return new EdgeDriver(options);
    }
}
