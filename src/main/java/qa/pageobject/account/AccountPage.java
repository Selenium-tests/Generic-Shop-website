package qa.pageobject.account;

import lombok.Getter;
import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @Getter
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
}
