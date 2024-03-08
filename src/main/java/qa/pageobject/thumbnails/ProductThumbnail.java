package qa.pageobject.thumbnails;

import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductThumbnail extends BasePage {

    private WebElement parent;
    private WebElement price;
    @Setter
    private WebElement addToCartButton;
    private WebElement viewCartButton;

    public ProductThumbnail(WebDriver driver) {

        super(driver);
    }

    public ProductThumbnail setParent(WebElement parent) {

        this.parent = parent;
        return this;
    }

    public ProductThumbnail setPrice(WebElement price) {

        this.price = price;
        return this;
    }

    public String getPrice() {

        return price.getText();
    }

    @io.qameta.allure.Step("Click the \"Add to Cart\" button")
    @io.qase.api.annotation.Step("Click the \"Add to Cart\" button")
    public void clickAddToCartButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    @io.qameta.allure.Step("Click the \"View Cart\" button")
    @io.qase.api.annotation.Step("Click the \"View Cart\" button")
    public void clickViewCartButton() {

        viewCartButton.click();
    }

    public void waitForViewCartButton() {

        viewCartButton = getFluentWait().until(driver -> parent.findElement(By.xpath(".//a[@class='added_to_cart wc-forward']")));
    }
}
