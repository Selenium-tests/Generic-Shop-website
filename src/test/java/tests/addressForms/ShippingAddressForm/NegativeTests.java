package tests.addressForms.ShippingAddressForm;

import enums.AddressFormType;
import org.testng.annotations.*;
import pages.AccountPage;
import provider.MyDataProvider;
import pages.components.addressform.AddressForm;
import org.testng.Assert;
import tests.addressForms.AddressFormBaseTests;
import utils.ExtentReportsManager;

import java.awt.*;

public class NegativeTests extends AddressFormBaseTests {

    @BeforeClass
    protected void init() throws AWTException {

        begin();

        setAddressForm(new AddressForm(getDriver(), AddressFormType.SHIPPING));
        setExpectedURL("https://skleptest.pl/my-account/edit-address/shipping/");
    }

    @BeforeMethod
    private void openPage() {

        openForm(AccountPage::clickShippingAddressEditLink);
    }

    @Test(priority = 1, dataProvider = "AF_incorrectFirstName", dataProviderClass = MyDataProvider.class)
    public void incorrectFirstName(String[] data) {

        ExtentReportsManager.setName("Incorrect first name");

        fill(data, (AddressForm af)->{});
        check(Assert::assertTrue, isUrlValid());
    }

    @Test(priority = 2, dataProvider = "AF_incorrectLastName", dataProviderClass = MyDataProvider.class)
    public void incorrectLastName(String[] data) {

        ExtentReportsManager.setName("Incorrect last name");

        fill(data, (AddressForm af)->{});
        check(Assert::assertTrue, isUrlValid());
    }

    @Test(priority = 3, dataProvider = "AF_incorrectPostcode", dataProviderClass = MyDataProvider.class)
    public void incorrectPostcode(String[] data) {

        ExtentReportsManager.setName("Incorrect postcode");

        fill(data, (AddressForm af)->{});
        check(Assert::assertTrue, isUrlValid());
    }
}
