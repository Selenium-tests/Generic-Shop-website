package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

        protected BasePage(WebDriver driver) {

                PageFactory.initElements(driver, this);
        }
}
