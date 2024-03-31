package tests.shoppingcart;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
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
import qa.pageobject.shoppingcart.ShoppingCart;

@Epic("E2E")
@Epic("The shopping cart")
public class CheckoutButtonTest extends BaseTest {

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToPage(URLs.BLACK_TOP_PRODUCT_PAGE.getName());
        ShoppingCartActions.addToCart(getDriver());
        goToPage(URLs.SHOPPING_CART.getName());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(136)
    @QaseTitle("The\"Proceed to checkout\" button")
    @Description("The \"Proceed to checkout\" button")
    public void clickingCheckoutButton() {

        ShoppingCart shoppingCart = new ShoppingCart(getDriver());
        shoppingCart.clickCheckoutButton();

        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.CHECKOUT_PAGE.getName(),
                "The page with the address \"" + URLs.CHECKOUT_PAGE.getName() + "\" has not been found");
    }
}
