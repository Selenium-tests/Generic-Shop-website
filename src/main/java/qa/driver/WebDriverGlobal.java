package qa.driver;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

public class WebDriverGlobal {

    @Setter
    @Getter
    private static WebDriver driver;
}
