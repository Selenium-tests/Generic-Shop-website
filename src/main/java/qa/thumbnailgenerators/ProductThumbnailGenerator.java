package qa.thumbnailgenerators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.enums.ThumbnailCategory;
import qa.pageobject.thumbnails.ProductThumbnail;

public class ProductThumbnailGenerator implements ThumbnailFactory {

    @Override
    public ProductThumbnail createThumbnail(WebDriver driver, ThumbnailCategory category, String name) {

        WebElement tycheProducts = driver.findElement(By.id("tyche_products-" + category.getName()));
        WebElement link = tycheProducts.findElement(By.linkText(name));
        WebElement parent = link.findElement(By.xpath("./..")).findElement(By.xpath("./.."));
        WebElement price = parent.findElement(By.className("price"));
        WebElement addToCartButton = parent.findElement(By.className("ajax_add_to_cart"));

        ProductThumbnail productThumbnail = new ProductThumbnail(driver);
        productThumbnail.setLink(link);
        productThumbnail.setPrice(price);
        productThumbnail.setAddToCartButton(addToCartButton);

        return productThumbnail;
    }
}
