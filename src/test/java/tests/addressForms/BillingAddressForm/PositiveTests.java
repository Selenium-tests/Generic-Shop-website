package tests.addressForms.BillingAddressForm;

import constans.AddressFormFields;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.components.addressform.BillingAddressForm;
import provider.MyDataProvider;
import tests.addressForms.PositiveBase;
import java.awt.*;


public class PositiveTests extends PositiveBase<BillingAddressForm> {

    @BeforeClass
    public void init() throws AWTException {

        begin();

        accountPage.clickBillingAddressEditLink();
        setAddressForm(new BillingAddressForm(getDriver()));
        setExpectedURL("https://skleptest.pl/my-account/edit-address/");
    }

    @Test(dataProvider = "AF_correctAddress", dataProviderClass = MyDataProvider.class)
    public void correctAddress(String[] data) {

        fill(data, (BillingAddressForm b)->{
            b.setPhone(data[AddressFormFields.PHONE]);
            b.setEmail(data[AddressFormFields.EMAIL]);
        });
        goToAccountPageIfTestFailed();
        check(Assert::assertTrue, getIsURL());
    }

    @Test(dataProvider = "AF_additionalField", dataProviderClass = MyDataProvider.class)
    public void additionalField(String[] data) {

        fill(data, (BillingAddressForm b)->{
            b.setPhone(data[AddressFormFields.PHONE]);
            b.setEmail(data[AddressFormFields.EMAIL]);
            b.setState(data[AddressFormFields.STATE]);
        });
        goToAccountPageIfTestFailed();
        check(Assert::assertTrue, getIsURL());
    }
}
