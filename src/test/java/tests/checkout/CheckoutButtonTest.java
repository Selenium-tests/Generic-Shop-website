package tests.checkout;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.URLs;
import qa.helpers.ShoppingCartActions;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.dataproviders.DataProviders;
import qa.data.Link;

public class CheckoutButtonTest extends BaseTest {

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToSpecificPage(URLs.BLACK_TOP_PRODUCT_PAGE.getName());
        ShoppingCartActions.addToCartAndOpen(getDriver());
        goToSpecificPage(URLs.SHOPPING_CART.getName());
    }

    @Test(dataProvider = "checkoutPage", dataProviderClass = DataProviders.class)
    public void clickingCheckoutButton(Link link) throws IllegalAccessException {

        ShoppingCart shoppingCart = new ShoppingCart(getDriver());
        shoppingCart.clickCheckoutButton();

        Assert.assertEquals(getDriver().getCurrentUrl(), link.getPageURL(),
                "The page with the address \"" + link.getPageURL() + "\" has not been found");
    }
}
