package pages.components.addressform;

import base.BasePage;
import enums.AddressFormType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.List;

public class AddressForm extends BasePage {

    private final String prefix;
    private final CountryDropdownList countryDropdownList;
    private final AddressFormType addressFormType;

    public AddressForm(WebDriver driver, AddressFormType type) throws AWTException {

        super(driver);

        this.addressFormType = type;
        this.prefix = type == AddressFormType.BILLING ? "billing" : "shipping";

        countryDropdownList = new CountryDropdownList(driver);
    }

    @FindBy(xpath = ".//div[@class='woocommerce-address-fields']")
    WebElement addressFields;

    @FindBy(xpath = ".//input[@type='submit']")
    WebElement saveAddressButton;

    @FindBy(xpath = "//ul[@class='woocommerce-error']")
    List<WebElement> errorMessage;

    @FindBy(id = "billing_phone")
    WebElement phoneField;

    @FindBy(id = "billing_email")
    WebElement emailField;

    protected void fill(WebElement element, String data) {

        element.clear();
        element.sendKeys(data);
    }

    public void setFirstName(String firstName) {

        fill(addressFields.findElement(By.id(prefix + "_first_name")), firstName);
    }

    public void setLastName(String lastName) {

        fill(addressFields.findElement(By.id(prefix + "_last_name")), lastName);
    }

    public void setCompany(String company) {

        fill(addressFields.findElement(By.id(prefix + "_company")), company);
    }

    public void setAddress_1(String address) {

        fill(addressFields.findElement(By.id(prefix + "_address_1")), address);
    }

    public void setAddress_2(String address) {

        fill(addressFields.findElement(By.id(prefix + "_address_2")), address);
    }

    public void setCity(String city) {

        fill(addressFields.findElement(By.id(prefix + "_city")), city);
    }

    public void setState(String state) {

        fill(addressFields.findElement(By.id(prefix + "_state")), state);
    }

    public void setPhone(String phone) {

        fill(phoneField, phone);
    }

    public void setEmail(String email) {

        fill(emailField, email);
    }

    public void setPostcode(String postcode) {

        fill(addressFields.findElement(By.id(prefix + "_postcode")), postcode);
    }

    public CountryDropdownList getCountryDropdownList() {

        return countryDropdownList;
    }

    public void clickSaveAddressButton() {

        saveAddressButton.click();
    }

    public boolean isErrorMessageDisplayed() {

        return !(errorMessage.isEmpty());
    }

    public AddressFormType getAddressFormType() {

        return addressFormType;
    }
}
