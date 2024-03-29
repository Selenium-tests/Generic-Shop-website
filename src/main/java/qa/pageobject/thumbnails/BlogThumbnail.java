package qa.pageobject.thumbnails;

import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlogThumbnail extends BasePage {

    WebElement link;

    public BlogThumbnail(WebDriver driver) {

        super(driver);
    }

    public void setLink(WebElement link) {

        this.link = link;
    }

    public void clickLink() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(link)).click();
    }

    public String getLinkText() {

        return link.getText();
    }
}
