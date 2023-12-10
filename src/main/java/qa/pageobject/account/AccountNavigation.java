package qa.pageobject.account;

import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountNavigation extends BasePage {

    public AccountNavigation(WebDriver driver) {

        super(driver);
    }

    @FindBy(className = "woocommerce-MyAccount-navigation")
    WebElement navigation;

    public void clickLink(String linkText) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(navigation.findElement(By.linkText(linkText)))).click();
    }
}
