package qa.pageobject;

import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(className = "product_title")
    WebElement productTitle;

    @FindBy(xpath = "//button[@name='add-to-cart']")
    WebElement addToCartButton;

    public void clickAddToCart() {

        addToCartButton.click();
    }
    public String getProductTitle() {

        return productTitle.getText();
    }
}
