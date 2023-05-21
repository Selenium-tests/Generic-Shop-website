package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountPage extends BasePage {

    AccountPage(WebDriver driver) {

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

    @FindBy(xpath = "//a[@href='https://skleptest.pl/my-account/edit-address/billing']")
    WebElement billingAddressEditLink;

    public void clickOrders() {

        orders.click();
    }

    void clickDownloads() {

        downloads.click();
    }

    void clickDashboard() {

        dashboard.click();
    }

    void clickAccountDetails() {

        accountDetails.click();
    }

    void clickAddresses() {

        addresses.click();
    }
}
