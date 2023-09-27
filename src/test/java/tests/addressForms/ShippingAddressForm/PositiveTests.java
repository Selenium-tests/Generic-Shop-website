package tests.addressForms.ShippingAddressForm;

import constans.AddressFormFields;
import enums.AddressFormType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.components.addressform.AddressFormBase;
import provider.MyDataProvider;
import tests.addressForms.PositiveBase;
import java.awt.*;

public class PositiveTests extends PositiveBase<AddressFormBase> {

    @BeforeClass
    protected void init() throws AWTException {

        begin();

        accountPage.clickShippingAddressEditLink();
        setAddressForm(new AddressFormBase(getDriver(), AddressFormType.SHIPPING));
        setExpectedURL("https://skleptest.pl/my-account/edit-address/");
    }

    @Test(priority = 1, dataProvider = "AF_correctAddress", dataProviderClass = MyDataProvider.class)
    public void correctAddress(String[] data) throws InterruptedException {

        fill(data, (AddressFormBase)->{});
        goToAccountPageIfTestFailed();
        check(Assert::assertTrue, getIsURL());
    }

    @Test(priority = 2, dataProvider = "AF_additionalField", dataProviderClass = MyDataProvider.class)
    public void additionalField(String[] data) throws InterruptedException {

        fill(data, (AddressFormBase a)->{ a.setState(data[AddressFormFields.STATE]); });
        check(Assert::assertTrue, getIsURL());
    }
}
