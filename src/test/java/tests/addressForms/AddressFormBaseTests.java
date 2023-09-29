package tests.addressForms;

import base.BaseTest;
import constans.AddressFormFields;
import enums.AddressFormType;
import pages.AccountPage;
import pages.components.addressform.AddressForm;
import pages.components.header.Header;
import java.awt.*;
import java.util.function.Consumer;

public abstract class AddressFormBaseTests extends BaseTest {

    private AccountPage accountPage;
    protected AddressForm addressForm;
    private String expectedURL;
    private boolean isURL;


    protected void setAddressForm(AddressForm addressForm) {

        this.addressForm = addressForm;
    }

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

    protected void fill(String[] data, Consumer<AddressForm> consumer) {

        addressForm.getCountryDropdownList().clickCountryButton();
        addressForm.getCountryDropdownList().setCountry(data[AddressFormFields.COUNTRY]);

        addressForm.setFirstName(data[AddressFormFields.FIRST_NAME]);
        addressForm.setLastName(data[AddressFormFields.LAST_NAME]);
        addressForm.setCompany(data[AddressFormFields.COMPANY]);
        addressForm.setAddress_1(data[AddressFormFields.STREET_1]);
        addressForm.setAddress_2(data[AddressFormFields.STREET_2]);
        addressForm.setCity(data[AddressFormFields.CITY]);
        addressForm.setPostcode(data[AddressFormFields.POSTCODE]);

        if (addressForm.getAddressFormType() == AddressFormType.BILLING) {

            addressForm.setPhone(data[AddressFormFields.PHONE]);
            addressForm.setEmail(data[AddressFormFields.EMAIL]);
        }

        consumer.accept(addressForm);
        addressForm.clickSaveAddressButton();
        isURL = expectedURL.equals(getDriver().getCurrentUrl());
    }

    protected void check(Consumer<Boolean> consumer, Boolean b) {

        consumer.accept(b);
    }

    public boolean isUrlValid() {

        return isURL;
    }

    protected void openForm(Consumer<AccountPage> consumer) {

        accountPage.clickAddressesLink();
        consumer.accept(accountPage);
    }
}
