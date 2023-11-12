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


import java.util.function.Consumer;

public class AdditionalFieldsTests extends BaseTest {

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

    private void check(String country, Consumer<AddressForm> consumer, String expectedLabelText) {

        addressForm.getCountryDropdownList().clickCountryButton();
        addressForm.getCountryDropdownList().setCountry(country);
        addressForm.getCountryDropdownList().pressEnter();

        consumer.accept(addressForm);

        Assert.assertEquals(addressForm.getBillingStateLabelText(), expectedLabelText);
    }

    @Test(dataProvider = "stateCountyField", dataProviderClass = MyDataProvider.class)
    public void stateCountyField(String country) {

        check(country, (AddressForm af)->{Assert.assertTrue(af.isAdditionalFieldVisible());}, "State / County *");
    }

    @Test(dataProvider = "stateCountyDropdownList", dataProviderClass = MyDataProvider.class)
    public void stateCountyDropdownList(String country) {

        check(country, (AddressForm af)->{Assert.assertTrue(af.isAdditionalDropdownListVisible());}, "State / County *");
    }

    @Test(dataProvider = "countyDropdownList", dataProviderClass = MyDataProvider.class)
    public void countyDropdownList(String country) {

        check(country, (AddressForm af)->{Assert.assertTrue(af.isAdditionalDropdownListVisible());}, "County *");
    }

    @Test(dataProvider = "stateDropdownList", dataProviderClass = MyDataProvider.class)
    public void stateDropdownList(String country) {

        check(country, (AddressForm af)->{Assert.assertTrue(af.isAdditionalDropdownListVisible());}, "State *");
    }

    @Test(dataProvider = "districtDropdownList", dataProviderClass = MyDataProvider.class)
    public void districtDropdownList(String country) {

        check(country, (AddressForm af)->{Assert.assertTrue(af.isAdditionalDropdownListVisible());}, "District *");
    }

    @Test(dataProvider = "provinceDropdownList", dataProviderClass = MyDataProvider.class)
    public void provinceDropdownList(String country) {

        check(country, (AddressForm af)->{Assert.assertTrue(af.isAdditionalDropdownListVisible());}, "Province *");
    }

    @Test(dataProvider = "regionField", dataProviderClass = MyDataProvider.class)
    public void regionField(String country) {

        check(country, (AddressForm af)->{Assert.assertTrue(af.isAdditionalFieldVisible());}, "Region *");
    }

    @Test(dataProvider = "regionDropdownList", dataProviderClass = MyDataProvider.class)
    public void regionDropdownList(String country) {

        check(country, (AddressForm af)->{Assert.assertTrue(af.isAdditionalDropdownListVisible());}, "Region *");
    }

    @Test(dataProvider = "prefectureDropdownList", dataProviderClass = MyDataProvider.class)
    public void prefectureDropdownList(String country) {

        check(country, (AddressForm af)->{Assert.assertTrue(af.isAdditionalDropdownListVisible());}, "Prefecture *");
    }

    @Test(dataProvider = "municipalityField", dataProviderClass = MyDataProvider.class)
    public void municipalityField(String country) {

        check(country, (AddressForm af)->{Assert.assertTrue(af.isAdditionalFieldVisible());}, "Municipality *");
    }

    @Test(dataProvider = "stateZoneDropdownList", dataProviderClass = MyDataProvider.class)
    public void stateZoneDropdownList(String country) {

        check(country, (AddressForm af)->{Assert.assertTrue(af.isAdditionalDropdownListVisible());}, "State / Zone *");
    }
}
