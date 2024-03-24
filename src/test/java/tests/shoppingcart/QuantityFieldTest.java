package tests.shoppingcart;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.SpecialCharactersDataProvider;
import qa.enums.URLs;
import qa.support.actions.ShoppingCartActions;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.support.constans.DataProviderNames;
import tests.base.QuantityFieldBaseTest;

public class QuantityFieldTest extends QuantityFieldBaseTest {

    private ShoppingCart shoppingCart;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToPage(URLs.BLACK_TOP_PRODUCT_PAGE.getName());
        ShoppingCartActions.addToCart(getDriver());
        goToPage(URLs.SHOPPING_CART.getName());
        shoppingCart = new ShoppingCart(getDriver());
        shoppingCart.getTable().findRows();
    }

    private void checkMessage(String expectedMessage) {

        checkMessageVisibility(ShoppingCart::waitForMessage, shoppingCart);
        checkMessageContent(shoppingCart.getMessage(), expectedMessage);
    }

    @Test
    public void belowMin() throws IllegalAccessException {

        setBelowMin(shoppingCart.getTable().getQuantityField(0));
        checkValidationMessageVisibility(shoppingCart.getTable().getQuantityField(0));
    }

    @Test
    public void min() {

        setMin(shoppingCart.getTable().getQuantityField(0));
        shoppingCart.clickUpdateButton();
        checkMessage("Please enter valid quantity");
    }

    @Test
    public void aboveMin() {

        setAboveMin(shoppingCart.getTable().getQuantityField(0));
        shoppingCart.clickUpdateButton();
        checkMessage("Please enter valid quantity");
    }

    @Test
    public void belowMax() {

        setBelowMax(shoppingCart.getTable().getQuantityField(0));
        shoppingCart.clickUpdateButton();
        checkMessage("Cart updated");
    }

    @Test
    public void max() {

        setMax(shoppingCart.getTable().getQuantityField(0));
        shoppingCart.clickUpdateButton();
        checkMessage("Cart updated");
    }

    @Test
    public void aboveMax() {

        setAboveMax(shoppingCart.getTable().getQuantityField(0));
        shoppingCart.clickUpdateButton();
        checkMessage("Please enter valid quantity");
    }

    @Test(dataProvider = DataProviderNames.SPECIAL_CHARACTERS, dataProviderClass = SpecialCharactersDataProvider.class)
    public void specialCharacters(String character) {

        shoppingCart.getTable().getQuantityField(0).setQuantity(character);
        checkValidationMessageVisibility(shoppingCart.getTable().getQuantityField(0));
    }
}
