package qa.pageobject.footer;

import org.openqa.selenium.support.ui.ExpectedConditions;
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
    WebElement content;

    public void clickLink(String linkText) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(content.findElement(By.linkText(linkText)))).click();
    }
}
