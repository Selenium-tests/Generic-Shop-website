package tests.checkout;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.URLs;
import qa.helpers.ShoppingCartActions;
import qa.pageobject.checkoutpage.CheckoutPage;
import qa.dataproviders.DataProviders;


public class FunctionalitiesTest extends BaseTest {

    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToSpecificPage(URLs.BLACK_TOP_PRODUCT_PAGE.getName());
        ShoppingCartActions.addToCart(getDriver());
        goToSpecificPage(URLs.CHECKOUT_PAGE.getName());
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

    @Test(dataProvider = "orderComments", dataProviderClass = DataProviders.class)
    public void orderCommentsField(String comment) throws IllegalAccessException {

        checkoutPage.getOrderCommentsField().setComment(comment);

        Assert.assertEquals(checkoutPage.getOrderCommentsField().getComment(), comment,
                "Incorrect order comment");
    }
}
