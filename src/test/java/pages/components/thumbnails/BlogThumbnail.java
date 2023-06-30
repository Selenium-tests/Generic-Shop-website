package pages.components.thumbnails;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BlogThumbnail extends BasePage {

    WebElement child;
    WebElement link;

    String name;
    public BlogThumbnail(WebDriver driver) {

        super(driver);
    }

    @FindBy(className = "tyche-recent-post-alternate-widget")
    List<WebElement> blogs;


    public void setBlog(int index) {

        child = blogs.get(index).findElement(By.className("tyche-post-content"));
        link = child.findElement(By.xpath(".//a[@href]"));
        name = link.getText();
    }

    public void clickToLink() {

        link.click();
    }

    public String getName() {

        return name;
    }

    public int getSize() {

        return blogs.size();
    }
}
