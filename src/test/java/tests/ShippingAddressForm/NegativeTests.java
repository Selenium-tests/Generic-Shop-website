package tests.ShippingAddressForm;

import enums.AddressFormType;
import org.testng.annotations.BeforeClass;
import tests.AddressFormBaseTests;
import org.testng.annotations.Test;
import provider.MyDataProvider;
import pages.components.addressform.AddressFormBase;
import org.testng.Assert;
import java.awt.*;
import java.util.function.Consumer;

public class NegativeTests extends AddressFormBaseTests {

    private AddressFormBase addressFormBase;
    private final String expectedURL = "https://skleptest.pl/my-account/edit-address/shipping/";
    private boolean isAddressFormPageURL;

    @BeforeClass
    protected void init() throws AWTException {

        begin();

        accountPage.clickShippingAddressEditLink();
        addressFormBase = new AddressFormBase(getDriver(), AddressFormType.SHIPPING);
    }

    private void backWhenTestFailed() {

        if (!(getDriver().getCurrentUrl().equals(expectedURL))) {

            accountPage.clickShippingAddressEditLink();
        }
    }

    private void fill(String[] data, Consumer<Boolean> consumer) {

        fillBasicFields(addressFormBase, data);
        consumer.accept(isAddressFormPageURL);
        addressFormBase.clickSaveAddressButton();
        isAddressFormPageURL = addressFormBase.isErrorMessageDisplayed();
    }

    @Test(priority = 1, dataProvider = "AF_incorrectFirstName", dataProviderClass = MyDataProvider.class)
    public void incorrectFirstName(String[] data) {

        fill(data, (AddressFormBase)->{});
        backWhenTestFailed();
        check(Assert::assertTrue, isAddressFormPageURL);
    }

    @Test(priority = 2, dataProvider = "AF_incorrectLastName", dataProviderClass = MyDataProvider.class)
    public void incorrectLastName(String[] data) {

        fill(data, (AddressFormBase)->{});
        backWhenTestFailed();
        check(Assert::assertTrue, isAddressFormPageURL);
    }

    @Test(priority = 3, dataProvider = "AF_incorrectPostcode", dataProviderClass = MyDataProvider.class)
    public void incorrectPostcode(String[] data) {

        fill(data, (AddressFormBase)->{});
        backWhenTestFailed();
        check(Assert::assertTrue, isAddressFormPageURL);
    }

    @Test(priority = 4, dataProvider = "AF_incorrectPhoneNumber", dataProviderClass = MyDataProvider.class)
    public void incorrectPhoneNumber(String[] data) {

        fill(data, (AddressFormBase)->{});
        backWhenTestFailed();
        check(Assert::assertTrue, isAddressFormPageURL);
    }

    @Test(priority = 5, dataProvider = "AF_incorrectEmail", dataProviderClass = MyDataProvider.class)
    public void incorrectEmail(String[] data) {

        fill(data, (AddressFormBase)->{});
        backWhenTestFailed();
        check(Assert::assertTrue, isAddressFormPageURL);
    }
}
