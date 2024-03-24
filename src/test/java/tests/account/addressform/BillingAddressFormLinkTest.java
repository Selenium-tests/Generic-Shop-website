package tests.account.addressform;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.support.actions.Authentication;
import qa.pageobject.account.EditAddressNavigation;
import tests.base.BaseTest;

public class BillingAddressFormLinkTest extends BaseTest {

    private EditAddressNavigation editAddressNavigation;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToPage(URLs.LOGIN_PAGE.getName());
        Authentication.loginWithCredentials(getDriver());
        goToPage(URLs.ADDRESSES_PAGE.getName());
        editAddressNavigation = new EditAddressNavigation(getDriver());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(74)
    @QaseTitle("Opening the billing address form page")
    @Description("Opening the billing address form page")
    public void editLink() {

        editAddressNavigation.clickBillingAddressLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.BILLING_ADDRESS_FORM.getName());
    }
}
