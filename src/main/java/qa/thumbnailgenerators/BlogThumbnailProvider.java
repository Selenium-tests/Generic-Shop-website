package qa.thumbnailgenerators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.enums.TycheProduct;
import qa.pageobject.thumbnails.BlogThumbnail;


public class BlogThumbnailProvider {

    public static BlogThumbnail create(WebDriver driver, TycheProduct tycheProduct, String name) {

        WebElement parent = driver.findElement(By.id("tyche_recent-" + tycheProduct.getName()));
        WebElement link = parent.findElement(By.linkText(name));

        BlogThumbnail blogThumbnail = new BlogThumbnail(driver);
        blogThumbnail.setLink(link);

        return blogThumbnail;
    }
}
