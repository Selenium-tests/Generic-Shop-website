package qa.pageobject.thumbnails;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductThumbnail extends BasePage {

    private WebElement parent;
    private WebElement link;
    private WebElement price;
    private WebElement addToCartButton;

    public ProductThumbnail(WebDriver driver) {

        super(driver);
    }

    public ProductThumbnail setParent(WebElement parent) {

        this.parent = parent;
        return this;
    }

    public ProductThumbnail setLink(WebElement link) {

        this.link = link;
        return this;
    }

    public ProductThumbnail setPrice(WebElement price) {

        this.price = price;
        return this;
    }

    public void setAddToCartButton(WebElement addToCartButton) {

        this.addToCartButton = addToCartButton;
    }

    public String getLinkText() throws IllegalAccessException {

        return link.getText();
    }

    public String getPrice() throws IllegalAccessException {

        return price.getText();
    }

    public void clickLink() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(link)).click();
    }

    public void clickAddToCartButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public void waitForViewCartButton() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions
                .elementToBeClickable(parent.findElement(By.xpath(".//a[@class='added_to_cart wc-forward']"))));
    }
}
