package tests.addressForms.BillingAddressForm;

import enums.AddressFormType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.components.addressform.AddressForm;
import provider.MyDataProvider;
import tests.addressForms.AddressFormBaseTests;
import utils.ExtentReportsManager;

import java.awt.*;

public class NegativeTests extends AddressFormBaseTests {

    @BeforeClass
    protected void init() throws AWTException {

        begin();

        setAddressForm(new AddressForm(getDriver(), AddressFormType.BILLING));
        setExpectedURL("https://skleptest.pl/my-account/edit-address/billing/");
    }

    @BeforeMethod
    private void openPage() {

        openForm(AccountPage::clickBillingAddressEditLink);
    }

    @Test(priority = 1, dataProvider = "AF_incorrectFirstName", dataProviderClass = MyDataProvider.class)
    public void
    incorrectFirstName(String[] data) {

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

    @Test(priority = 4, dataProvider = "AF_incorrectPhoneNumber", dataProviderClass = MyDataProvider.class)
    public void incorrectPhoneNumber(String[] data) {

        ExtentReportsManager.setName("Incorrect phone number");

        fill(data, (AddressForm af)->{});
        check(Assert::assertTrue, isUrlValid());
    }

    @Test(priority = 5, dataProvider = "AF_incorrectEmail", dataProviderClass = MyDataProvider.class)
    public void incorrectEmail(String[] data) {

        fill(data, (AddressForm af)->{});
        check(Assert::assertTrue, isUrlValid());
    }
}
