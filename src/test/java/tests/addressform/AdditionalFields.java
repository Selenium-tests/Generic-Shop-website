package tests.addressform;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.pageobject.account.AccountPage;
import qa.pageobject.account.AddressColumns;
import qa.pageobject.addressform.AddressForm;
import qa.pageobject.header.Header;
import qa.provider.MyDataProvider;

public class AdditionalFields extends BaseTest {

    private AddressForm addressForm;

    @BeforeMethod
    public void create() {

        Header header = new Header(getDriver());
        AccountPage accountPage = new AccountPage(getDriver());
        AddressColumns addressColumns = new AddressColumns(getDriver());

        header.clickAccountButton();
        login("karen@gmail.com", "Kvc$11324#");

        accountPage.getAccountNavigation().clickLink("Addresses");
        addressColumns.clickBillingAddressLink();

        addressForm = new AddressForm(getDriver());
    }

    private void fill(String country) {

        addressForm.getCountryDropdownList().clickCountryButton();
        addressForm.getCountryDropdownList().setCountry(country);
        addressForm.getCountryDropdownList().pressEnter();
    }

    @Test(dataProvider = "stateCountyDropdownList", dataProviderClass = MyDataProvider.class)
    public void stateCountyDropdownList(String country) {

        fill(country);

        Assert.assertTrue(addressForm.isStateCountyFieldVisible());
    }
}
