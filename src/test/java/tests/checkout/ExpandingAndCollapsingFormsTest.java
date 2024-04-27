package tests.checkout;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import qa.support.constans.URLs;
import qa.support.actions.ShoppingCartActions;
import qa.pageobject.checkoutpage.CheckoutPage;

@Epic("E2E")
@Feature("Expanding and collapsing forms")
public class ExpandingAndCollapsingFormsTest extends BaseTest {

    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void prepare() throws IllegalAccessException {

        goToPage(URLs.BLACK_TOP_PRODUCT_PAGE);
        ShoppingCartActions.addToCart(getDriver());
        goToPage(URLs.CHECKOUT_PAGE);
        checkoutPage = new CheckoutPage(getDriver());
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Checkout")
    @Tag("Forms")
    @Link(name = "Home page", value = URLs.CHECKOUT_PAGE)
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
    @Owner("Paweł Aksman")
    @Tag("Checkout")
    @Tag("Forms")
    @Link(name = "Home page", value = URLs.CHECKOUT_PAGE)
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
    @Owner("Paweł Aksman")
    @Tag("Checkout")
    @Tag("Forms")
    @Link(name = "Home page", value = URLs.CHECKOUT_PAGE)
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
