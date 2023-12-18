package qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.tools.jsfocus.FocusExecutor;

import java.time.Duration;

public abstract class BasePage {

        protected final WebDriverWait webDriverWait;
        private final FocusExecutor focusExecutor;

        protected BasePage(WebDriver driver) {

                PageFactory.initElements(driver, this);
                webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
                focusExecutor = new FocusExecutor(driver);
        }

        protected void focus(WebElement element) {

                focusExecutor.perform(element);
        }

        protected WebDriverWait getWebDriverWait() {

                return webDriverWait;
        }
}
