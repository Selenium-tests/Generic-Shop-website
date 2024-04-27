package tests.account.addressform;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.support.constans.URLs;
import qa.support.actions.Authentication;
import qa.pageobject.account.EditAddressNavigation;
import tests.base.BaseTest;

public class BillingAddressFormLinkTest extends BaseTest {

    private EditAddressNavigation editAddressNavigation;

    @BeforeMethod
    public void prepare() throws IllegalAccessException, JsonProcessingException {

        goToPage(URLs.LOGIN_PAGE);
        Authentication.loginWithCredentials(getDriver());
        goToPage(URLs.ADDRESSES_PAGE);
        editAddressNavigation = new EditAddressNavigation(getDriver());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Links")
    @Link(name = "Addresses page", value = URLs.ADDRESSES_PAGE)
    @QaseId(74)
    @QaseTitle("Opening the billing address form page")
    @Description("Opening the billing address form page")
    public void editLink() {

        editAddressNavigation.clickBillingAddressLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.BILLING_ADDRESS_FORM);
    }
}
