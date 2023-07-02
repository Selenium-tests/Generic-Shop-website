package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountPage;
import provider.MyDataProvider;
import utils.ExtentReportsManager;

import java.awt.*;
import java.util.List;

public class BillingAddressFormTest extends AddressFormTests {

    @BeforeClass
    private void init() throws AWTException {

        accountPage = new AccountPage(getDriver());
    }

    @Override
    public void openForm() {

        accountPage.clickBillingAddressEditLink();
    }

    @Test(priority = 4, dataProvider = "addressIncorrectPhoneNumber", dataProviderClass = MyDataProvider.class)
    public void incorrectPhoneNumber(List<String[]> data) throws AWTException, InterruptedException {

        ExtentReportsManager.setName("Incorrect phone number");
        checkErrorMessageDisplaying(data);
    }

    @Test(priority = 3, dataProvider = "addressIncorrectEmail", dataProviderClass = MyDataProvider.class)
    public void incorrectEmail(List<String[]> data) {

    }
}
