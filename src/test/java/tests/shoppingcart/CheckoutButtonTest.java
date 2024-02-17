package tests.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import qa.enums.URLs;
import qa.helpers.ShoppingCartActions;
import qa.pageobject.shoppingcart.ShoppingCart;

public class CheckoutButtonTest extends BaseTest {

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToSpecificPage(URLs.BLACK_TOP_PRODUCT_PAGE.getName());
        ShoppingCartActions.addToCart(getDriver());
        goToSpecificPage(URLs.SHOPPING_CART.getName());
    }

    @Test
    public void clickingCheckoutButton() {

        ShoppingCart shoppingCart = new ShoppingCart(getDriver());
        shoppingCart.clickCheckoutButton();

        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.CHECKOUT_PAGE.getName(),
                "The page with the address \"" + URLs.CHECKOUT_PAGE.getName() + "\" has not been found");
    }
}
