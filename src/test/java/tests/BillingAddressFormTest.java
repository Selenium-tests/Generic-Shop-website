package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountPage;
import provider.MyDataProvider;
import utils.ExtentReportsManager;
import utils.JSONReader;
import utils.Pair;

import java.awt.*;
import java.util.List;

public class BillingAddressFormTest extends AddressFormTests {

    @BeforeClass
    private void init() throws AWTException {

        accountPage = new AccountPage(getDriver());

        List<Pair<String, String>> data = JSONReader.get("login", "correct", new Pair<>("email", "password"));
        login(data);
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
}
