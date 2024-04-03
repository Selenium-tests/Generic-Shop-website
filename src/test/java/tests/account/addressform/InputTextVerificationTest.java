package tests.account.addressform;

import io.qameta.allure.*;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.pageobject.addressform.AddressForm;
import qa.support.actions.Authentication;
import tests.base.BaseTest;

@Epic("E2E")
@Feature("The billing address form input text verification")
public class InputTextVerificationTest extends BaseTest {

    private AddressForm addressForm;
    private final String FIRST_NAME = "John";
    private final String LAST_NAME = "Doe";
    private final String COMPANY = "company";
    private final String ADDRESS_1 = "address 1";
    private final String ADDRESS_2 = "address 2";
    private final String POSTCODE = "22333";
    private final String CITY = "New York";
    private final String PHONE = "111222333";
    private final String EMAIL = "jdoe@domain.com";

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToPage(URLs.LOGIN_PAGE.getName());
        Authentication.loginWithCredentials(getDriver());
        goToPage(URLs.BILLING_ADDRESS_FORM.getName());
        addressForm = new AddressForm(getDriver());
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(91)
    @QaseTitle("Verification of the \"First name\" field text input\"")
    @Description("Verification of the \"First name\" field text input\"")
    public void firstNameField() {

        addressForm.setFirstName(FIRST_NAME);
        Assert.assertEquals(addressForm.getFirstName(), FIRST_NAME, "Incorrect the \"First name\" field output");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(92)
    @QaseTitle("Verification of the \"Last name\" field text input\"")
    @Description("Verification of the \"Last name\" field text input\"")
    public void lastNameField() {

        addressForm.setLastName(LAST_NAME);
        Assert.assertEquals(addressForm.getLastName(), LAST_NAME, "Incorrect the \"Last name\" field output");
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(93)
    @QaseTitle("Verification of the \"Company name\" field text input\"")
    @Description("Verification of the \"Company name\" field text input\"")
    public void companyField() {

        addressForm.setCompany(COMPANY);
        Assert.assertEquals(addressForm.getCompany(), COMPANY, "Incorrect the \"Company name\" field output");
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(94)
    @QaseTitle("Verification of the \"Street address\" field text input\"")
    @Description("Verification of the \"Street address\" field text input\"")
    public void addressField() {

        addressForm.setAddress_1(ADDRESS_1);
        Assert.assertEquals(addressForm.getAddress(), ADDRESS_1, "Incorrect the \"Street address\" field output");
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(95)
    @QaseTitle("Verification of the \"Street address\" optional field text input\"")
    @Description("Verification of the \"Street address\" optional field text input\"")
    public void addressField_2() {

        addressForm.setAddress_2(ADDRESS_2);
        Assert.assertEquals(addressForm.getAddressLine2(), ADDRESS_2, "Incorrect the \"Street address\" optional field output");
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(96)
    @QaseTitle("Verification of the \"Postcode / ZIP\" field text input\"")
    @Description("Verification of the \"Postcode / ZIP\" field text input\"")
    public void postcodeField() {

        addressForm.setPostcode(POSTCODE);
        Assert.assertEquals(addressForm.getPostcode(), POSTCODE, "Incorrect the \"Postcode / ZIP\" field output");
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(97)
    @QaseTitle("Verification of the \"Town / City\" field text input\"")
    @Description("Verification of the \"Town / City\" field text input\"")
    public void cityField() {

        addressForm.setCity(CITY);
        Assert.assertEquals(addressForm.getCity(), CITY, "Incorrect the \"Town / City\" field output");
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(98)
    @QaseTitle("Verification of the \"Phone\" field text input\"")
    @Description("Verification of the \"Phone\" field text input\"")
    public void phoneField() {

        addressForm.setPhone(PHONE);
        Assert.assertEquals(addressForm.getPhone(), PHONE, "Incorrect the \"Phone\" field output");
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(99)
    @QaseTitle("Verification of the \"Email address\" field text input\"")
    @Description("Verification of the \"Email address\" field text input\"")
    public void emailField() {

        addressForm.setEmail(EMAIL);
        Assert.assertEquals(addressForm.getEmail(), EMAIL, "Incorrect the \"Email address\" field output");
    }
}
