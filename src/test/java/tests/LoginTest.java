package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.components.header.Header;
import provider.MyDataProvider;
import utils.ExtentReportsManager;
import utils.Pair;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public class LoginTest extends BaseTest {

    @BeforeClass
    private void init() {

        Header header = new Header(getDriver());
        header.clickAccountButton();
    }

    private <T> void check(Consumer<T> consumer, T object) {

        consumer.accept(object);
    }

    private void fill(List<Pair<String, String>> data/*, FuncInterface funcInterface*/) throws IOException {

        for (Pair<String, String> datum : data) {

            getLoginPage().clearAll();
            getLoginPage().setUsername(datum.first());
            getLoginPage().setPassword(datum.second());
            getLoginPage().clickLoginButton();
        }
    }
    @Test(priority = 1, dataProvider = "incorrectUsername", dataProviderClass = MyDataProvider.class)
    public void incorrectUsername(List<Pair<String, String>> data) throws IOException {

        //ExtentReportsManager.setName("Incorrect email address");

        fill(data);
        check((LoginPage lp)-> { Assert.assertTrue(lp.isErrorMessageDisplayed()); }, getLoginPage());
    }

    @Test(priority = 3, dataProvider = "noUsername", dataProviderClass = MyDataProvider.class)
    public void noUsername(List<Pair<String, String>> data) throws IOException {

       // ExtentReportsManager.setName("Blank username field");

        fill(data);
        check((LoginPage lp)-> { Assert.assertTrue(lp.isErrorMessageDisplayed()); }, getLoginPage());
    }

    @Test(priority = 2, dataProvider = "incorrectPassword", dataProviderClass = MyDataProvider.class)
    public void incorrectPassword(List<Pair<String, String>> data) throws IOException {

        //ExtentReportsManager.setName("Incorrect password");

        fill(data);
        check((LoginPage lp)-> { Assert.assertTrue(lp.isErrorMessageDisplayed()); }, getLoginPage());
    }

    @Test(priority = 4, dataProvider = "noPassword", dataProviderClass = MyDataProvider.class)
    public void noPassword(List<Pair<String, String>> data) throws IOException {

        //ExtentReportsManager.setName("Blank password field");

        fill(data);
        check((LoginPage lp)-> { Assert.assertTrue(lp.isErrorMessageDisplayed()); }, getLoginPage());
    }

    @Test(priority = 5, dataProvider = "correctLoginData", dataProviderClass = MyDataProvider.class)
    public void correctData(List<Pair<String, String>> data) throws AWTException, IOException {

        //ExtentReportsManager.setName("Correct data");
        AccountPage accountPage = new AccountPage(getDriver());

        fill(data);
        check((AccountPage ap)-> { Assert.assertTrue(ap.isDashboardLinkDisplayed()); }, accountPage);
    }
}
