package qa.pageobject.footer;

import qa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RecentPostsSection extends BasePage {

    public RecentPostsSection(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "tyche_recent-3")
    WebElement container;

    public void clickLink(String linkText) {

        container.findElement(By.linkText(linkText)).click();
    }
}
