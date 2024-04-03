package tests.checkout;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import qa.enums.URLs;
import qa.support.actions.ShoppingCartActions;
import qa.pageobject.checkoutpage.CheckoutPage;

public class SectionsVisibilityTest extends BaseTest {

    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToPage(URLs.BLACK_TOP_PRODUCT_PAGE.getName());
        ShoppingCartActions.addToCart(getDriver());
        goToPage(URLs.CHECKOUT_PAGE.getName());
        checkoutPage = new CheckoutPage(getDriver());
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(139)
    @QaseTitle("Expanding and collapsing the login form")
    @Description("Expanding and collapsing the login form")
    public void loginFormVisibility() {

        checkoutPage.clickLoginLink();

        try {
            checkoutPage.getLoginForm().waitForContentsLocatorValidAttribute();
        } catch (Exception e) {
            Assert.fail("The login form is not displayed");
        }
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(140)
    @QaseTitle("Expanding and collapsing the coupon code form")
    @Description("Expanding and collapsing the coupon code form")
    public void couponCodeFormVisibility() {

        checkoutPage.clickCouponCodeLink();

        try {
            checkoutPage.getCouponCodeForm().waitForContentsLocatorValidAttribute();
        } catch (Exception e) {
            Assert.fail("The coupon code form is not displayed");
        }
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(141)
    @QaseTitle("Expanding and collapsing the shipping address form")
    @Description("Expanding and collapsing the shipping address form")
    public void shippingAddressFormVisibility() {

        checkoutPage.clickDifferentAddressCheckbox();

        try {
            checkoutPage.getShippingAddressForm().waitForContentsLocatorValidAttribute();
        } catch (Exception e) {
            Assert.fail("The shipping address form is not displayed");
        }
    }
}
