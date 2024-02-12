package tests.account.addressform;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import qa.base.BaseTest;
import qa.dataproviders.AddressDataProviders;
import qa.enums.URLs;
import qa.helpers.AddressFormFiller;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.helpers.Authentication;
import qa.pageobject.addressform.AddressForm;
import qa.data.AddressData;
import qa.support.dataprovidernames.DataProviderNames;

public class AddressFormTest extends BaseTest {

    private AddressForm addressForm;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToSpecificPage(URLs.LOGIN_PAGE.getName());
        Authentication.loginWithCredentials(getDriver());
        goToSpecificPage(URLs.BILLING_ADDRESS_FORM.getName());
    }

    private void compare(AddressData data) {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(addressForm.getFirstName(), data.getFirstName(), "Incorrect first name");
        softAssert.assertEquals(addressForm.getLastName(), data.getLastName(), "Incorrect last name");
        softAssert.assertEquals(addressForm.getCompany(), data.getCompanyName(), "Incorrect company");
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

    private void checkUrlAddress(URLs url) {

        Assert.assertEquals(getDriver().getCurrentUrl(), url.getName(),"Incorrect URL");
    }

    private void checkErrorMessageVisibility() {

        try {
            addressForm.waitForErrorMessage();
        } catch (Exception e) {
            Assert.fail("No error message displayed");
        }
    }

    private void checkErrorMessageContent(AddressData data) {

        Assert.assertEquals(addressForm.getErrorMessageText(), data.getErrorMessage(),
                "Incorrect error message content");
    }

    private void checkValidationMessageContent(AddressData data) {

        Assert.assertTrue(addressForm.getValidationMessageText().contains(data.getErrorMessage()),
                "The validation message does not contain \"" + data.getErrorMessage() + "\"");
    }

    private void positiveTestActions(AddressData data) throws IllegalAccessException {

        fill(data);
        checkUrlAddress(URLs.EDIT_ADDRESS_NAVIGATION);
        goToSpecificPage(URLs.BILLING_ADDRESS_FORM.getName());
        compare(data);
    }

    private void negativeTestActions(AddressData data) throws IllegalAccessException {

        fill(data);
        checkUrlAddress(URLs.BILLING_ADDRESS_FORM);
        checkErrorMessageVisibility();
        checkErrorMessageContent(data);
    }

    @Test(dataProvider = DataProviderNames.CORRECT, dataProviderClass = AddressDataProviders.class)
    public void correct(AddressData data) throws IllegalAccessException {

        positiveTestActions(data);
    }

    @Test(dataProvider = DataProviderNames.BLANK_COMPANY_FIELD, dataProviderClass = AddressDataProviders.class)
    public void blankCompanyField(AddressData data) throws IllegalAccessException {

        positiveTestActions(data);
    }

    @Test(dataProvider = DataProviderNames.BLANK_ADDRESS_FIELD_LINE_2, dataProviderClass = AddressDataProviders.class)
    public void blankAddressFieldLine2(AddressData data) throws IllegalAccessException {

        positiveTestActions(data);
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_FIRST_NAME, dataProviderClass = AddressDataProviders.class)
    public void incorrectFirstName(AddressData data) throws IllegalAccessException {

        negativeTestActions(data);
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_LAST_NAME, dataProviderClass = AddressDataProviders.class)
    public void incorrectLastName(AddressData data) throws IllegalAccessException {

        negativeTestActions(data);
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_POSTCODE, dataProviderClass = AddressDataProviders.class)
    public void incorrectPostcode(AddressData data) throws IllegalAccessException {

        negativeTestActions(data);
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_PHONE, dataProviderClass = AddressDataProviders.class)
    public void incorrectPhone(AddressData data) throws IllegalAccessException {

        negativeTestActions(data);
    }

    @Test(dataProvider = DataProviderNames.INCORRECT_EMAIL, dataProviderClass = AddressDataProviders.class)
    public void incorrectEmail(AddressData data) throws IllegalAccessException {

        fill(data);
        checkUrlAddress(URLs.BILLING_ADDRESS_FORM);
        checkValidationMessageContent(data);
    }

    @Test(dataProvider = DataProviderNames.BLANK_FIRST_NAME_FIELD, dataProviderClass = AddressDataProviders.class)
    public void blankFirstNameField(AddressData data) throws IllegalAccessException {

        negativeTestActions(data);
    }

    @Test(dataProvider = DataProviderNames.BLANK_LAST_NAME_FIELD, dataProviderClass = AddressDataProviders.class)
    public void blankLastNameField(AddressData data) throws IllegalAccessException {

        negativeTestActions(data);
    }

    @Test(dataProvider = DataProviderNames.BLANK_ADDRESS_FIELD, dataProviderClass = AddressDataProviders.class)
    public void blankAddressField(AddressData data) throws IllegalAccessException {

        negativeTestActions(data);
    }

    @Test(dataProvider = DataProviderNames.BLANK_CITY_FIELD, dataProviderClass = AddressDataProviders.class)
    public void blankCityField(AddressData data) throws IllegalAccessException {

        negativeTestActions(data);
    }

    @Test(dataProvider = DataProviderNames.BLANK_POSTCODE_FIELD, dataProviderClass = AddressDataProviders.class)
    public void blankPostcodeField(AddressData data) throws IllegalAccessException {

        negativeTestActions(data);
    }

    @Test(dataProvider = DataProviderNames.BLANK_PHONE_FIELD, dataProviderClass = AddressDataProviders.class)
    public void blankPhoneField(AddressData data) throws IllegalAccessException {

        negativeTestActions(data);
    }

    @Test(dataProvider = DataProviderNames.BLANK_EMAIL_FIELD, dataProviderClass = AddressDataProviders.class)
    public void blankEmailField(AddressData data) throws IllegalAccessException {

        negativeTestActions(data);
    }
}