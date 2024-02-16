package qa.base;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.support.jsfocus.FocusExecutor;

import java.time.Duration;

public class BasePage {

    private final WebDriver driver;
    private final WebDriverWait webDriverWait;
    private final FluentWait<WebDriver> fluentWait;
    private final FocusExecutor focusExecutor;

    protected BasePage(WebDriver driver) {

        PageFactory.initElements(driver, this);

        this.driver = driver;
        focusExecutor = new FocusExecutor(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    }

    protected void focus(WebElement element) {

        focusExecutor.perform(element);
    }

    protected WebDriver getDriver() {

        return driver;
    }

    protected WebDriverWait getWebDriverWait() {

        return webDriverWait;
    }

    protected FluentWait<WebDriver> getFluentWait() {

        return fluentWait;
    }
}
