package tests.account.addressform;

import qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.helpers.Authentication;
import qa.pageobject.addressform.CountryDropdownList;
import qa.provider.MyDataProvider;
import qa.extentreports.ExtentReportsManager;

import java.awt.*;

public class CountryDropdownListTest extends BaseTest {

    private CountryDropdownList countryDropdownList;

    @BeforeMethod
    public void create() throws AWTException, IllegalAccessException {

        goToSpecificPage(URLs.LOGIN_PAGE.getName());
        Authentication.loginWithCredentials(getDriver());
        goToSpecificPage(URLs.BILLING_ADDRESS_FORM.getName());

        countryDropdownList = new CountryDropdownList(getDriver());
    }

    @Test(dataProvider = "correctCountryName", dataProviderClass = MyDataProvider.class)
    public void correctCountryName(String countryName) throws IllegalAccessException {

        ExtentReportsManager.setName("Searching with a correct country name");

        countryDropdownList.clickCountryButton();
        countryDropdownList.setCountry(countryName);

        Assert.assertFalse(countryDropdownList.isAlertDisplayed(), "A country \"" + countryName + "\" has not been found");
    }

    @Test(dataProvider = "incorrectCountryName", dataProviderClass = MyDataProvider.class)
    public void incorrectCountryName(String countryName) throws IllegalAccessException {

        countryDropdownList.clickCountryButton();
        countryDropdownList.setCountry(countryName);

        Assert.assertTrue(countryDropdownList.isAlertDisplayed(), "No message about an incorrect country name");
    }
}
