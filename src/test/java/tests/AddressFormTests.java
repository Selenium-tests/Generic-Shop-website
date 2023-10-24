package tests;

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

        AddressForm addressForm = AddressFormFactory.correctData(data, getDriver());

        addressForm.clickSaveAddressButton();
    }
}
