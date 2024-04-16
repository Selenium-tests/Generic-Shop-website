package tests.account.addressform;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import qa.dataproviders.DynamicFieldsDataProviders;
import qa.support.constans.URLs;
import qa.support.actions.Authentication;
import qa.pageobject.addressform.AddressForm;
import qa.support.constans.DataProviderNames;
import qa.support.consumer.AccessThrowingConsumer;

@Epic("E2E")
@Feature("The billing address form dynamic fields")
public class DynamicFieldsTest extends BaseTest {

    private AddressForm addressForm;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToPage(URLs.LOGIN_PAGE);
        Authentication.loginWithCredentials(getDriver());
        goToPage(URLs.BILLING_ADDRESS_FORM);

        addressForm = new AddressForm(getDriver());
    }

    private void setCountry(String country) {

        addressForm.getCountryDropdownList().setCountry(country);
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

    private void check(String country, AccessThrowingConsumer<AddressForm> consumer, String labelText) {

        setCountry(country);
        checkForAdditionalItemVisibility(consumer);
        checkForAdditionalLabelVisibility();
        checkAdditionalLabelText(labelText);
    }

    @Test(priority = 1, dataProvider = DataProviderNames.STATE_COUNTY_FIELD, dataProviderClass = DynamicFieldsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(80)
    @QaseTitle("The \"State / County\" field visibility")
    @Description("The \"State / County\" field visibility")
    public void stateCountyField(String country) {

        Allure.parameter("Country", country);
        check(country, AddressForm::waitForAdditionalField, "State / County *");
    }

    @Test(priority = 2, dataProvider = DataProviderNames.STATE_COUNTY_DROPDOWN_LIST, dataProviderClass = DynamicFieldsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(81)
    @QaseTitle("The \"State / County\" dropdown list visibility")
    @Description("The \"State / County\" dropdown list visibility")
    public void stateCountyDropdownList(String country) {

        Allure.parameter("Country", country);
        check(country, AddressForm::waitForAdditionalDropdownList, "State / County *");
    }

    @Test(priority = 3, dataProvider = DataProviderNames.COUNTY_DROPDOWN_LIST, dataProviderClass = DynamicFieldsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(82)
    @QaseTitle("The \"County\" dropdown list visibility")
    @Description("The \"County\" dropdown list visibility")
    public void countyDropdownList(String country) {

        Allure.parameter("Country", country);
        check(country, AddressForm::waitForAdditionalDropdownList, "County *");
    }

    @Test(priority = 4, dataProvider = DataProviderNames.STATE_DROPDOWN_LIST, dataProviderClass = DynamicFieldsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(83)
    @QaseTitle("The \"State\" dropdown list visibility")
    @Description("The \"State\" dropdown list visibility")
    public void stateDropdownList(String country) {

        Allure.parameter("Country", country);
        check(country, AddressForm::waitForAdditionalDropdownList, "State *");
    }

    @Test(priority = 5, dataProvider = DataProviderNames.DISTRICT_DROPDOWN_LIST, dataProviderClass = DynamicFieldsDataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(84)
    @QaseTitle("The \"District\" dropdown list visibility")
    @Description("The \"District\" dropdown list visibility")
    public void districtDropdownList(String country) {

        Allure.parameter("Country", country);
        check(country, AddressForm::waitForAdditionalDropdownList, "District *");
    }

    @Test(priority = 6, dataProvider = DataProviderNames.PROVINCE_DROPDOWN_LIST, dataProviderClass = DynamicFieldsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(85)
    @QaseTitle("The \"Province\" dropdown list visibility")
    @Description("The \"Province\" dropdown list visibility")
    public void provinceDropdownList(String country) {

        Allure.parameter("Country", country);
        check(country, AddressForm::waitForAdditionalDropdownList, "Province *");
    }

    @Test(priority = 7, dataProvider = DataProviderNames.REGION_FIELD, dataProviderClass = DynamicFieldsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(86)
    @QaseTitle("The \"Region\" field visibility")
    @Description("The \"Region\" field visibility")
    public void regionField(String country) {

        Allure.parameter("Country", country);
        check(country, AddressForm::waitForAdditionalField, "Region *");
    }

    @Test(priority = 8, dataProvider = DataProviderNames.REGION_DROPDOWN_LIST, dataProviderClass = DynamicFieldsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(87)
    @QaseTitle("The \"Region\" dropdown list visibility")
    @Description("The \"Region\" dropdown list visibility")
    public void regionDropdownList(String country) {

        Allure.parameter("Country", country);
        check(country, AddressForm::waitForAdditionalDropdownList, "Region");
    }

    @Test(priority = 9, dataProvider = DataProviderNames.PREFECTURE_DROPDOWN_LIST, dataProviderClass = DynamicFieldsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(88)
    @QaseTitle("The \"Prefecture\" dropdown list visibility")
    @Description("The \"Prefecture\" dropdown list visibility")
    public void prefectureDropdownList(String country) {

        Allure.parameter("Country", country);
        check(country, AddressForm::waitForAdditionalDropdownList, "Prefecture *");
    }

    @Test(priority = 10, dataProvider = DataProviderNames.MUNICIPALITY_FIELD, dataProviderClass = DynamicFieldsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(89)
    @QaseTitle("The \"Municipality\" field visibility")
    @Description("The \"Municipality\" field visibility")
    public void municipalityField(String country) {

        Allure.parameter("Country", country);
        check(country, AddressForm::waitForAdditionalField, "Municipality");
    }

    @Test(priority = 11, dataProvider = DataProviderNames.STATE_ZONE_DROPDOWN_LIST, dataProviderClass = DynamicFieldsDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(90)
    @QaseTitle("The \"State / Zone\" dropdown list visibility")
    @Description("The \"State / Zone\" dropdown list visibility")
    public void stateZoneDropdownList(String country) {

        Allure.parameter("Country", country);
        check(country, AddressForm::waitForAdditionalDropdownList, "State / Zone *");
    }
}
