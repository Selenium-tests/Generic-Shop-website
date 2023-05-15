package pages;

import base.BasePage;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


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

    @BeforeClass
    void openAccount() throws CsvValidationException, IOException {

        //accountButton.click();
        //CorrectLogin.perform(username, password, submit);
    }

    /*@Test
    void linkToOrders() {

        orders.click();
        //Assert.assertEquals(driver.getCurrentUrl(), getWEBSITE_URL() + "my-account/orders/");
    }

    @Test
    void linkToDownloads() {

        downloads.click();
        //Assert.assertEquals(driver.getCurrentUrl(), getWEBSITE_URL() + "my-account/downloads/");
    }

    @Test
    void linkToDashboard() {

        dashboard.click();
        //Assert.assertEquals(driver.getCurrentUrl(), getWEBSITE_URL() + "my-account/");
    }

    @Test
    void linkToAccountDetails() {

        accountDetails.click();
        //Assert.assertEquals(driver.getCurrentUrl(), getWEBSITE_URL() + "my-account/customer-logout/");
    }

    @Test
    void linkToAddresses() {

        addresses.click();
        //Assert.assertEquals(driver.getCurrentUrl(), getWEBSITE_URL() + "my-account/edit-address/");
    }

    @Test(dependsOnMethods = {"linkToAddresses"})
    void linkToBillingAddressEdit() {

        billingAddressEditLink.click();
    }

    @Test
    void choiceCountry() {

    }

    @Test
    void correctCountryName() {

    }

    @Test
    void incorrectCountryName() {

    }

    @Test
    void incorrectFirstName() {

    }

    @Test
    void incorrectLastName() {

    }*/
}
