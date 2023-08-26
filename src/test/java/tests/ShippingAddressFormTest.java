package tests;

import org.testng.annotations.BeforeClass;
import pages.AccountPage;
import utils.JSONReader;
import utils.Pair;

import java.awt.*;
import java.util.List;

public class ShippingAddressFormTest extends AddressFormTests {

    @BeforeClass
    private void init() throws AWTException {

        accountPage = new AccountPage(getDriver());

        List<Pair<String, String>> data = JSONReader.get("login", "correct", new Pair<>("email", "password"));
        login(data);
    }

    @Override
    public void openForm() {

        accountPage.clickShippingAddressEditLink();
    }
}
