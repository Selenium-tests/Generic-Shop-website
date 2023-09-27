package tests.addressForms;

import base.BaseTest;
import constans.AddressFormFields;
import pages.AccountPage;
import pages.components.addressform.AddressFormBase;
import pages.components.header.Header;
import java.awt.*;
import java.util.function.Consumer;

public abstract class AddressFormBaseTests extends BaseTest {

    protected AccountPage accountPage;
    private String expectedURL;
    private boolean isURL;

    protected void setExpectedURL(String expectedURL) {

        this.expectedURL = expectedURL;
    }

    protected void begin() throws AWTException {

        accountPage = new AccountPage(getDriver());

        Header header = new Header(getDriver());
        header.clickAccountButton();

        getLoginPage().clearAll();
        getLoginPage().setUsername("karen@gmail.com");
        getLoginPage().setPassword("Kvc$11324#");
        getLoginPage().clickLoginButton();

        accountPage.clickAddressesLink();
    }

    protected <T extends AddressFormBase> void fillBasicFields(T addressForm, String[] data) {

        addressForm.getCountryDropdownList().clickCountryButton();
        addressForm.getCountryDropdownList().setCountry(data[AddressFormFields.COUNTRY]);

        addressForm.setFirstName(data[AddressFormFields.FIRST_NAME]);
        addressForm.setLastName(data[AddressFormFields.LAST_NAME]);
        addressForm.setCompany(data[AddressFormFields.COMPANY]);
        addressForm.setAddress_1(data[AddressFormFields.STREET_1]);
        addressForm.setAddress_2(data[AddressFormFields.STREET_2]);
        addressForm.setCity(data[AddressFormFields.CITY]);
        addressForm.setPostcode(data[AddressFormFields.POSTCODE]);
    }

    protected void check(Consumer<Boolean> consumer, Boolean b) {

        consumer.accept(b);
    }

    public void setIsURL() {

        isURL = expectedURL.equals(getDriver().getCurrentUrl());
    }

    public boolean getIsURL() {

        return isURL;
    }
}
