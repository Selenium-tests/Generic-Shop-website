package tests.account.addressform;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import qa.dataproviders.DynamicFieldsDataProviders;
import qa.enums.URLs;
import qa.helpers.Authentication;
import qa.pageobject.addressform.AddressForm;
import qa.support.dataprovidernames.DataProviderNames;
import qa.utils.AccessThrowingConsumer;

public class DynamicFieldsTest extends BaseTest {

    private AddressForm addressForm;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToSpecificPage(URLs.LOGIN_PAGE.getName());
        Authentication.loginWithCredentials(getDriver());
        goToSpecificPage(URLs.BILLING_ADDRESS_FORM.getName());

        addressForm = new AddressForm(getDriver());
    }

    private void setCountry(String country) throws IllegalAccessException {

        //addressForm.getCountryDropdownList().clickCountryButton();
        addressForm.getCountryDropdownList().setCountry(country);
        //addressForm.getCountryDropdownList().pressEnter();
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

    private void checkAdditionalLabelText(String expectedLabelText) {

        Assert.assertEquals(addressForm.getAdditionalLabelText(), expectedLabelText,
                    "Incorrect additional field name");
    }

    private void check(String country, AccessThrowingConsumer<AddressForm> consumer, String labelText) throws IllegalAccessException {

        setCountry(country);
        checkForAdditionalItemVisibility(consumer);
        checkForAdditionalLabelVisibility();
        checkAdditionalLabelText(labelText);
    }

    @Test(dataProvider = DataProviderNames.STATE_COUNTY_FIELD, dataProviderClass = DynamicFieldsDataProviders.class)
    public void stateCountyField(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalField, "State / County *");
    }

    @Test(dataProvider = DataProviderNames.STATE_COUNTY_DROPDOWN_LIST, dataProviderClass = DynamicFieldsDataProviders.class)
    public void stateCountyDropdownList(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalDropdownList, "State / County *");
    }

    @Test(dataProvider = DataProviderNames.COUNTY_DROPDOWN_LIST, dataProviderClass = DynamicFieldsDataProviders.class)
    public void countyDropdownList(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalDropdownList, "County *");
    }

    @Test(dataProvider = DataProviderNames.STATE_DROPDOWN_LIST, dataProviderClass = DynamicFieldsDataProviders.class)
    public void stateDropdownList(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalDropdownList, "State *");
    }

    @Test(dataProvider = DataProviderNames.DISTRICT_DROPDOWN_LIST, dataProviderClass = DynamicFieldsDataProviders.class)
    public void districtDropdownList(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalDropdownList, "District *");
    }

    @Test(dataProvider = DataProviderNames.PROVINCE_DROPDOWN_LIST, dataProviderClass = DynamicFieldsDataProviders.class)
    public void provinceDropdownList(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalDropdownList, "Province *");
    }

    @Test(dataProvider = DataProviderNames.REGION_FIELD, dataProviderClass = DynamicFieldsDataProviders.class)
    public void regionField(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalField, "Region *");
    }

    @Test(dataProvider = DataProviderNames.REGION_DROPDOWN_LIST, dataProviderClass = DynamicFieldsDataProviders.class)
    public void regionDropdownList(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalDropdownList, "Region");
    }

    @Test(dataProvider = DataProviderNames.PREFECTURE_DROPDOWN_LIST, dataProviderClass = DynamicFieldsDataProviders.class)
    public void prefectureDropdownList(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalDropdownList, "Prefecture *");
    }

    @Test(dataProvider = DataProviderNames.MUNICIPALITY_FIELD, dataProviderClass = DynamicFieldsDataProviders.class)
    public void municipalityField(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalField, "Municipality");
    }

    @Test(dataProvider = DataProviderNames.STATE_ZONE_DROPDOWN_LIST, dataProviderClass = DynamicFieldsDataProviders.class)
    public void stateZoneDropdownList(String country) throws IllegalAccessException {

        check(country, AddressForm::waitForAdditionalDropdownList, "State / Zone *");
    }
}
