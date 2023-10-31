package tests;

import org.testng.Assert;
import qa.base.BaseTest;
import qa.factories.AddressFormFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.account.AccountPage;
import qa.pageobject.account.AddressColumns;
import qa.pageobject.addressform.AddressForm;
import qa.pageobject.header.Header;
import qa.provider.MyDataProvider;
import qa.utils.AddressFormData;
import qa.utils.ExtentReportsManager;

import java.util.function.Consumer;

public class AddressFormTests extends BaseTest {

    @BeforeMethod
    public void create() {

        Header header = new Header(getDriver());
        AccountPage accountPage = new AccountPage(getDriver());
        AddressColumns addressColumns = new AddressColumns(getDriver());

        header.clickAccountButton();
        login("karen@gmail.com", "Kvc$11324#");

        accountPage.getAccountNavigation().clickLink("Addresses");
        addressColumns.clickBillingAddressLink();
    }

    private void fill(AddressFormData data, Consumer<AddressForm> consumer) {

        AddressForm addressForm = AddressFormFactory.get(data, getDriver());
        addressForm.clickSaveAddressButton();

        consumer.accept(addressForm);
    }

    @Test(dataProvider = "AF_correctAddress", dataProviderClass = MyDataProvider.class)
    public void correctAddressData(AddressFormData data) {

        ExtentReportsManager.setName("Correct address data");

        AddressFormFactory.get(data, getDriver()).clickSaveAddressButton();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://skleptest.pl/my-account/edit-address/");
    }

    @Test(dataProvider = "AF_incorrectFirstName", dataProviderClass = MyDataProvider.class)
    public void incorrectFirstName(AddressFormData data) {

        ExtentReportsManager.setName("\"" + data.getFirstName() + "\" + as the incorrect first name");

        AddressFormFactory.get(data, getDriver()).clickSaveAddressButton();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://skleptest.pl/my-account/edit-address/billing/");
    }

    @Test(dataProvider = "AF_incorrectLastName", dataProviderClass = MyDataProvider.class)
    public void incorrectLastName(AddressFormData data) {

        ExtentReportsManager.setName("\"" + data.getLastName() + "\" + as the incorrect last name");

        AddressFormFactory.get(data, getDriver()).clickSaveAddressButton();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://skleptest.pl/my-account/edit-address/billing/");
    }

    @Test(dataProvider = "AF_incorrectPostcode", dataProviderClass = MyDataProvider.class)
    public void incorrectPostcode(AddressFormData data) {

        ExtentReportsManager.setName("\"" + data.getPostcode() + "\" + as the incorrect postcode");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed());
            Assert.assertEquals(af.getErrorMessageText(), data.getErrorMessage());
        });
    }

    @Test(dataProvider = "AF_incorrectPhoneNumber", dataProviderClass = MyDataProvider.class)
    public void incorrectPhoneNumber(AddressFormData data) {

        ExtentReportsManager.setName("\"" + data.getPhone() + "\" + as the incorrect phone number");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed());
            Assert.assertEquals(af.getErrorMessageText(), data.getErrorMessage());
        });
    }

    @Test(dataProvider = "AF_incorrectEmail", dataProviderClass = MyDataProvider.class)
    public void incorrectEmail(AddressFormData data) {

        ExtentReportsManager.setName("\"" + data.getEmail() + "\" + as the incorrect email");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.getValidationMessageText().contains(data.getErrorMessage()));
        });
    }

    @Test(dataProvider = "AF_withoutFirstName", dataProviderClass = MyDataProvider.class)
    public void blankFirstNameField(AddressFormData data) {

        ExtentReportsManager.setName("Blank the first name field");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed());
            Assert.assertEquals(af.getErrorMessageText(), data.getErrorMessage());
        });
    }

    @Test(dataProvider = "AF_withoutLastName", dataProviderClass = MyDataProvider.class)
    public void blankLastNameField(AddressFormData data) {

        ExtentReportsManager.setName("Blank the last name field");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed());
            Assert.assertEquals(af.getErrorMessageText(), data.getErrorMessage());
        });
    }

    @Test(dataProvider = "AF_withoutAddress", dataProviderClass = MyDataProvider.class)
    public void blankAddressField(AddressFormData data) {

        ExtentReportsManager.setName("Blank the address field");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed());
            Assert.assertEquals(af.getErrorMessageText(), data.getErrorMessage());
        });
    }

    @Test(dataProvider = "AF_withoutCity", dataProviderClass = MyDataProvider.class)
    public void blankCityField(AddressFormData data) {

        ExtentReportsManager.setName("Blank the city field");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed());
            Assert.assertEquals(af.getErrorMessageText(), data.getErrorMessage());
        });
    }

    @Test(dataProvider = "AF_withoutPostcode", dataProviderClass = MyDataProvider.class)
    public void blankPostcodeField(AddressFormData data) {

        ExtentReportsManager.setName("Blank the postcode field");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed());
            Assert.assertEquals(af.getErrorMessageText(), data.getErrorMessage());
        });
    }

    @Test(dataProvider = "AF_withoutPhone", dataProviderClass = MyDataProvider.class)
    public void blankPhoneField(AddressFormData data) {

        ExtentReportsManager.setName("Blank the phone field");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed());
            Assert.assertEquals(af.getErrorMessageText(), data.getErrorMessage());
        });
    }

    @Test(dataProvider = "AF_withoutEmail", dataProviderClass = MyDataProvider.class)
    public void blankEmailField(AddressFormData data) {

        ExtentReportsManager.setName("Blank the email field");

        fill(data, (AddressForm af)->{
            Assert.assertTrue(af.isErrorMessageDisplayed());
            Assert.assertEquals(af.getErrorMessageText(), data.getErrorMessage());
        });
    }
}