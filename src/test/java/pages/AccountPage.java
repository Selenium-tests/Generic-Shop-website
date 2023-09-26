package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.awt.*;


public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) throws AWTException {

        super(driver);
    }

    @FindBy(linkText = "Orders")
    WebElement orders;

    @FindBy(linkText = "Downloads")
    WebElement downloads;

    @FindBy(linkText = "Dashboard")
    WebElement dashboard;

    @FindBy(linkText = "Account details")
    WebElement accountDetails;

    @FindBy(linkText = "Addresses")
    WebElement addresses;

    @FindBy(linkText = "Logout")
    WebElement logout;

    @FindBy(xpath = "//a[@href='https://skleptest.pl/my-account/edit-address/billing']")
    WebElement billingAddressEditLink;

    @FindBy(xpath = "//a[@href='https://skleptest.pl/my-account/edit-address/shipping']")
    WebElement shippingAddressEditLink;

    public void clickOrdersLink() {

        orders.click();
    }

    public void clickDownloadsLink() {

        downloads.click();
    }

    public void clickDashboardLink() {

        dashboard.click();
    }

    public void clickLogoutLink() {

        logout.click();
    }

    public void clickAccountDetailsLink() {

        accountDetails.click();
    }

    public boolean isDashboardLinkDisplayed() {

        return dashboard.isDisplayed();
    }

    public void clickAddressesLink() {

        addresses.click();
    }

    public void clickBillingAddressEditLink() {

        billingAddressEditLink.click();
    }

    public void clickShippingAddressEditLink() {

        shippingAddressEditLink.click();
    }
}
