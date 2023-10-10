package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.account.AccountNavigation;

public class AccountPage extends BasePage {

    private final AccountNavigation accountNavigation;

    public AccountPage(WebDriver driver) {

        super(driver);

        accountNavigation = new AccountNavigation(driver);
    }

    @FindBy(linkText = "Dashboard")
    WebElement dashboard;

    public boolean isDashboardLinkDisplayed() {

        return dashboard.isDisplayed();
    }

    public AccountNavigation getAccountNavigation() {

        return accountNavigation;
    }
}
