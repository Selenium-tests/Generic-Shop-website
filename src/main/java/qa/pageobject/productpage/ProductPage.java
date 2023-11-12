package qa.pageobject.productpage;

import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    private QuantityField quantityField;


    public ProductPage(WebDriver driver) {

        super(driver);

        quantityField = new QuantityField(driver);
    }

    @FindBy(className = "product_title")
    WebElement productTitle;

    @FindBy(xpath = "//button[@name='add-to-cart']")
    WebElement addToCartButton;

    @FindBy(className = "woocommerce-message")
    List<WebElement> message;

    public void clickAddToCart() {

        addToCartButton.click();
    }
    public String getProductTitle() {

        return productTitle.getText();
    }

    public QuantityField getQuantityField() {

        return quantityField;
    }

    public boolean isMessageVisible() {

        return !(message.isEmpty());
    }

    public String getMessageText() {

        return message.get(0).getText();
    }
}
