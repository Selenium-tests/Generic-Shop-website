package qa.pageobject.thumbnails;

import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    public String getLinkText() {

        return link.getText();
    }

    public String getPrice() {

        return price.getText();
    }

    @Override
    public void clickLink() {

        link.click();
    }

    public void clickAddToCartButton() {

        addToCartButton.click();
    }
}
