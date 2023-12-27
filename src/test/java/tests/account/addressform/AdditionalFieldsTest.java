package tests.account.addressform;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.URLs;
import qa.helpers.Authentication;
import qa.pageobject.addressform.AddressForm;
import qa.provider.MyDataProvider;
import qa.extentreports.ExtentReportsManager;
import java.util.function.Consumer;

public class AdditionalFieldsTest extends BaseTest {

    private AddressForm addressForm;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToSpecificPage(URLs.LOGIN_PAGE.getName());
        Authentication.loginWithCredentials(getDriver());
        goToSpecificPage(URLs.BILLING_ADDRESS_FORM.getName());

        addressForm = new AddressForm(getDriver());
    }

    private void check(String country, Consumer<AddressForm> consumer, String expectedLabelText) throws IllegalAccessException {

        addressForm.getCountryDropdownList().clickCountryButton();
        addressForm.getCountryDropdownList().setCountry(country);
        addressForm.getCountryDropdownList().pressEnter();

        consumer.accept(addressForm);

        Assert.assertEquals(addressForm.getBillingStateLabelText(), expectedLabelText,
                "Incorrect additional field name");
    }

    @Test(dataProvider = "stateCountyField", dataProviderClass = MyDataProvider.class)
    public void stateCountyField(String country) throws IllegalAccessException {

        ExtentReportsManager.setName("The appearance of the \"State / County *\" field after entering \"" + country + "as the country name");

        check(country,
             (AddressForm af)->{Assert.assertTrue(af.isAdditionalFieldVisible(), "No additional field");},
             "State / County *");
    }

    @Test(dataProvider = "stateCountyDropdownList", dataProviderClass = MyDataProvider.class)
    public void stateCountyDropdownList(String country) throws IllegalAccessException {

        ExtentReportsManager.setName("The appearance of the \"State / County *\" drop-down list after entering \"" + country + "as the country name");

        check(country,
             (AddressForm af)->{Assert.assertTrue(af.isAdditionalDropdownListVisible(), "No additional drop-down list");},
             "State / County *");
    }

    @Test(dataProvider = "countyDropdownList", dataProviderClass = MyDataProvider.class)
    public void countyDropdownList(String country) throws IllegalAccessException {

        ExtentReportsManager.setName("The appearance of the \"County *\" drop-down list after entering \"" + country + "as the country name");

        check(country,
             (AddressForm af)->{Assert.assertTrue(af.isAdditionalDropdownListVisible(), "No additional drop-down list");},
             "County *");
    }

    @Test(dataProvider = "stateDropdownList", dataProviderClass = MyDataProvider.class)
    public void stateDropdownList(String country) throws IllegalAccessException {

        ExtentReportsManager.setName("The appearance of the \"State *\" drop-down list after entering \"" + country + "as the country name");

        check(country,
             (AddressForm af)->{Assert.assertTrue(af.isAdditionalDropdownListVisible(), "No additional drop-down list");},
              "State *");
    }

    @Test(dataProvider = "districtDropdownList", dataProviderClass = MyDataProvider.class)
    public void districtDropdownList(String country) throws IllegalAccessException {

        ExtentReportsManager.setName("The appearance of the \"District *\" drop-down list after entering \"" + country + "as the country name");

        check(country,
             (AddressForm af)->{Assert.assertTrue(af.isAdditionalDropdownListVisible(), "No additional drop-down list");},
             "District *");
    }

    @Test(dataProvider = "provinceDropdownList", dataProviderClass = MyDataProvider.class)
    public void provinceDropdownList(String country) throws IllegalAccessException {

        ExtentReportsManager.setName("The appearance of the \"Province *\" drop-down list after entering \"" + country + "as the country name");

        check(country,
             (AddressForm af)->{Assert.assertTrue(af.isAdditionalDropdownListVisible(), "No additional drop-down list");},
             "Province *");
    }

    @Test(dataProvider = "regionField", dataProviderClass = MyDataProvider.class)
    public void regionField(String country) throws IllegalAccessException {

        ExtentReportsManager.setName("The appearance of the \"Region *\" field after entering \"" + country + "as the country name");

        check(country,
             (AddressForm af)->{Assert.assertTrue(af.isAdditionalFieldVisible(), "No additional field");},
              "Region *");
    }

    @Test(dataProvider = "regionDropdownList", dataProviderClass = MyDataProvider.class)
    public void regionDropdownList(String country) throws IllegalAccessException {

        ExtentReportsManager.setName("The appearance of the \"Region\" drop-down list after entering \"" + country + "as the country name");

        check(country,
             (AddressForm af)->{Assert.assertTrue(af.isAdditionalDropdownListVisible(), "No additional drop-down list");},
             "Region");
    }

    @Test(dataProvider = "prefectureDropdownList", dataProviderClass = MyDataProvider.class)
    public void prefectureDropdownList(String country) throws IllegalAccessException {

        ExtentReportsManager.setName("The appearance of the \"Prefecture *\" drop-down list after entering \"" + country + "as the country name");

        check(country,
             (AddressForm af)->{Assert.assertTrue(af.isAdditionalDropdownListVisible(), "No additional drop-down list");},
              "Prefecture *");
    }

    @Test(dataProvider = "municipalityField", dataProviderClass = MyDataProvider.class)
    public void municipalityField(String country) throws IllegalAccessException {

        ExtentReportsManager.setName("The appearance of the \"Municipality\" field after entering \"" + country + "as the country name");

        check(country,
             (AddressForm af)->{Assert.assertTrue(af.isAdditionalFieldVisible(), "No additional field");},
             "Municipality");
    }

    @Test(dataProvider = "stateZoneDropdownList", dataProviderClass = MyDataProvider.class)
    public void stateZoneDropdownList(String country) throws IllegalAccessException {

        ExtentReportsManager.setName("The appearance of the \"State / Zone *\" drop-down list after entering \"" + country + "as the country name");

        check(country,
             (AddressForm af)->{Assert.assertTrue(af.isAdditionalDropdownListVisible(), "No additional drop-down list");},
              "State / Zone *");
    }
}
