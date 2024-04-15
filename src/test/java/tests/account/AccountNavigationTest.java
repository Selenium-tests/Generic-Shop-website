package tests.account;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import qa.pageobject.account.AccountNavigation;
import tests.base.BaseTest;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.support.constans.URLs;
import qa.support.actions.Authentication;

import java.util.function.Consumer;

@Epic("E2E")
@Feature("The account navigation")
public class AccountNavigationTest extends BaseTest {

    private AccountNavigation accountNavigation;

    @BeforeMethod
    private void init() throws JSONException, IllegalAccessException {

        goToPage(URLs.LOGIN_PAGE);
        accountNavigation = new AccountNavigation(getDriver());
        Authentication.loginWithCredentials(getDriver());
    }

    private void actions(Consumer<AccountNavigation> consumer, String expectedUrl) {

        consumer.accept(accountNavigation);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl, "The page " + expectedUrl + " has not been opened");
    }

    @Test(priority = 5)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Links")
    @Link(name = "Account page", value = URLs.LOGIN_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(68)
    @QaseTitle("The \"Orders\" link")
    @Description("The \"Orders\" link")
    public void ordersLink() {

        actions(AccountNavigation::clickOrdersLink, URLs.ORDERS_PAGE);
    }

    @Test(priority = 4)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Links")
    @Link(name = "Account page", value = URLs.LOGIN_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(69)
    @QaseTitle("The \"Dashboard\" link")
    @Description("The \"Dashboard\" link")
    public void dashboardLink() {

        goToPage(URLs.ORDERS_PAGE);
        actions(AccountNavigation::clickDashboardLink, URLs.DASHBOARD_PAGE);
    }

    @Test(priority = 6)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Links")
    @Link(name = "Account page", value = URLs.LOGIN_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @QaseId(70)
    @QaseTitle("The \"Downloads\" link")
    @Description("The \"Downloads\" link")
    public void downloadsLink() {

        actions(AccountNavigation::clickDownloadsLink, URLs.DOWNLOADS_PAGE);
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Links")
    @Link(name = "Account page", value = URLs.LOGIN_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(71)
    @QaseTitle("The \"Addresses\" link")
    @Description("The \"Addresses\" link")
    public void addressesLink() {

        actions(AccountNavigation::clickAddressesLink, URLs.ADDRESSES_PAGE);
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Links")
    @Link(name = "Account page", value = URLs.LOGIN_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(72)
    @QaseTitle("The \"Account details\" link")
    @Description("The \"Account details\" link")
    public void accountDetailsLink() {

        actions(AccountNavigation::clickAccountDetailsLink, URLs.ACCOUNT_DETAILS_PAGE);
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Account")
    @Tag("Links")
    @Link(name = "Account page", value = URLs.LOGIN_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(73)
    @QaseTitle("The \"Logout\" link")
    @Description("The \"Logout\" link")
    public void logoutLink() {

        actions(AccountNavigation::clickLogoutLink, URLs.LOGOUT_PAGE);
    }
}