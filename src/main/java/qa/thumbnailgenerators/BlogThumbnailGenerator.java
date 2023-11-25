package qa.thumbnailgenerators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.enums.ThumbnailCategory;
import qa.pageobject.thumbnails.BlogThumbnail;


public class BlogThumbnailGenerator implements ThumbnailFactory {

    @Override
    public BlogThumbnail createThumbnail(WebDriver driver, ThumbnailCategory category, String name) {

        WebElement parent = driver.findElement(By.id("tyche_recent-" + category.getName()));
        WebElement link = parent.findElement(By.linkText(name));

        BlogThumbnail blogThumbnail = new BlogThumbnail(driver);
        blogThumbnail.setLink(link);

        return blogThumbnail;
    }
}
