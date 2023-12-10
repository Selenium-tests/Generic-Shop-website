package tests.checkout;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.URLs;
import qa.extentreports.ExtentReportsManager;
import qa.helpers.ShoppingCartActions;
import qa.pageobject.checkoutpage.CheckoutPage;


public class FunctionalitiesTest extends BaseTest {

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToSpecificPage(URLs.BLACK_TOP_PRODUCT_PAGE.getName());
        ShoppingCartActions.addToCart(getDriver());
        goToSpecificPage(URLs.CHECKOUT_PAGE.getName());
    }

    @Test
    public void makingShippingAddressFormVisible() throws IllegalAccessException {

        ExtentReportsManager.setName("Clicking the checkbox above the shipping address form");

        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        checkoutPage.clickDifferentAddressCheckbox();

        Assert.assertTrue(checkoutPage.getShippingAddressForm().isVisible(),
                "The shipping address form is not visible");
    }
}
