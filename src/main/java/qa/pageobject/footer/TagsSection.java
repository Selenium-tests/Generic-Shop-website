package qa.pageobject.footer;

import qa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TagsSection extends BasePage {

    public TagsSection(WebDriver driver) {

        super(driver);
    }

    @FindBy(className = "tagcloud")
    WebElement tagCloud;

    public void clickLink(String linkText) {

        tagCloud.findElement(By.linkText(linkText)).click();
    }
}
