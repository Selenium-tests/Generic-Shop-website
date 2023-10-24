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

    @Test(dataProvider = "AF_correctAddress", dataProviderClass = MyDataProvider.class)
    public void correctAddressData(AddressFormData data) {

        AddressFormFactory.get(data, getDriver()).clickSaveAddressButton();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://skleptest.pl/my-account/edit-address/");
    }

    @Test(dataProvider = "AF_incorrectFirstName", dataProviderClass = MyDataProvider.class)
    public void incorrectFirstName(AddressFormData data) {

        AddressFormFactory.get(data, getDriver()).clickSaveAddressButton();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://skleptest.pl/my-account/edit-address/billing/");
    }

    @Test(dataProvider = "AF_incorrectLastName", dataProviderClass = MyDataProvider.class)
    public void incorrectLastName(AddressFormData data) {

        AddressFormFactory.get(data, getDriver()).clickSaveAddressButton();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://skleptest.pl/my-account/edit-address/billing/");
    }

    @Test(dataProvider = "AF_incorrectPostcode", dataProviderClass = MyDataProvider.class)
    public void incorrectPostcode(AddressFormData data) {

        AddressForm addressForm = AddressFormFactory.get(data, getDriver());

        addressForm.clickSaveAddressButton();

        Assert.assertTrue(addressForm.isErrorMessageDisplayed());
        Assert.assertEquals(addressForm.getErrorMessageText(), "Please enter a valid postcode / ZIP.");

    }

    @Test(dataProvider = "AF_incorrectPhoneNumber", dataProviderClass = MyDataProvider.class)
    public void incorrectPhoneNumber(AddressFormData data) {

        AddressForm addressForm = AddressFormFactory.get(data, getDriver());

        addressForm.clickSaveAddressButton();

        Assert.assertTrue(addressForm.isErrorMessageDisplayed());
        Assert.assertEquals(addressForm.getErrorMessageText(), "Phone is not a valid phone number.");
    }

    @Test(dataProvider = "AF_incorrectEmail", dataProviderClass = MyDataProvider.class)
    public void incorrectEmail(AddressFormData data) {

        AddressForm addressForm = AddressFormFactory.get(data, getDriver());

        addressForm.clickSaveAddressButton();

        Assert.assertTrue(addressForm.getValidationMessageText().contains(data.getErrorMessage()));
    }
}
