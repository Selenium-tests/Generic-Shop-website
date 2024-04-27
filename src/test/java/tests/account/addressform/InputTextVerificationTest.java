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
import qa.pageobject.addressform.AddressForm;
import qa.support.actions.Authentication;
import tests.base.BaseTest;

@Epic("E2E")
@Feature("The billing address form input text verification")
public class InputTextVerificationTest extends BaseTest {

    private AddressForm addressForm;
    private final String firstName = "John";
    private final String lastName = "Doe";
    private final String company = "company";
    private final String address1 = "address 1";
    private final String address2 = "address 2";
    private final String postcode = "22333";
    private final String city = "New York";
    private final String phone = "111222333";
    private final String email = "jdoe@domain.com";

    @BeforeMethod
    public void prepare() throws IllegalAccessException, JsonProcessingException {

        goToPage(URLs.LOGIN_PAGE);
        Authentication.loginWithCredentials(getDriver());
        goToPage(URLs.BILLING_ADDRESS_FORM);
        addressForm = new AddressForm(getDriver());
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(91)
    @QaseTitle("Verification of the \"First name\" field text input\"")
    @Description("Verification of the \"First name\" field text input\"")
    public void firstNameField() {

        Allure.parameter("Text", firstName);

        addressForm.setFirstName(firstName);
        Assert.assertEquals(addressForm.getFirstName(), firstName, "Incorrect the \"First name\" field output");
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(92)
    @QaseTitle("Verification of the \"Last name\" field text input\"")
    @Description("Verification of the \"Last name\" field text input\"")
    public void lastNameField() {

        Allure.parameter("Text", lastName);

        addressForm.setLastName(lastName);
        Assert.assertEquals(addressForm.getLastName(), lastName, "Incorrect the \"Last name\" field output");
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(93)
    @QaseTitle("Verification of the \"Company name\" field text input\"")
    @Description("Verification of the \"Company name\" field text input\"")
    public void companyField() {

        Allure.parameter("Text", company);

        addressForm.setCompany(company);
        Assert.assertEquals(addressForm.getCompany(), company, "Incorrect the \"Company name\" field output");
    }

    @Test(priority = 4)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(94)
    @QaseTitle("Verification of the \"Street address\" field text input\"")
    @Description("Verification of the \"Street address\" field text input\"")
    public void addressField() {

        Allure.parameter("Text", address1);

        addressForm.setAddress_1(address1);
        Assert.assertEquals(addressForm.getAddress(), address1, "Incorrect the \"Street address\" field output");
    }

    @Test(priority = 5)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(95)
    @QaseTitle("Verification of the \"Street address\" optional field text input\"")
    @Description("Verification of the \"Street address\" optional field text input\"")
    public void addressField_2() {

        Allure.parameter("Text", address2);

        addressForm.setAddress_2(address2);
        Assert.assertEquals(addressForm.getAddressLine2(), address2, "Incorrect the \"Street address\" optional field output");
    }

    @Test(priority = 6)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(96)
    @QaseTitle("Verification of the \"Postcode / ZIP\" field text input\"")
    @Description("Verification of the \"Postcode / ZIP\" field text input\"")
    public void postcodeField() {

        Allure.parameter("Text", postcode);

        addressForm.setPostcode(postcode);
        Assert.assertEquals(addressForm.getPostcode(), postcode, "Incorrect the \"Postcode / ZIP\" field output");
    }

    @Test(priority = 7)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(97)
    @QaseTitle("Verification of the \"Town / City\" field text input\"")
    @Description("Verification of the \"Town / City\" field text input\"")
    public void cityField() {

        Allure.parameter("Text", city);

        addressForm.setCity(city);
        Assert.assertEquals(addressForm.getCity(), city, "Incorrect the \"Town / City\" field output");
    }

    @Test(priority = 8)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(98)
    @QaseTitle("Verification of the \"Phone\" field text input\"")
    @Description("Verification of the \"Phone\" field text input\"")
    public void phoneField() {

        Allure.parameter("Text", phone);

        addressForm.setPhone(phone);
        Assert.assertEquals(addressForm.getPhone(), phone, "Incorrect the \"Phone\" field output");
    }

    @Test(priority = 9)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Address form")
    @Tag("Fields")
    @Link(name = "Billing address form page", value = URLs.BILLING_ADDRESS_FORM)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(99)
    @QaseTitle("Verification of the \"Email address\" field text input\"")
    @Description("Verification of the \"Email address\" field text input\"")
    public void emailField() {

        Allure.parameter("Text", email);

        addressForm.setEmail(email);
        Assert.assertEquals(addressForm.getEmail(), email, "Incorrect the \"Email address\" field output");
    }
}
