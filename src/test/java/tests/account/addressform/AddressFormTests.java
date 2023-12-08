package tests.account.addressform;

import org.testng.Assert;
import qa.base.BaseTest;
import qa.helpers.AddressFormFiller;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.helpers.AddressFormPageHandler;
import qa.helpers.Authentication;
import qa.pageobject.addressform.AddressForm;
import qa.provider.MyDataProvider;
import qa.records.AddressFormData;
import qa.extentreports.ExtentReportsManager;
import java.util.function.Consumer;

public class AddressFormTests extends BaseTest {

    @BeforeMethod
    public void create() {

        Authentication.loginWithCredentials(getDriver());
        AddressFormPageHandler.openAddressFormPage(getDriver());
    }

    private void fill(AddressFormData data, Consumer<AddressForm> consumer) {

        AddressForm addressForm = AddressFormFiller.get(data, getDriver());
        addressForm.clickSaveAddressButton();

        consumer.accept(addressForm);
    }

    @Test(dataProvider = "AF_correctAddress", dataProviderClass = MyDataProvider.class)
    public void correctAddressData(AddressFormData data) {

        ExtentReportsManager.setName("Filling the form with a correct address data");

        AddressFormFiller.get(data, getDriver()).clickSaveAddressButton();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://skleptest.pl/my-account/edit-address/",
                "The address data has not been saved");
    }

    @Test(dataProvider = "AF_incorrectFirstName", dataProviderClass = MyDataProvider.class)
    public void incorrectFirstName(AddressFormData data) {

        ExtentReportsManager.setName("\"" + data.firstName() + "\" + as the incorrect first name");

        AddressFormFiller.get(data, getDriver()).clickSaveAddressButton();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://skleptest.pl/my-account/edit-address/billing/",
                "No message about an incorrect first name");
    }

    @Test(dataProvider = "AF_incorrectLastName", dataProviderClass = MyDataProvider.class)
    public void incorrectLastName(AddressFormData data) {

        ExtentReportsManager.setName("\"" + data.lastName() + "\" + as the incorrect last name");

        AddressFormFiller.get(data, getDriver()).clickSaveAddressButton();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://skleptest.pl/my-account/edit-address/billing/",
                "No message about an incorrect last name");
    }

    @Test(dataProvider = "AF_incorrectPostcode", dataProviderClass = MyDataProvider.class)
    public void incorrectPostcode(AddressFormData data) {

        ExtentReportsManager.setName("\"" + data.postcode() + "\" + as the incorrect postcode");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed(), "No message about an incorrect postcode");
            Assert.assertEquals(af.getErrorMessageText(), data.errorMessage(), "Incorrect message text");
        });
    }

    @Test(dataProvider = "AF_incorrectPhoneNumber", dataProviderClass = MyDataProvider.class)
    public void incorrectPhoneNumber(AddressFormData data) {

        ExtentReportsManager.setName("\"" + data.phone() + "\" + as the incorrect phone number");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed(), "No message about an incorrect phone number");
            Assert.assertEquals(af.getErrorMessageText(), data.errorMessage(), "Incorrect message text");
        });
    }

    @Test(dataProvider = "AF_incorrectEmail", dataProviderClass = MyDataProvider.class)
    public void incorrectEmail(AddressFormData data) {

        ExtentReportsManager.setName("\"" + data.email() + "\" + as the incorrect email");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.getValidationMessageText().contains(data.errorMessage()),"Incorrect message text");
        });
    }

    @Test(dataProvider = "AF_withoutFirstName", dataProviderClass = MyDataProvider.class)
    public void blankFirstNameField(AddressFormData data) {

        ExtentReportsManager.setName("Blank the first name field");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed(), "No message about the blank first name field");
            Assert.assertEquals(af.getErrorMessageText(), data.errorMessage(), "Incorrect message text");
        });
    }

    @Test(dataProvider = "AF_withoutLastName", dataProviderClass = MyDataProvider.class)
    public void blankLastNameField(AddressFormData data) {

        ExtentReportsManager.setName("Blank the last name field");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed(), "No message about the blank last name field");
            Assert.assertEquals(af.getErrorMessageText(), data.errorMessage(), "Incorrect message text");
        });
    }

    @Test(dataProvider = "AF_withoutAddress", dataProviderClass = MyDataProvider.class)
    public void blankAddressField(AddressFormData data) {

        ExtentReportsManager.setName("Blank the address field");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed(), "No message about the blank address field");
            Assert.assertEquals(af.getErrorMessageText(), data.errorMessage(), "Incorrect message text");
        });
    }

    @Test(dataProvider = "AF_withoutCity", dataProviderClass = MyDataProvider.class)
    public void blankCityField(AddressFormData data) {

        ExtentReportsManager.setName("Blank the city field");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed(), "No message about the blank city field");
            Assert.assertEquals(af.getErrorMessageText(), data.errorMessage(), "Incorrect message text");
        });
    }

    @Test(dataProvider = "AF_withoutPostcode", dataProviderClass = MyDataProvider.class)
    public void blankPostcodeField(AddressFormData data) {

        ExtentReportsManager.setName("Blank the postcode field");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed(), "No message about the blank postcode field");
            Assert.assertEquals(af.getErrorMessageText(), data.errorMessage(), "Incorrect message text");
        });
    }

    @Test(dataProvider = "AF_withoutPhone", dataProviderClass = MyDataProvider.class)
    public void blankPhoneField(AddressFormData data) {

        ExtentReportsManager.setName("Blank the phone field");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed(), "No message about the blank phone field");
            Assert.assertEquals(af.getErrorMessageText(), data.errorMessage(), "Incorrect message text");
        });
    }

    @Test(dataProvider = "AF_withoutEmail", dataProviderClass = MyDataProvider.class)
    public void blankEmailField(AddressFormData data) {

        ExtentReportsManager.setName("Blank the email field");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed(), "No message about the blank email field");
            Assert.assertEquals(af.getErrorMessageText(), data.errorMessage(), "Incorrect message text");
        });
    }
}