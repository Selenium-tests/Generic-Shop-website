package qa.pageobject.account;

import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.support.toby.ToBy;


public class AccountNavigation extends BasePage {

    private final String DASHBOARD_LINK = "Dashboard";
    private final String ORDERS_LINK = "Orders";
    private final String DOWNLOADS_LINK = "Downloads";
    private final String ADDRESSES_LINK = "Addresses";
    private final String ACCOUNT_DETAILS_LINK = "Account details";
    private final String LOGOUT_LINK = "Logout";

    public AccountNavigation(WebDriver driver) {

        super(driver);
    }

    @FindBy(className = "woocommerce-MyAccount-navigation")
    WebElement content;

    private void clickLink(String link) {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(content.findElement(By.linkText(link)))).click();
    }


    public void waitForContent() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(content)));
    }

    @io.qameta.allure.Step("Click the \"Orders\" link")
    @io.qase.api.annotation.Step("Click the \"Orders\" link")
    public void clickOrdersLink() {

        clickLink(ORDERS_LINK);
    }

    @io.qameta.allure.Step("Click the \"Dashboard\" link")
    @io.qase.api.annotation.Step("Click the \"Dashboard\" link")
    public void clickDashboardLink() {

        clickLink(DASHBOARD_LINK);
    }

    @io.qameta.allure.Step("Click the \"Downloads\" link")
    @io.qase.api.annotation.Step("Click the \"Downloads\" link")
    public void clickDownloadsLink() {

        clickLink(DOWNLOADS_LINK);
    }

    @io.qameta.allure.Step("Click the \"Addresses\" link")
    @io.qase.api.annotation.Step("Click the \"Addresses\" link")
    public void clickAddressesLink() {

        clickLink(ADDRESSES_LINK);
    }

    @io.qameta.allure.Step("Click the \"Account details\" link")
    @io.qase.api.annotation.Step("Click the \"Account details\" link")
    public void clickAccountDetailsLink() {

        clickLink(ACCOUNT_DETAILS_LINK);
    }

    @io.qameta.allure.Step("Click the \"Logout\" link")
    @io.qase.api.annotation.Step("Click the \"Logout\" link")
    public void clickLogoutLink() {

        clickLink(LOGOUT_LINK);
    }

    /*public void clickLink(String linkText) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(content.findElement(By.linkText(linkText)))).click();
    }*/
}
