package qa.pageobject.thumbnails;

import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.tools.toby.ToBy;

public class ProductThumbnail extends BasePage implements Thumbnail {

    private WebElement link;
    private WebElement price;
    private WebElement addToCartButton;

    public ProductThumbnail(WebDriver driver) {

        super(driver);
    }

    @Override
    public void setLink(WebElement link) {

        this.link = link;
    }

    public void setPrice(WebElement price) {

        this.price = price;
    }

    public void setAddToCartButton(WebElement addToCartButton) {

        this.addToCartButton = addToCartButton;
    }

    @Override
    public String getLinkText() throws IllegalAccessException {

        return getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(link))).getText();
    }

    public String getPrice() throws IllegalAccessException {

        return getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(price))).getText();
    }

    @Override
    public void clickLink() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(link)).click();
    }

    public void clickAddToCartButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }
}
