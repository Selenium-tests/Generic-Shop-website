package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.components.Header;
import provider.MyDataProvider;
import utils.SoftAssertAux;
import utils.SoftAssertAuxFalse;
import utils.SoftAssertAuxTrue;

import java.awt.*;
import java.util.List;

public abstract class AbstractAddressFormTests extends BaseTest {

    protected abstract void openForm(AccountPage accountPage);

    private void setFields(AccountPage accountPage, String[] data) {

        accountPage.getAddressForm().getCountryDropdownList().clickCountryButton();
        accountPage.getAddressForm().getCountryDropdownList().setCountry(data[data.length - 1]);
        accountPage.getAddressForm().getCountryDropdownList().clickCountryButton();

        for (int i = 0; i < accountPage.getAddressForm().inputsListSize(); i++) {

            accountPage.getAddressForm().setData(i, data[i]);
        }

        accountPage.getAddressForm().clickButton();
    }

    private void checkFields(String[] expected, AccountPage accountPage) {

        getSoftAssert().assertEquals(expected[expected.length - 1], accountPage.getAddressForm().getCountryDropdownList().getCountry());

        for (int i = 0; i < accountPage.getAddressForm().inputsListSize() - 1; i++) {

            getSoftAssert().assertEquals(expected[i], accountPage.getAddressForm().getData(i));
        }

        getSoftAssert().assertAll();
    }

    @Test(dataProvider = "getCorrectLoginData", dataProviderClass = MyDataProvider.class)
    public void correctLogin(List<String[]> data) {

        Header header = new Header(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        header.clickAccountButton();

        loginPage.setUsername(data.get(0)[0]);
        loginPage.setPassword(data.get(0)[1]);
        loginPage.clickLoginButton();
    }

    public void checkCountryDropdownList(List<String[]> data, SoftAssertAux softAssertAux) throws AWTException, InterruptedException {

        AccountPage accountPage = new AccountPage(getDriver());
        accountPage.clickAddresses();
        openForm(accountPage);

        for (String[] datum : data) {

            for (String s : datum) {

                accountPage.getAddressForm().getCountryDropdownList().clickCountryButton();
                accountPage.getAddressForm().getCountryDropdownList().setCountry(s);
                softAssertAux.countryDropdownList(accountPage, s, getSoftAssert());
                accountPage.getAddressForm().getCountryDropdownList().clickCountryButton();
            }
        }

        getSoftAssert().assertAll();
    }

    @Test(dependsOnMethods = {"correctLogin"},priority = 6, dataProvider = "getCorrectCountryNames", dataProviderClass = MyDataProvider.class)
    public void correctCountryName(List<String[]> data) throws AWTException, InterruptedException {

        checkCountryDropdownList(data, new SoftAssertAuxFalse());
    }

    @Test(dependsOnMethods = {"correctLogin"},priority = 6, dataProvider = "getIncorrectCountryNames", dataProviderClass = MyDataProvider.class)
    public void incorrectCountryName(List<String[]> data) throws AWTException, InterruptedException {

        checkCountryDropdownList(data, new SoftAssertAuxTrue());
    }

    @Test(priority = 1, dataProvider = "getCorrectBillingAddress", dataProviderClass = MyDataProvider.class)
    public void correctAddressData(List<String[]> data) throws AWTException {

        AccountPage accountPage = new AccountPage(getDriver());

        for (String[] datum : data) {

            accountPage.clickAddresses();
            openForm(accountPage);
            setFields(accountPage, datum);
            openForm(accountPage);
            checkFields(datum, accountPage);
        }
    }

    protected void checkErrorMessageDisplaying(List<String[]> data, String assertMessage) throws AWTException {

        AccountPage accountPage = new AccountPage(getDriver());

        for (String[] datum : data) {

            accountPage.clickAddresses();
            openForm(accountPage);
            setFields(accountPage, datum);
            getSoftAssert().assertTrue(accountPage.getAddressForm().isErrorMessageDisplayed(), assertMessage);
        }

        getSoftAssert().assertAll();
    }

    @Test(priority = 4, dataProvider = "getIncorrectFirstName", dataProviderClass = MyDataProvider.class)
    public void incorrectFirstName(List<String[]> data) throws AWTException {

        checkErrorMessageDisplaying(data, "No incorrect first name message");
    }

    @Test(priority = 5, dataProvider = "getIncorrectLastName", dataProviderClass = MyDataProvider.class)
    public void incorrectLastName(List<String[]> data) throws AWTException {

        checkErrorMessageDisplaying(data, "No incorrect last name message");
    }

    @Test(priority = 2, dataProvider = "getIncorrectPostcode", dataProviderClass = MyDataProvider.class)
    public void incorrectPostcode(List<String[]> data) throws AWTException {

        checkErrorMessageDisplaying(data, "No incorrect postcode message");
    }
}
