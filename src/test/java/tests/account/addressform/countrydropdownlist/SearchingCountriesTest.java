package tests.account.addressform.countrydropdownlist;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.asserts.SoftAssert;
import tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.CountriesDataProviders;
import qa.support.constans.URLs;
import qa.support.actions.Authentication;
import qa.pageobject.addressform.CountryDropdownList;
import qa.support.constans.DataProviderNames;

import java.util.List;

@Epic("E2E")
@Feature("Searching countries")
public class SearchingCountriesTest extends BaseTest {

    private CountryDropdownList countryDropdownList;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToPage(URLs.LOGIN_PAGE);
        Authentication.loginWithCredentials(getDriver());
        goToPage(URLs.BILLING_ADDRESS_FORM);

        countryDropdownList = new CountryDropdownList(getDriver());
    }

    private void fill(String countryName) throws IllegalAccessException {

        countryDropdownList.clickTriggerElement();
        countryDropdownList.typeCountry(countryName);
    }

    private void checkResultsListSize() {

        Assert.assertFalse(countryDropdownList.getResults().isEmpty(), "No country found");
    }

    private void checkResults(String partial) {

        SoftAssert softAssert = new SoftAssert();
        List<String> countries = countryDropdownList.getResults();

        for (String country : countries) {
            softAssert.assertTrue(country.toLowerCase().contains(partial.toLowerCase()),
                    "The \"" + country + "\" does not contain the \"" + partial + "\"");
        }

        softAssert.assertAll();
    }

    @Test(priority = 1, dataProvider = DataProviderNames.CORRECT, dataProviderClass = CountriesDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(77)
    @QaseTitle("Searching with a correct country name")
    @Description("Searching with a correct country name")
    public void correct(String countryName) throws IllegalAccessException {

        Allure.parameter("Country", countryName);

        fill(countryName);
        checkResultsListSize();
        checkResults(countryName);
    }

    @Test(priority = 2, dataProvider = DataProviderNames.PARTIAL, dataProviderClass = CountriesDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.NORMAL)
    @QaseId(78)
    @QaseTitle("Searching with a partial country name")
    @Description("Searching with a partial country name")
    public void partial(String countryName) throws IllegalAccessException {

        Allure.parameter("country", countryName);

        fill(countryName);
        checkResultsListSize();
        checkResults(countryName);
    }

    @Test(priority = 3, dataProvider = DataProviderNames.INCORRECT, dataProviderClass = CountriesDataProviders.class)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.MINOR)
    @QaseId(79)
    @QaseTitle("Searching with an incorrect country name")
    @Description("Searching with an incorrect country name")
    public void incorrect(String countryName) throws IllegalAccessException {

        Allure.parameter("Country", countryName);

        fill(countryName);
        checkResultsListSize();
        checkResults("No matches found");
    }
}
