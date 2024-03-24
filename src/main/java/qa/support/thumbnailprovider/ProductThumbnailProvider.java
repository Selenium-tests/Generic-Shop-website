package qa.support.thumbnailprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.pageobject.thumbnails.ProductThumbnail;

public class ProductThumbnailProvider {

    public static ProductThumbnail create(WebDriver driver, String tycheProduct, String name) {

        WebElement tycheProducts = driver.findElement(By.id("tyche_products-" + tycheProduct));
        WebElement link = tycheProducts.findElement(By.linkText(name));
        WebElement parent = link.findElement(By.xpath("./..")).findElement(By.xpath("./.."));
        WebElement price = parent.findElement(By.className("price"));
        WebElement addToCartButton = parent.findElement(By.className("ajax_add_to_cart"));

        ProductThumbnail productThumbnail = new ProductThumbnail(driver);

        productThumbnail
                .setParent(parent)
                .setPrice(price)
                .setAddToCartButton(addToCartButton);

        return productThumbnail;
    }
}
