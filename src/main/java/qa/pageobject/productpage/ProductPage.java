package qa.pageobject.productpage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.quantityfield.QuantityField;
import qa.support.toby.ToBy;


public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(className = "product_title")
    WebElement productName;

    @FindBy(xpath = ".//span[@class='woocommerce-Price-amount amount']")
    WebElement price;

    @FindBy(css = "div.quantity")
    WebElement quantity;

    @FindBy(xpath = "//button[@name='add-to-cart']")
    WebElement addToCartButton;

    @FindBy(className = "woocommerce-message")
    WebElement message;

    public void clickAddToCart() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(ToBy.get(addToCartButton))).click();
    }
    public String getProductName() throws IllegalAccessException {

        return getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(productName))).getText();
    }

    public String getPrice() throws IllegalAccessException {

        return getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(price))).getText();
    }

    public QuantityField getQuantityField() {

        return new QuantityField(getDriver(), quantity);
    }

    public void waitForMessage() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(message)));
    }

    public String getMessageText() {

        return message.getText().replace("View cart", "").trim();
    }
}
