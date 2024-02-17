package qa.pageobject.shoppingcart;

import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ShoppingCart extends BasePage {

    private final Table table;

    public ShoppingCart(WebDriver driver) {

        super(driver);

        table = new Table(driver);
    }

    @FindBy(name = "update_cart")
    WebElement updateButton;

    @FindBy(className = "wc-proceed-to-checkout")
    WebElement checkoutButton;

    @FindBy(className = "woocommerce-message")
    WebElement message;


    public void clickUpdateButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(updateButton)).click();
    }

    public void clickCheckoutButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }

    public Table getTable() {

        return table;
    }

    public void waitForMessage() {

        getWebDriverWait().until(ExpectedConditions.visibilityOf(message));
    }

    public String getMessage() {

        return message.getText();
    }
}
