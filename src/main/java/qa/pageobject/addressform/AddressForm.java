package qa.pageobject.addressform;

import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class AddressForm extends BasePage {

    private final CountryDropdownList countryDropdownList;

    public AddressForm(WebDriver driver) {

        super(driver);

        countryDropdownList = new CountryDropdownList(driver);
    }

    @FindBy(id = "billing_first_name")
    WebElement firstNameField;

    @FindBy(id = "billing_last_name")
    WebElement lastNameField;

    @FindBy(id = "billing_company")
    WebElement companyField;

    @FindBy(id = "billing_address_1")
    WebElement addressField1;

    @FindBy(id = "billing_address_2")
    WebElement addressField2;

    @FindBy(id = "billing_city")
    WebElement cityField;

    @FindBy(id = "billing_postcode")
    WebElement postcodeField;

    @FindBy(id = "billing_phone")
    WebElement phoneField;

    @FindBy(id = "billing_email")
    WebElement emailField;

    @FindBy(xpath = ".//input[@type='submit']")
    WebElement saveAddressButton;

    @FindBy(xpath = "//ul[@class='woocommerce-error']")
    List<WebElement> errorMessage;


    protected void fill(WebElement element, String data) {

        element.clear();
        element.sendKeys(data);
    }

    public void setFirstName(String firstName) {

        fill(firstNameField, firstName);
    }

    public void setLastName(String lastName) {

        fill(lastNameField, lastName);
    }

    public void setCompany(String company) {

        fill(companyField, company);
    }

    public void setAddress_1(String address) {

        fill(addressField1, address);
    }

    public void setAddress_2(String address) {

        fill(addressField2, address);
    }

    public void setCity(String city) {

        fill(cityField, city);
    }

    public void setPostcode(String postcode) {

        fill(postcodeField, postcode);
    }

    public void setPhone(String phone) {

        fill(phoneField, phone);
    }

    public void setEmail(String email) {

        fill(emailField, email);
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

    public String getErrorMessageText() {

        return errorMessage.get(0).getText();
    }

    public String getValidationMessageText() {

        return emailField.getAttribute("validationMessage");
    }
}
