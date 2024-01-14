package tests.account.addressform;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.URLs;
import qa.helpers.Authentication;
import qa.pageobject.addressform.AddressForm;
import qa.dataproviders.DataProviders;
import qa.utils.AccessThrowingConsumer;

public class AdditionalFieldsTest extends BaseTest {

    private AddressForm addressForm;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToSpecificPage(URLs.LOGIN_PAGE.getName());
        Authentication.loginWithCredentials(getDriver());
        goToSpecificPage(URLs.BILLING_ADDRESS_FORM.getName());

        addressForm = new AddressForm(getDriver());
    }

    private void setCountry(String country) throws IllegalAccessException {

        addressForm.getCountryDropdownList().clickCountryButton();
        addressForm.getCountryDropdownList().setCountry(country);
        addressForm.getCountryDropdownList().pressEnter();
    }

    private void checkForAdditionalItemVisibility(AccessThrowingConsumer<AddressForm> consumer) {

        try {
            consumer.accept(addressForm);
        } catch (Exception e) {
            Assert.fail("No additional item displayed");
        }
    }

    private void checkForAdditionalLabelVisibility() {

        try {
            addressForm.waitForAdditionalLabel();
        } catch (Exception e) {
            Assert.fail("No label displayed");
        }
    }

    private void checkAdditionalLabelText(String expectedLabelText) throws IllegalAccessException {

        Assert.assertEquals(addressForm.getAdditionalLabelText(), expectedLabelText,
                    "Incorrect additional field name");
    }

    private void check(String country, AccessThrowingConsumer<AddressForm> consumer, String labelText) throws IllegalAccessException {

        setCountry(country);
        checkForAdditionalItemVisibility(consumer);
        checkForAdditionalLabelVisibility();
        checkAdditionalLabelText(labelText);
    }

    @Test(dataProvider = "stateCountyField", dataProviderClass = DataProviders.class)
    public void stateCountyField(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalField, "State / County *");
    }

    @Test(dataProvider = "stateCountyDropdownList", dataProviderClass = DataProviders.class)
    public void stateCountyDropdownList(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalDropdownList, "State / County *");
    }

    @Test(dataProvider = "countyDropdownList", dataProviderClass = DataProviders.class)
    public void countyDropdownList(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalDropdownList, "County *");
    }

    @Test(dataProvider = "stateDropdownList", dataProviderClass = DataProviders.class)
    public void stateDropdownList(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalDropdownList, "State *");
    }

    @Test(dataProvider = "districtDropdownList", dataProviderClass = DataProviders.class)
    public void districtDropdownList(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalDropdownList, "District *");
    }

    @Test(dataProvider = "provinceDropdownList", dataProviderClass = DataProviders.class)
    public void provinceDropdownList(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalDropdownList, "Province *");
    }

    @Test(dataProvider = "regionField", dataProviderClass = DataProviders.class)
    public void regionField(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalField, "Region *");
    }

    @Test(dataProvider = "regionDropdownList", dataProviderClass = DataProviders.class)
    public void regionDropdownList(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalDropdownList, "Region");
    }

    @Test(dataProvider = "prefectureDropdownList", dataProviderClass = DataProviders.class)
    public void prefectureDropdownList(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalDropdownList, "Prefecture *");
    }

    @Test(dataProvider = "municipalityField", dataProviderClass = DataProviders.class)
    public void municipalityField(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalField, "Municipality");
    }

    @Test(dataProvider = "stateZoneDropdownList", dataProviderClass = DataProviders.class)
    public void stateZoneDropdownList(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalDropdownList, "State / Zone *");
    }
}
