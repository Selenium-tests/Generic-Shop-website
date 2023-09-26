package tests;

import base.BaseTest;
import pages.AccountPage;
import pages.components.addressform.AddressFormBase;
import pages.components.header.Header;
import java.awt.*;

public abstract class AddressFormBaseTests extends BaseTest {

    protected AccountPage accountPage;

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

        addressForm.setFirstName(data[0]);
        addressForm.setLastName(data[1]);
        addressForm.setCompany(data[2]);
        addressForm.setAddress_1(data[3]);
        addressForm.setAddress_2(data[4]);
        addressForm.setCity(data[5]);
        addressForm.setPostcode(data[6]);
    }
}
