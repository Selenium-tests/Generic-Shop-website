package tests;

import pages.AccountPage;

public class ShippingAddressFormTest extends AbstractAddressFormTests {

    @Override
    public void openForm(AccountPage accountPage) {

        accountPage.clickShippingAddressEditLink();
    }
}
