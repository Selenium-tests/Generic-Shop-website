package tests;

import qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.pageobject.account.AccountPage;
import qa.pageobject.account.AddressColumns;
import qa.pageobject.addressform.CountryDropdownList;
import qa.pageobject.header.Header;
import qa.provider.MyDataProvider;

import java.awt.*;

public class CountryDropdownListTests extends BaseTest {

    private CountryDropdownList countryDropdownList;

    @BeforeMethod
    public void create() throws AWTException {

        Header header = new Header(getDriver());
        AccountPage accountPage = new AccountPage(getDriver());
        AddressColumns addressColumns = new AddressColumns(getDriver());

        header.clickAccountButton();
        login("karen@gmail.com", "Kvc$11324#");

        accountPage.getAccountNavigation().clickLink("Addresses");
        addressColumns.clickBillingAddressLink();

        countryDropdownList = new CountryDropdownList(getDriver());
    }

    @Test(dataProvider = "correctCountryName", dataProviderClass = MyDataProvider.class)
    public void correctCountryName(String countryName) {

        countryDropdownList.clickCountryButton();
        countryDropdownList.setCountry(countryName);

        Assert.assertFalse(countryDropdownList.isAlertDisplayed());
    }

    @Test(dataProvider = "incorrectCountryName", dataProviderClass = MyDataProvider.class)
    public void incorrectCountryName(String countryName) {

        countryDropdownList.clickCountryButton();
        countryDropdownList.setCountry(countryName);

        Assert.assertTrue(countryDropdownList.isAlertDisplayed());
    }
}
