package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public abstract class BasePage {

        protected WebDriver driver;

        protected BasePage(WebDriver driver) {

                this.driver = driver;

                PageFactory.initElements(driver, this);
        }
        public String getTitle() {

                return driver.getTitle();
        }

        public void wait(int seconds) {

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        }
}
