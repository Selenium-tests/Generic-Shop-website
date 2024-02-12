package qa.pageobject.addressform;

import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.support.toby.ToBy;



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

    public void setFirstName(String firstName) {

        clearAndFill(firstNameField, firstName);
    }

    public void setLastName(String lastName) {

        clearAndFill(lastNameField, lastName);
    }

    public void setCompany(String company) {

        clearAndFill(companyField, company);
    }

    public void setAddress_1(String address) {

        clearAndFill(addressField1, address);
    }

    public void setAddress_2(String address) {

        clearAndFill(addressField2, address);
    }

    public void setCity(String city) {

        clearAndFill(cityField, city);
    }

    public void setPostcode(String postcode) {

        clearAndFill(postcodeField, postcode);
    }

    public void setPhone(String phone) {

        clearAndFill(phoneField, phone);
    }

    public void setEmail(String email) {

        clearAndFill(emailField, email);
    }

    public CountryDropdownList getCountryDropdownList() {

        return countryDropdownList;
    }

    public void clickSaveAddressButton() {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(saveAddressButton));
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
