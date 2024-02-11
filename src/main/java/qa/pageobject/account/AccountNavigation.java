package qa.pageobject.account;

import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.support.toby.ToBy;


public class AccountNavigation extends BasePage {

    public AccountNavigation(WebDriver driver) {

        super(driver);
    }

    @FindBy(className = "woocommerce-MyAccount-navigation")
    WebElement content;


    public void waitForContent() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(content)));
    }

    public void clickLink(String linkText) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(content.findElement(By.linkText(linkText)))).click();
    }
}
