package qa.pageobject.productpage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.support.toby.ToBy;


public class ProductPage extends BasePage {

    private final QuantityField quantityField;

    public ProductPage(WebDriver driver) {

        super(driver);

        quantityField = new QuantityField(driver);
    }

    @FindBy(className = "product_title")
    WebElement productTitle;

    @FindBy(xpath = ".//span[@class='woocommerce-Price-amount amount']")
    WebElement price;

    @FindBy(xpath = "//button[@name='add-to-cart']")
    WebElement addToCartButton;

    @FindBy(className = "woocommerce-message")
    WebElement message;

    public void clickAddToCart() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(ToBy.get(addToCartButton))).click();
    }
    public String getProductTitle() throws IllegalAccessException {

        return getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(productTitle))).getText();
    }

    public String getPrice() throws IllegalAccessException {

        return getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(price))).getText();
    }

    public QuantityField getQuantityField() {

        return quantityField;
    }

    public void waitForMessage() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(message)));
    }

    public String getMessageText() {

        return message.getText().replace("View cart", "").trim();
    }
}
