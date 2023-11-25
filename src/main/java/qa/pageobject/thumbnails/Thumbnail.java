package qa.pageobject.thumbnails;

import org.openqa.selenium.WebElement;

public interface Thumbnail {

    void setLink(WebElement link);
    void clickLink();
    String getLinkText();
}
