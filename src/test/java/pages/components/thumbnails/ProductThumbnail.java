package pages.components.thumbnails;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductThumbnail extends BasePage {

    private String name;
    private int price;
    public ProductThumbnail(WebDriver driver) {

        super(driver);
    }

    @FindBy(className = "tyche-product")
    List<WebElement> products;

    public void setProduct(int index) {

        name = products.get(index).findElement(By.className("woocommerce-LoopProduct-link")).getText();
    }

    public void setPrice(int index) {

        String priceString = products.get(index).findElement(By.className("woocommerce-Price-amount")).getText();
        price = Integer.parseInt(priceString.substring(0, 2));
    }

    public void clickToLink(int index) {

        WebElement link = products.get(index).findElement(By.xpath(".//a[@href]"));
        link.click();
    }

    public void clickAddToCart(int index) {

        WebElement addToCartButton = products.get(index).findElement(By.className("ajax_add_to_cart"));
        addToCartButton.click();
    }

    public String getName() {

        return name;
    }

    public int getPrice() {

        return price;
    }

    public int getSize() {

        return products.size();
    }
}
