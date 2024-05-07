package tests.account.addressform.countrydropdownlist;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.support.constans.URLs;
import qa.pageobject.addressform.CountryDropdownList;
import qa.support.actions.Authentication;
import tests.base.BaseTest;

@Epic("E2E")
@Feature("The country dropdown list functionalities")
public class FunctionalitiesTest extends BaseTest {

    private CountryDropdownList countryDropdownList;

    @BeforeMethod
    public void prepare() throws IllegalAccessException, JsonProcessingException {

        goToPage(URLs.LOGIN_PAGE);
        Authentication.loginWithCredentials(getDriver());
        goToPage(URLs.BILLING_ADDRESS_FORM);
        countryDropdownList = new CountryDropdownList(getDriver());
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(75)
    @QaseTitle("Expanding the list")
    @Description("Expanding the list")
    public void expandingDropdownList() throws IllegalAccessException {

        countryDropdownList.clickTriggerElement();

        try {
            countryDropdownList.waitForContentsVisibility();
        } catch (Exception e) {
            Assert.fail("The dropdown list has not been expanded");
        }
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Dropdown list")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(76)
    @QaseTitle("Verification of the search field text input")
    @Description("Verification of the search field text input")
    public void searchField() throws IllegalAccessException {

        String country = "New Zealand";
        Allure.parameter("Text", country);

        countryDropdownList.clickTriggerElement();
        countryDropdownList.typeCountry(country);
        Assert.assertEquals(countryDropdownList.getSearchFieldContent(), country, "Incorrect the search field output");
    }
}
