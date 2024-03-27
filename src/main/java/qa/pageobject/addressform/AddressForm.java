package qa.pageobject.addressform;

import lombok.Getter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.support.toby.ToBy;

public class AddressForm extends BasePage {

    @Getter
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

    @FindBy(css = "input[type='submit']")
    WebElement saveAddressButton;

    @FindBy(className = "woocommerce-error")
    WebElement errorMessage;

    @FindBy(css = "label[for='billing_state']")
    WebElement additionalLabel;

    @FindBy(css = "input[id='billing_state']")
    WebElement additionalField;

    @FindBy(css = "select[id='billing_state']")
    WebElement additionalDropdownList;


    private void clearAndFill(WebElement element, String text) {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
        focus(element);
        element.clear();
        element.sendKeys(text);
    }

    @io.qameta.allure.Step("Enter a first name")
    @io.qase.api.annotation.Step("Enter a first name")
    public AddressForm setFirstName(String firstName) {

        clearAndFill(firstNameField, firstName);
        return this;
    }

    @io.qameta.allure.Step("Enter a last name")
    @io.qase.api.annotation.Step("Enter a last name")
    public AddressForm setLastName(String lastName) {

        clearAndFill(lastNameField, lastName);
        return this;
    }

    @io.qameta.allure.Step("Enter a company")
    @io.qase.api.annotation.Step("Enter a company")
    public AddressForm setCompany(String company) {

        clearAndFill(companyField, company);
        return this;
    }

    @io.qameta.allure.Step("Enter an address")
    @io.qase.api.annotation.Step("Enter an address")
    public AddressForm setAddress_1(String address) {

        clearAndFill(addressField1, address);
        return this;
    }

    @io.qameta.allure.Step("Enter an optional address")
    @io.qase.api.annotation.Step("Enter an optional address")
    public AddressForm setAddress_2(String address) {

        clearAndFill(addressField2, address);
        return this;
    }

    @io.qameta.allure.Step("Enter a city")
    @io.qase.api.annotation.Step("Enter a city")
    public AddressForm setCity(String city) {

        clearAndFill(cityField, city);
        return this;
    }

    @io.qameta.allure.Step("Enter a postcode")
    @io.qase.api.annotation.Step("Enter a postcode")
    public AddressForm setPostcode(String postcode) {

        clearAndFill(postcodeField, postcode);
        return this;
    }

    @io.qameta.allure.Step("Enter a phone")
    @io.qase.api.annotation.Step("Enter a phone")
    public AddressForm setPhone(String phone) {

        clearAndFill(phoneField, phone);
        return this;
    }

    @io.qameta.allure.Step("Enter an email")
    @io.qase.api.annotation.Step("Enter an email")
    public AddressForm setEmail(String email) {

        clearAndFill(emailField, email);
        return this;
    }

    @io.qameta.allure.Step("Click the \"Save address\" button")
    @io.qase.api.annotation.Step("Click the \"Save address\" button")
    public void clickSaveAddressButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(saveAddressButton));
        saveAddressButton.click();
    }

    public void waitForAdditionalLabel() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(additionalLabel)));
    }

    public void waitForAdditionalField() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(additionalField)));
    }

    public void waitForAdditionalDropdownList() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(ToBy.get(additionalDropdownList)));
    }

    public void waitForErrorMessage() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(errorMessage)));
    }

    public String getFirstName() {

        return firstNameField.getAttribute("value");
    }

    public String getLastName() {

        return lastNameField.getAttribute("value");
    }

    public String getCompany() {

        return companyField.getAttribute("value");
    }

    public String getAddress() {

        return addressField1.getAttribute("value");
    }

    public String getAddressLine2() {

        return addressField2.getAttribute("value");
    }

    public String getCity() {

        return cityField.getAttribute("value");
    }

    public String getPostcode() {

        return postcodeField.getAttribute("value");
    }

    public String getPhone() {

        return phoneField.getAttribute("value");
    }

    public String getEmail() {

        return emailField.getAttribute("value");
    }

    public String getAdditionalLabelText() {

        return additionalLabel.getText();
    }

    public String getErrorMessageText() {

        return errorMessage.getText();
    }

    public String getValidationMessageText() {

        return emailField.getAttribute("validationMessage");
    }
}
