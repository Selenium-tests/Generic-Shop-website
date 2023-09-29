package tests.addressForms.BillingAddressForm;

import constans.AddressFormFields;
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


public class PositiveTests extends AddressFormBaseTests {


    @BeforeClass
    public void init() throws AWTException {

        begin();

        setAddressForm(new AddressForm(getDriver(), AddressFormType.BILLING));
        setExpectedURL("https://skleptest.pl/my-account/edit-address/");
    }

    @BeforeMethod
    public void openPage() {

        openForm(AccountPage::clickBillingAddressEditLink);
    }

    @Test(priority = 1, dataProvider = "AF_correctAddress", dataProviderClass = MyDataProvider.class)
    public void correctAddress(String[] data) {

        ExtentReportsManager.setName("Correct data");

        fill(data, (AddressForm af)->{});
        check(Assert::assertTrue, isUrlValid());
    }

    @Test(priority = 2, dataProvider = "AF_additionalField", dataProviderClass = MyDataProvider.class)
    public void additionalField(String[] data) {

        ExtentReportsManager.setName("Correct data with 'State / County' field");

        fill(data, (AddressForm af)->{ af.setState(data[AddressFormFields.STATE]); });
        check(Assert::assertTrue, isUrlValid());
    }
}
