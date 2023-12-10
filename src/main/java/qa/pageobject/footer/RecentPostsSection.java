package qa.pageobject.footer;

import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RecentPostsSection extends BasePage {

    public RecentPostsSection(WebDriver driver) {

        super(driver);
    }

    public void clickLink(String linkText) {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText))).click();
    }
}
