package tests.account.addressform;

import qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.helpers.AddressFormPageHandler;
import qa.helpers.Authentication;
import qa.pageobject.addressform.CountryDropdownList;
import qa.provider.MyDataProvider;
import qa.extentreports.ExtentReportsManager;

import java.awt.*;

public class CountryDropdownListTests extends BaseTest {

    private CountryDropdownList countryDropdownList;

    @BeforeMethod
    public void create() throws AWTException {

        Authentication.loginWithCredentials(getDriver());
        AddressFormPageHandler.openAddressFormPage(getDriver());

        countryDropdownList = new CountryDropdownList(getDriver());
    }

    @Test(dataProvider = "correctCountryName", dataProviderClass = MyDataProvider.class)
    public void correctCountryName(String countryName) {

        ExtentReportsManager.setName("Searching with a correct country name");

        countryDropdownList.clickCountryButton();
        countryDropdownList.setCountry(countryName);

        Assert.assertFalse(countryDropdownList.isAlertDisplayed(), "A country \"" + countryName + "\" has not been found");
    }

    @Test(dataProvider = "incorrectCountryName", dataProviderClass = MyDataProvider.class)
    public void incorrectCountryName(String countryName) {

        countryDropdownList.clickCountryButton();
        countryDropdownList.setCountry(countryName);

        Assert.assertTrue(countryDropdownList.isAlertDisplayed(), "No message about an incorrect country name");
    }
}
