package tests.checkout;

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

    @Test
    public void shippingAddressFormVisibility() throws IllegalAccessException {

        checkoutPage.clickDifferentAddressCheckbox();

        try {
            checkoutPage.getShippingAddressForm().waitForContentsLocatorValidAttribute();
        } catch (Exception e) {
            Assert.fail("The shipping address form is not displayed");
        }
    }

    @Test
    public void loginFormVisibility() {

        checkoutPage.clickLoginLink();

        try {
            checkoutPage.getLoginForm().waitForContentsLocatorValidAttribute();
        } catch (Exception e) {
            Assert.fail("The login form is not displayed");
        }
    }

    @Test
    public void couponCodeFormVisibility() throws IllegalAccessException {

        checkoutPage.clickCouponCodeLink();

        try {
            checkoutPage.getCouponCodeForm().waitForContentsLocatorValidAttribute();
        } catch (Exception e) {
            Assert.fail("The coupon code form is not displayed");
        }
    }

    @Test
    public void orderCommentsField() throws IllegalAccessException {

        String comment = "This is the comment";
        checkoutPage.getOrderCommentsField().setComment(comment);

        Assert.assertEquals(checkoutPage.getOrderCommentsField().getComment(), comment,
                "Incorrect order comment");
    }
}
