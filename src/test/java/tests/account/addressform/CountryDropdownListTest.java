package tests.account.addressform;

import qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.helpers.Authentication;
import qa.pageobject.addressform.CountryDropdownList;
import qa.dataproviders.DataProviders;


public class CountryDropdownListTest extends BaseTest {

    private CountryDropdownList countryDropdownList;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToSpecificPage(URLs.LOGIN_PAGE.getName());
        Authentication.loginWithCredentials(getDriver());
        goToSpecificPage(URLs.BILLING_ADDRESS_FORM.getName());

        countryDropdownList = new CountryDropdownList(getDriver());
    }

    private void fill(String countryName) throws IllegalAccessException {

        countryDropdownList.clickCountryButton();
        countryDropdownList.setCountry(countryName);
    }

    @Test(dataProvider = "correctCountryName", dataProviderClass = DataProviders.class)
    public void correctCountryName(String countryName) throws IllegalAccessException {

        fill(countryName);

        Assert.assertFalse(countryDropdownList.isAlertDisplayed(), "The alert is displayed");
    }

    @Test(dataProvider = "incorrectCountryName", dataProviderClass = DataProviders.class)
    public void incorrectCountryName(String countryName) throws IllegalAccessException {

        fill(countryName);

        Assert.assertTrue(countryDropdownList.isAlertDisplayed(), "The alert is not displayed");
    }
}
