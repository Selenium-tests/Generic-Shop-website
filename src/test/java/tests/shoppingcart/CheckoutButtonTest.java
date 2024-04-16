package tests.shoppingcart;

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
import qa.pageobject.shoppingcart.ShoppingCart;

@Epic("E2E")
@Epic("The shopping cart")
public class CheckoutButtonTest extends BaseTest {

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToPage(URLs.BLACK_TOP_PRODUCT_PAGE);
        ShoppingCartActions.addToCart(getDriver());
        goToPage(URLs.SHOPPING_CART_PAGE);
    }

    @Test
    @Owner("Paweł Aksman")
    @Tag("Shopping cart")
    @Tag("Buttons")
    @Link(name = "Home page", value = URLs.SHOPPING_CART_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(138)
    @QaseTitle("The\"Proceed to checkout\" button")
    @Description("The \"Proceed to checkout\" button")
    public void clickingCheckoutButton() {

        ShoppingCart shoppingCart = new ShoppingCart(getDriver());
        shoppingCart.clickCheckoutButton();

        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.CHECKOUT_PAGE,
                "The page with the address \"" + URLs.CHECKOUT_PAGE + "\" has not been found");
    }
}
