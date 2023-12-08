package tests.checkout;

import org.testng.annotations.BeforeMethod;
import qa.base.BaseTest;
import qa.enums.ThumbnailCategory;
import qa.helpers.ShoppingCartActions;
import qa.pageobject.shoppingcart.ShoppingCart;

public class PaymentMethodsTest extends BaseTest {

    @BeforeMethod
    public void create() {

        ShoppingCartActions.addToCart(getDriver(), ThumbnailCategory.ALL_BLACK_TOPS, "Black Top");
        ShoppingCartActions.openCartPage(getDriver());

        ShoppingCart shoppingCart = new ShoppingCart(getDriver());
        shoppingCart.clickCheckoutButton();
    }


}
