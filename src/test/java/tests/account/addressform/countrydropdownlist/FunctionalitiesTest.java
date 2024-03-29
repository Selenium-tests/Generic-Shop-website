package tests.account.addressform.countrydropdownlist;

import io.qameta.allure.*;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.pageobject.addressform.CountryDropdownList;
import qa.support.actions.Authentication;
import tests.base.BaseTest;

@Epic("E2E")
@Feature("The country dropdown list functionalities")
public class FunctionalitiesTest extends BaseTest {

    private CountryDropdownList countryDropdownList;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToPage(URLs.LOGIN_PAGE.getName());
        Authentication.loginWithCredentials(getDriver());
        goToPage(URLs.BILLING_ADDRESS_FORM.getName());
        countryDropdownList = new CountryDropdownList(getDriver());
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(75)
    @QaseTitle("Expanding the dropdown list")
    @Description("Expanding the dropdown list")
    public void expandingDropdownList() {

        countryDropdownList.clickTriggerElement();

        try {
            countryDropdownList.waitForContentsVisibility();
        } catch (Exception e) {
            Assert.fail("The dropdown list has not been expanded");
        }
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(76)
    @QaseTitle("Verification of the search field text input")
    @Description("Verification of the search field text input")
    public void searchField() throws IllegalAccessException {

        String country = "New Zealand";
        countryDropdownList.clickTriggerElement();
        countryDropdownList.typeCountry(country);
        Assert.assertEquals(countryDropdownList.getSearchFieldContent(), country, "Incorrect the search field output");
    }
}
