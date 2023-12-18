package tests.account.addressform;

import org.testng.Assert;
import qa.base.BaseTest;
import qa.enums.URLs;
import qa.helpers.AddressFormFiller;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.helpers.Authentication;
import qa.pageobject.addressform.AddressForm;
import qa.provider.MyDataProvider;
import qa.records.AddressFormData;
import qa.extentreports.ExtentReportsManager;
import java.util.function.Consumer;

public class AddressFormTests extends BaseTest {

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToSpecificPage(URLs.LOGIN_PAGE.getName());
        Authentication.loginWithCredentials(getDriver());
        goToSpecificPage(URLs.BILLING_ADDRESS_FORM.getName());
    }

    private void fill(AddressFormData data, Consumer<AddressForm> consumer) throws IllegalAccessException {

        AddressForm addressForm = AddressFormFiller.get(data, getDriver());
        addressForm.clickSaveAddressButton();

        consumer.accept(addressForm);
    }

    @Test(dataProvider = "AF_correctAddress", dataProviderClass = MyDataProvider.class)
    public void correctAddressData(AddressFormData data) throws IllegalAccessException {

        ExtentReportsManager.setName("Filling the form with a correct address data");

        AddressFormFiller.get(data, getDriver()).clickSaveAddressButton();

        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.EDIT_ADDRESS_NAVIGATION.getName(),
                "The address data has not been saved");
    }

    @Test(dataProvider = "AF_incorrectFirstName", dataProviderClass = MyDataProvider.class)
    public void incorrectFirstName(AddressFormData data) throws IllegalAccessException {

        ExtentReportsManager.setName("\"" + data.firstName() + "\" + as the incorrect first name");

        AddressFormFiller.get(data, getDriver()).clickSaveAddressButton();

        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.BILLING_ADDRESS_FORM.getName(),
                "No message about an incorrect first name");
    }

    @Test(dataProvider = "AF_incorrectLastName", dataProviderClass = MyDataProvider.class)
    public void incorrectLastName(AddressFormData data) throws IllegalAccessException {

        ExtentReportsManager.setName("\"" + data.lastName() + "\" + as the incorrect last name");

        AddressFormFiller.get(data, getDriver()).clickSaveAddressButton();

        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.BILLING_ADDRESS_FORM.getName(),
                "No message about an incorrect last name");
    }

    @Test(dataProvider = "AF_incorrectPostcode", dataProviderClass = MyDataProvider.class)
    public void incorrectPostcode(AddressFormData data) throws IllegalAccessException {

        ExtentReportsManager.setName("\"" + data.postcode() + "\" + as the incorrect postcode");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed(), "No message about an incorrect postcode");
            Assert.assertEquals(af.getErrorMessageText(), data.errorMessage(), "Incorrect message content");
        });
    }

    @Test(dataProvider = "AF_incorrectPhoneNumber", dataProviderClass = MyDataProvider.class)
    public void incorrectPhoneNumber(AddressFormData data) throws IllegalAccessException {

        ExtentReportsManager.setName("\"" + data.phone() + "\" + as the incorrect phone number");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed(), "No message about an incorrect phone number");
            Assert.assertEquals(af.getErrorMessageText(), data.errorMessage(), "Incorrect message content");
        });
    }

    @Test(dataProvider = "AF_incorrectEmail", dataProviderClass = MyDataProvider.class)
    public void incorrectEmail(AddressFormData data) throws IllegalAccessException {

        ExtentReportsManager.setName("\"" + data.email() + "\" + as the incorrect email");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.getValidationMessageText().contains(data.errorMessage()),"Incorrect message content");
        });
    }

    @Test(dataProvider = "AF_withoutFirstName", dataProviderClass = MyDataProvider.class)
    public void blankFirstNameField(AddressFormData data) throws IllegalAccessException {

        ExtentReportsManager.setName("Blank the first name field");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed(), "No message about the blank first name field");
            Assert.assertEquals(af.getErrorMessageText(), data.errorMessage(), "Incorrect message content");
        });
    }

    @Test(dataProvider = "AF_withoutLastName", dataProviderClass = MyDataProvider.class)
    public void blankLastNameField(AddressFormData data) throws IllegalAccessException {

        ExtentReportsManager.setName("Blank the last name field");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed(), "No message about the blank last name field");
            Assert.assertEquals(af.getErrorMessageText(), data.errorMessage(), "Incorrect message content");
        });
    }

    @Test(dataProvider = "AF_withoutAddress", dataProviderClass = MyDataProvider.class)
    public void blankAddressField(AddressFormData data) throws IllegalAccessException {

        ExtentReportsManager.setName("Blank the address field");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed(), "No message about the blank address field");
            Assert.assertEquals(af.getErrorMessageText(), data.errorMessage(), "Incorrect message content");
        });
    }

    @Test(dataProvider = "AF_withoutCity", dataProviderClass = MyDataProvider.class)
    public void blankCityField(AddressFormData data) throws IllegalAccessException {

        ExtentReportsManager.setName("Blank the city field");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed(), "No message about the blank city field");
            Assert.assertEquals(af.getErrorMessageText(), data.errorMessage(), "Incorrect message content");
        });
    }

    @Test(dataProvider = "AF_withoutPostcode", dataProviderClass = MyDataProvider.class)
    public void blankPostcodeField(AddressFormData data) throws IllegalAccessException {

        ExtentReportsManager.setName("Blank the postcode field");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed(), "No message about the blank postcode field");
            Assert.assertEquals(af.getErrorMessageText(), data.errorMessage(), "Incorrect message content");
        });
    }

    @Test(dataProvider = "AF_withoutPhone", dataProviderClass = MyDataProvider.class)
    public void blankPhoneField(AddressFormData data) throws IllegalAccessException {

        ExtentReportsManager.setName("Blank the phone field");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed(), "No message about the blank phone field");
            Assert.assertEquals(af.getErrorMessageText(), data.errorMessage(), "Incorrect message content");
        });
    }

    @Test(dataProvider = "AF_withoutEmail", dataProviderClass = MyDataProvider.class)
    public void blankEmailField(AddressFormData data) throws IllegalAccessException {

        ExtentReportsManager.setName("Blank the email field");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed(), "No message about the blank email field");
            Assert.assertEquals(af.getErrorMessageText(), data.errorMessage(), "Incorrect message content");
        });
    }
}