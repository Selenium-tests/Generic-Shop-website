package pages.account;

import base.BasePage;
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

    public void clickLink(String linkText) {

        navigation.findElement(By.linkText(linkText)).click();
    }
}
