package qa.pageobject.orderreceivedpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;

public class OrderPage extends BasePage {
    public OrderPage(WebDriver driver) {

        super(driver);
    }

    public void waitUntilThePageIsOpen(String url) {

        getWebDriverWait().until(ExpectedConditions.urlContains(url));
    }
}
