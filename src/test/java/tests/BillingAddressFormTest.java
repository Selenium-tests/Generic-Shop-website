package tests;

import org.testng.annotations.Test;
import pages.AccountPage;
import provider.MyDataProvider;

import java.awt.*;
import java.util.List;

public class BillingAddressFormTest extends AbstractAddressFormTests {

    @Override
    public void openForm(AccountPage accountPage) {

        accountPage.clickBillingAddressEditLink();
    }

    /*@Test(priority = 3, dataProvider = "getIncorrectPhoneNumber", dataProviderClass = MyDataProvider.class)
    public void incorrectPhoneNumber(List<String[]> data) throws AWTException {

        incorrectAddressDataAux(data, "No incorrect phone number message");
    }*/
}
