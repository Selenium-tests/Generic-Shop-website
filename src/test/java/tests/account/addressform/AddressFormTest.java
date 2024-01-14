package tests.account.addressform;

import org.testng.Assert;
import qa.base.BaseTest;
import qa.enums.URLs;
import qa.helpers.AddressFormFiller;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.helpers.Authentication;
import qa.pageobject.addressform.AddressForm;
import qa.dataproviders.DataProviders;
import qa.data.AddressFormData;

public class AddressFormTest extends BaseTest {

    private AddressForm addressForm;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToSpecificPage(URLs.LOGIN_PAGE.getName());
        Authentication.loginWithCredentials(getDriver());
        goToSpecificPage(URLs.BILLING_ADDRESS_FORM.getName());
    }

    private void fill(AddressFormData data) throws IllegalAccessException {

        addressForm = AddressFormFiller.get(data, getDriver(), false);
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

    private void checkErrorMessageContent(AddressFormData data) {

        Assert.assertEquals(addressForm.getErrorMessageText(), data.getErrorMessage(),
                "Incorrect error message content");
    }

    private void checkValidationMessageContent(AddressFormData data) {

        Assert.assertTrue(addressForm.getValidationMessageText().contains(data.getErrorMessage()),
                "The validation message does not contain \"" + data.getErrorMessage() + "\"");
    }

    private void action(AddressFormData data) throws IllegalAccessException {

        fill(data);
        checkUrlAddress(URLs.BILLING_ADDRESS_FORM);
        checkErrorMessageVisibility();
        checkErrorMessageContent(data);
    }

    @Test(dataProvider = "AF_correctAddress", dataProviderClass = DataProviders.class)
    public void correctAddressData(AddressFormData data) throws IllegalAccessException {

        fill(data);
        checkUrlAddress(URLs.EDIT_ADDRESS_NAVIGATION);
    }

    @Test(dataProvider = "AF_incorrectFirstName", dataProviderClass = DataProviders.class)
    public void incorrectFirstName(AddressFormData data) throws IllegalAccessException {

        action(data);
    }

    @Test(dataProvider = "AF_incorrectLastName", dataProviderClass = DataProviders.class)
    public void incorrectLastName(AddressFormData data) throws IllegalAccessException {

        action(data);
    }

    @Test(dataProvider = "AF_incorrectPostcode", dataProviderClass = DataProviders.class)
    public void incorrectPostcode(AddressFormData data) throws IllegalAccessException {

        action(data);
    }

    @Test(dataProvider = "AF_incorrectPhoneNumber", dataProviderClass = DataProviders.class)
    public void incorrectPhoneNumber(AddressFormData data) throws IllegalAccessException {

        action(data);
    }

    @Test(dataProvider = "AF_incorrectEmail", dataProviderClass = DataProviders.class)
    public void incorrectEmail(AddressFormData data) throws IllegalAccessException {

        fill(data);
        checkUrlAddress(URLs.BILLING_ADDRESS_FORM);
        checkValidationMessageContent(data);
    }

    @Test(dataProvider = "AF_withoutFirstName", dataProviderClass = DataProviders.class)
    public void blankFirstNameField(AddressFormData data) throws IllegalAccessException {

        action(data);
    }

    @Test(dataProvider = "AF_withoutLastName", dataProviderClass = DataProviders.class)
    public void blankLastNameField(AddressFormData data) throws IllegalAccessException {

        action(data);
    }

    @Test(dataProvider = "AF_withoutAddress", dataProviderClass = DataProviders.class)
    public void blankAddressField(AddressFormData data) throws IllegalAccessException {

        action(data);
    }

    @Test(dataProvider = "AF_withoutCity", dataProviderClass = DataProviders.class)
    public void blankCityField(AddressFormData data) throws IllegalAccessException {

        action(data);
    }

    @Test(dataProvider = "AF_withoutPostcode", dataProviderClass = DataProviders.class)
    public void blankPostcodeField(AddressFormData data) throws IllegalAccessException {

        action(data);
    }

    @Test(dataProvider = "AF_withoutPhone", dataProviderClass = DataProviders.class)
    public void blankPhoneField(AddressFormData data) throws IllegalAccessException {

        action(data);
    }

    @Test(dataProvider = "AF_withoutEmail", dataProviderClass = DataProviders.class)
    public void blankEmailField(AddressFormData data) throws IllegalAccessException {

        action(data);
    }
}