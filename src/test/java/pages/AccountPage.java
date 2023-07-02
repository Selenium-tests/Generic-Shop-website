package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.components.addressform.AddressForm;

import java.awt.*;


public class AccountPage extends BasePage {

    private final AddressForm addressForm;

    public AccountPage(WebDriver driver) throws AWTException {

        super(driver);

        addressForm = new AddressForm(driver);
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

    @FindBy(xpath = "//a[@href='https://skleptest.pl/my-account/edit-address/billing']")
    WebElement billingAddressEditLink;

    @FindBy(xpath = "//a[@href='https://skleptest.pl/my-account/edit-address/shipping']")
    WebElement shippingAddressEditLink;

    public void clickOrders() {

        orders.click();
    }

    public void clickDownloads() {

        downloads.click();
    }

    public void clickDashboard() {

        dashboard.click();
    }

    public void clickAccountDetails() {

        accountDetails.click();
    }

    public boolean isDashboardLinkDisplayed() {

        return dashboard.isDisplayed();
    }

    public void clickAddresses() {

        addresses.click();
    }

    public void clickBillingAddressEditLink() {

        billingAddressEditLink.click();
    }

    public void clickShippingAddressEditLink() {

        shippingAddressEditLink.click();
    }

    public AddressForm getAddressForm() {

        return addressForm;
    }
}
