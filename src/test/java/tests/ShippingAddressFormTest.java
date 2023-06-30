package tests;

import org.testng.annotations.BeforeClass;
import pages.AccountPage;

import java.awt.*;

public class ShippingAddressFormTest extends AddressFormTests {

    @BeforeClass
    private void init() throws AWTException {

        accountPage = new AccountPage(getDriver());
    }

    @Override
    public void openForm() {

        accountPage.clickShippingAddressEditLink();
    }
}
