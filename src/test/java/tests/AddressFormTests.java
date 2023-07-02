package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.components.header.Header;
import provider.MyDataProvider;
import utils.*;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public abstract class AddressFormTests extends BaseTest {

    protected AccountPage accountPage;
    protected abstract void openForm();

    @BeforeClass
    private void init() throws AWTException {

        accountPage = new AccountPage(getDriver());
    }

    private void setFields(String[] data) throws InterruptedException {

        accountPage.getAddressForm().clearAll();

        accountPage.getAddressForm().getCountryDropdownList().clickCountryButton();
        accountPage.getAddressForm().getCountryDropdownList().setCountry(data[data.length - 1]);
        accountPage.getAddressForm().getCountryDropdownList().clickCountryButton();

        for (int i = 0; i < accountPage.getAddressForm().inputsListSize(); i++) {

            Thread.sleep(1000);
            accountPage.getAddressForm().setData(i, data[i]);
        }

        accountPage.getAddressForm().clickButton();
    }

    private void checkFields(String[] expected) {

        Assert.assertEquals(expected[expected.length - 1], accountPage.getAddressForm().getCountryDropdownList().getCountry());

        for (int i = 0; i < accountPage.getAddressForm().inputsListSize() - 1; i++) {

            Assert.assertEquals(expected[i], accountPage.getAddressForm().getData(i));
        }
    }

    @Test(dataProvider = "correctLoginData", dataProviderClass = MyDataProvider.class)
    public void correctLogin(List<Pair<String, String>> data) {

        ExtentReportsManager.setName("Correct login");

        Header header = new Header(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        header.clickAccountButton();

        loginPage.setUsername(data.get(0).first());
        loginPage.setPassword(data.get(0).second());
        loginPage.clickLoginButton();
    }

    public void checkCountryDropdownList(String[] data, FuncInterface funcInterface1) throws IOException {

        accountPage.clickAddresses();
        openForm();

        for (String str : data) {

            accountPage.getAddressForm().getCountryDropdownList().clickCountryButton();
            accountPage.getAddressForm().getCountryDropdownList().setCountry(str);
            funcInterface1.run();
            accountPage.getAddressForm().getCountryDropdownList().clickCountryButton();
        }
    }

    @Test(dependsOnMethods = {"correctLogin"},priority = 6, dataProvider = "correctCountryName", dataProviderClass = MyDataProvider.class)
    public void correctCountryName(String[] data) throws IOException {

        ExtentReportsManager.setName("Correct country name");
        checkCountryDropdownList(data, ()->{ Assert.assertFalse(accountPage.getAddressForm().getCountryDropdownList().isAlertDisplayed()); });
    }

    @Test(dependsOnMethods = {"correctLogin"},priority = 6, dataProvider = "incorrectCountryName", dataProviderClass = MyDataProvider.class)
    public void incorrectCountryName(String[] data) throws IOException {

        ExtentReportsManager.setName("Incorrect country name");
        checkCountryDropdownList(data, ()->{ Assert.assertTrue(accountPage.getAddressForm().getCountryDropdownList().isAlertDisplayed()); });
    }

    @Test(priority = 1, dataProvider = "correctAddress", dataProviderClass = MyDataProvider.class)
    public void correctAddress(List<String[]> data) throws AWTException, InterruptedException {

        ExtentReportsManager.setName("Correct address");
        AccountPage accountPage = new AccountPage(getDriver());

        for (String[] datum : data) {

            accountPage.clickAddresses();
            openForm();
            setFields(datum);
            openForm();
            checkFields(datum);
        }
    }

    protected void checkErrorMessageDisplaying(List<String[]> data) throws AWTException, InterruptedException {

        AccountPage accountPage = new AccountPage(getDriver());

        for (String[] datum : data) {

            accountPage.clickAddresses();
            openForm();
            setFields(datum);
            Assert.assertTrue(accountPage.getAddressForm().isErrorMessageDisplayed());
        }
    }

    @Test(priority = 5, dataProvider = "addressIncorrectFirstName", dataProviderClass = MyDataProvider.class)
    public void incorrectFirstName(List<String[]> data) throws AWTException, InterruptedException {

        ExtentReportsManager.setName("Incorrect first name");
        checkErrorMessageDisplaying(data);
    }

    @Test(priority = 6, dataProvider = "addressIncorrectLastName", dataProviderClass = MyDataProvider.class)
    public void incorrectLastName(List<String[]> data) throws AWTException, InterruptedException {

        ExtentReportsManager.setName("Incorrect last name");
        checkErrorMessageDisplaying(data);
    }

    @Test(priority = 2, dataProvider = "addressIncorrectPostcode", dataProviderClass = MyDataProvider.class)
    public void incorrectPostcode(List<String[]> data) throws AWTException, InterruptedException {

        ExtentReportsManager.setName("Incorrect postcode");
        checkErrorMessageDisplaying(data);
    }
}
