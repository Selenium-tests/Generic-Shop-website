package qa.support.jsfocus;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FocusExecutor {

    private final JavascriptExecutor executor;

    public FocusExecutor(WebDriver driver) {

        executor = (JavascriptExecutor) driver;
    }

    public void perform(WebElement element) {

        executor.executeScript("arguments[0].focus();", element);
    }


}
