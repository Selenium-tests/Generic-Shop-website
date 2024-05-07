package tests.account.addressform;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import tests.base.BaseTest;
import qa.dataproviders.AddressDataProviders;
import qa.support.constans.URLs;
import qa.support.addressformfiller.AddressFormFiller;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.support.actions.Authentication;
import qa.pageobject.addressform.AddressForm;
import qa.models.AddressData;
import qa.support.constans.DataProviderNames;

@Epic("E2E")
@Feature("Setting user billing address information")
public class SettingUserDataTest extends BaseTest {

    private AddressForm addressForm;

    @BeforeMethod
    public void prepare() throws IllegalAccessException, JsonProcessingException {

        goToPage(URLs.LOGIN_PAGE);
        Authentication.loginWithCredentials(getDriver());
        goToPage(URLs.BILLING_ADDRESS_FORM);
    }

    private void setAllureParameters(AddressData addressData) {

        Allure.parameter("First name", addressData.getFirstName());
        Allure.parameter("Last name", addressData.getLastName());
        Allure.parameter("Company", addressData.getCompany());
        Allure.parameter("Address 1", addressData.getAddress());
        Allure.parameter("Address 2", addressData.getAddressLine2());
        Allure.parameter("Postcode", addressData.getPostcode());
        Allure.parameter("Town / City", addressData.getCity());
        Allure.parameter("Phone", addressData.getPhone());
        Allure.parameter("Email", addressData.getEmail());
    }

    private void compare(AddressData data) {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(addressForm.getCountryDropdownList().getCountry(), data.getCountry(), "Incorrect country");
        softAssert.assertEquals(addressForm.getFirstName(), data.getFirstName(), "Incorrect first name");
        softAssert.assertEquals(addressForm.getLastName(), data.getLastName(), "Incorrect last name");
        softAssert.assertEquals(addressForm.getCompany(), data.getCompany(), "Incorrect company");
        softAssert.assertEquals(addressForm.getAddress(), data.getAddress(), "Incorrect address");
        softAssert.assertEquals(addressForm.getAddressLine2(), data.getAddressLine2(), "Incorrect optional address");
        softAssert.assertEquals(addressForm.getCity(), data.getCity(), "Incorrect city");
        softAssert.assertEquals(addressForm.getPostcode(), data.getPostcode(), "Incorrect postcode");
        softAssert.assertEquals(addressForm.getPhone(), data.getPhone(), "Incorrect phone");
        softAssert.assertEquals(addressForm.getEmail(), data.getEmail(), "Incorrect email");

        softAssert.assertAll();
    }

    private void fill(AddressData data) throws IllegalAccessException {

        addressForm = AddressFormFiller.get(data, getDriver());
        addressForm.clickSaveAddressButton();
    }

    private void checkUrlAddress(String url) {

        Assert.assertEquals(getDriver().getCurrentUrl(), url,"Incorrect URL");
    }

    private void checkErrorMessageVisibility() {

        try {
            addressForm.waitForErrorMessage();
        } catch (Exception e) {
            Assert.fail("No error message displayed");
        }
    }

    private void checkErrorMessageContent(AddressData data) {

        Assert.assertEquals(addressForm.getErrorMessageText(), data.getMessage(),
                "Incorrect error message content");
    }

    private void checkValidationMessageContent(AddressData data) {

        Assert.assertTrue(addressForm.getValidationMessageText().contains(data.getMessage()),
                "The validation message does not contain \"" + data.getMessage() + "\"");
    }

    private void positiveTestActions(AddressData data) throws IllegalAccessException {

        fill(data);
        checkUrlAddress(URLs.EDIT_ADDRESS_NAVIGATION);
        goToPage(URLs.BILLING_ADDRESS_FORM);
        compare(data);
    }

    private void negativeTestActions(AddressData data) throws IllegalAccessException {

        fill(data);
        checkUrlAddress(URLs.BILLING_ADDRESS_FORM);
        checkErrorMessageVisibility();
        checkErrorMessageContent(data);
    }

    @Test(priority = 18, dataProvider = DataProviderNames.CORRECT, dataProviderClass = AddressDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(100)
    @QaseTitle("Setting user billing address information with correct data")
    @Description("Setting user billing address information with correct data")
    public void correct(AddressData data) throws IllegalAccessException {

        setAllureParameters(data);
        positiveTestActions(data);
    }

    @Test(priority = 7, dataProvider = DataProviderNames.BLANK_COMPANY_FIELD, dataProviderClass = AddressDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(101)
    @QaseTitle("Blank the \"Company name\" field")
    @Description("Blank the \"Company name\" field")
    public void blankCompanyField(AddressData data) throws IllegalAccessException {

        setAllureParameters(data);
        positiveTestActions(data);
    }

    @Test(priority = 1, dataProvider = DataProviderNames.INCORRECT_FIRST_NAME, dataProviderClass = AddressDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(102)
    @QaseTitle("Incorrect first name")
    @Description("Incorrect first name")
    public void incorrectFirstName(AddressData data) throws IllegalAccessException {

        setAllureParameters(data);
        negativeTestActions(data);
    }

    @Test(priority = 12, dataProvider = DataProviderNames.BLANK_FIRST_NAME_FIELD, dataProviderClass = AddressDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(103)
    @QaseTitle("Blank the \"First name\" field")
    @Description("Blank the \"First name\" field")
    public void blankFirstNameField(AddressData data) throws IllegalAccessException {

        setAllureParameters(data);
        negativeTestActions(data);
    }

    @Test(priority = 2, dataProvider = DataProviderNames.INCORRECT_LAST_NAME, dataProviderClass = AddressDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(104)
    @QaseTitle("Incorrect last name")
    @Description("Incorrect last name")
    public void incorrectLastName(AddressData data) throws IllegalAccessException {

        setAllureParameters(data);
        negativeTestActions(data);
    }

    @Test(priority = 13, dataProvider = DataProviderNames.BLANK_LAST_NAME_FIELD, dataProviderClass = AddressDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(105)
    @QaseTitle("Blank the \"Last name\" field")
    @Description("Blank the \"Last name\" field")
    public void blankLastNameField(AddressData data) throws IllegalAccessException {

        setAllureParameters(data);
        negativeTestActions(data);
    }

    @Test(priority = 3, dataProvider = DataProviderNames.INCORRECT_ADDRESS, dataProviderClass = AddressDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(106)
    @QaseTitle("Incorrect address")
    @Description("Incorrect address")
    public void incorrectAddress(AddressData data) throws IllegalAccessException {

        setAllureParameters(data);
        negativeTestActions(data);
    }

    @Test(priority = 14, dataProvider = DataProviderNames.BLANK_ADDRESS_FIELD, dataProviderClass = AddressDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(107)
    @QaseTitle("Blank the \"Street address\" field")
    @Description("Blank the \"Street address\" field")
    public void blankAddressField(AddressData data) throws IllegalAccessException {

        setAllureParameters(data);
        negativeTestActions(data);
    }

    @Test(priority = 4, dataProvider = DataProviderNames.INCORRECT_OPTIONAL_ADDRESS, dataProviderClass = AddressDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(108)
    @QaseTitle("Incorrect optional address")
    @Description("Incorrect optional address")
    public void incorrectOptionalAddress(AddressData data) throws IllegalAccessException {

        setAllureParameters(data);
        negativeTestActions(data);
    }

    @Test(priority = 8, dataProvider = DataProviderNames.BLANK_OPTIONAL_ADDRESS, dataProviderClass = AddressDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(109)
    @QaseTitle("Blank the \"Street address\" optional field")
    @Description("Blank the \"Street address\" optional field")
    public void blankOptionalAddressField(AddressData data) throws IllegalAccessException {

        setAllureParameters(data);
        positiveTestActions(data);
    }

    @Test(priority = 9, dataProvider = DataProviderNames.INCORRECT_POSTCODE, dataProviderClass = AddressDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(110)
    @QaseTitle("Incorrect postcode")
    @Description("Incorrect postcode")
    public void incorrectPostcode(AddressData data) throws IllegalAccessException {

        setAllureParameters(data);
        negativeTestActions(data);
    }

    @Test(priority = 15, dataProvider = DataProviderNames.BLANK_POSTCODE_FIELD, dataProviderClass = AddressDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(111)
    @QaseTitle("Blank the \"Postcode / ZIP\" field")
    @Description("Blank the \"Postcode / ZIP\" field")
    public void blankPostcodeField(AddressData data) throws IllegalAccessException {

        setAllureParameters(data);
        negativeTestActions(data);
    }

    @Test(priority = 5, dataProvider = DataProviderNames.INCORRECT_CITY, dataProviderClass = AddressDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(112)
    @QaseTitle("Incorrect city")
    @Description("Incorrect city")
    public void incorrectCity(AddressData data) throws IllegalAccessException {

        setAllureParameters(data);
        negativeTestActions(data);
    }

    @Test(priority = 16, dataProvider = DataProviderNames.BLANK_CITY_FIELD, dataProviderClass = AddressDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(113)
    @QaseTitle("Blank the \"Town / City\" field")
    @Description("Blank the \"Postcode / City\" field")
    public void blankCityField(AddressData data) throws IllegalAccessException {

        setAllureParameters(data);
        negativeTestActions(data);
    }

    @Test(priority = 10, dataProvider = DataProviderNames.INCORRECT_PHONE, dataProviderClass = AddressDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(114)
    @QaseTitle("Incorrect phone")
    @Description("Incorrect phone")
    public void incorrectPhone(AddressData data) throws IllegalAccessException {

        setAllureParameters(data);
        negativeTestActions(data);
    }

    @Test(priority = 17, dataProvider = DataProviderNames.BLANK_PHONE_FIELD, dataProviderClass = AddressDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(115)
    @QaseTitle("Blank the \"Phone\" field")
    @Description("Blank the \"Phone\" field")
    public void blankPhoneField(AddressData data) throws IllegalAccessException {

        setAllureParameters(data);
        negativeTestActions(data);
    }

    @Test(priority = 11, dataProvider = DataProviderNames.INCORRECT_EMAIL, dataProviderClass = AddressDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(116)
    @QaseTitle("Incorrect email")
    @Description("Incorrect email")
    public void incorrectEmail(AddressData data) throws IllegalAccessException {

        setAllureParameters(data);
        fill(data);
        checkUrlAddress(URLs.BILLING_ADDRESS_FORM);
        checkValidationMessageContent(data);
    }

    @Test(priority = 6, dataProvider = DataProviderNames.BLANK_EMAIL_FIELD, dataProviderClass = AddressDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(117)
    @QaseTitle("Blank the \"Email address\" field")
    @Description("Blank the \"Email address\" field")
    public void blankEmailField(AddressData data) throws IllegalAccessException {

        setAllureParameters(data);
        negativeTestActions(data);
    }
}