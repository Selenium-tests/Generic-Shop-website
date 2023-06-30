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
import java.util.List;

public abstract class AddressFormTests extends BaseTest {

    protected AccountPage accountPage;
    protected abstract void openForm();

    @BeforeClass
    private void init() throws AWTException {

        accountPage = new AccountPage(getDriver());
    }

    private void setFields(String[] data) {

        accountPage.getAddressForm().clearAll();

        accountPage.getAddressForm().getCountryDropdownList().clickCountryButton();
        accountPage.getAddressForm().getCountryDropdownList().setCountry(data[data.length - 1]);
        accountPage.getAddressForm().getCountryDropdownList().clickCountryButton();

        for (int i = 0; i < accountPage.getAddressForm().inputsListSize(); i++) {

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

    @Test(dataProvider = "getCorrectLoginData", dataProviderClass = MyDataProvider.class)
    public void correctLogin(List<String[]> data) {

        ExtentReportsManager.setName("Correct login");

        Header header = new Header(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        header.clickAccountButton();

        loginPage.setUsername(data.get(0)[0]);
        loginPage.setPassword(data.get(0)[1]);
        loginPage.clickLoginButton();
    }

    public void checkCountryDropdownList(List<String[]> data, FuncInterface funcInterface1) {

        accountPage.clickAddresses();
        openForm();

        for (String[] datum : data) {

            for (String str : datum) {

                accountPage.getAddressForm().getCountryDropdownList().clickCountryButton();
                accountPage.getAddressForm().getCountryDropdownList().setCountry(str);
                funcInterface1.run();
                accountPage.getAddressForm().getCountryDropdownList().clickCountryButton();
            }
        }
    }

    @Test(dependsOnMethods = {"correctLogin"},priority = 6, dataProvider = "getCorrectCountryNames", dataProviderClass = MyDataProvider.class)
    public void correctCountryName(List<String[]> data) {

        ExtentReportsManager.setName("Correct country name");
        checkCountryDropdownList(data, ()->{ Assert.assertFalse(accountPage.getAddressForm().getCountryDropdownList().isAlertDisplayed()); });
    }

    @Test(dependsOnMethods = {"correctLogin"},priority = 6, dataProvider = "getIncorrectCountryNames", dataProviderClass = MyDataProvider.class)
    public void incorrectCountryName(List<String[]> data) {

        ExtentReportsManager.setName("Incorrect country name");
        checkCountryDropdownList(data, ()->{ Assert.assertTrue(accountPage.getAddressForm().getCountryDropdownList().isAlertDisplayed()); });
    }

    @Test(priority = 1, dataProvider = "getCorrectBillingAddress", dataProviderClass = MyDataProvider.class)
    public void correctAddressData(List<String[]> data) throws AWTException {

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

    protected void checkErrorMessageDisplaying(List<String[]> data, String assertMessage) throws AWTException {

        AccountPage accountPage = new AccountPage(getDriver());

        for (String[] datum : data) {

            accountPage.clickAddresses();
            openForm();
            setFields(datum);
            Assert.assertTrue(accountPage.getAddressForm().isErrorMessageDisplayed(), assertMessage);
        }
    }

    @Test(priority = 4, dataProvider = "getIncorrectFirstName", dataProviderClass = MyDataProvider.class)
    public void incorrectFirstName(List<String[]> data) throws AWTException {

        ExtentReportsManager.setName("Incorrect first name");
        checkErrorMessageDisplaying(data, "No incorrect first name message");
    }

    @Test(priority = 5, dataProvider = "getIncorrectLastName", dataProviderClass = MyDataProvider.class)
    public void incorrectLastName(List<String[]> data) throws AWTException {

        ExtentReportsManager.setName("Incorrect last name");
        checkErrorMessageDisplaying(data, "No incorrect last name message");
    }

    @Test(priority = 2, dataProvider = "getIncorrectPostcode", dataProviderClass = MyDataProvider.class)
    public void incorrectPostcode(List<String[]> data) throws AWTException {

        ExtentReportsManager.setName("Incorrect postcode");
        checkErrorMessageDisplaying(data, "No incorrect postcode message");
    }
}
