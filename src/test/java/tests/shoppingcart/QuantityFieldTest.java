package tests.shoppingcart;

import io.qameta.allure.*;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.SpecialCharactersDataProvider;
import qa.enums.URLs;
import qa.support.actions.ShoppingCartActions;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.support.constans.DataProviderNames;
import tests.base.QuantityFieldBaseTest;

@Epic("E2E")
@Feature("The quantity field")
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
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(128)
    @QaseTitle("MIN - 1")
    @Description("MIN - 1")
    public void belowMin() {

        setBelowMin(shoppingCart.getTable().getQuantityField(0));
        checkValidationMessageVisibility(shoppingCart.getTable().getQuantityField(0));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(129)
    @QaseTitle("MIN")
    @Description("MIN")
    public void min() {

        setMin(shoppingCart.getTable().getQuantityField(0));
        shoppingCart.clickUpdateButton();
        checkMessage("Please enter valid quantity");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(130)
    @QaseTitle("MIN + 1")
    @Description("MIN + 1")
    public void aboveMin() {

        setAboveMin(shoppingCart.getTable().getQuantityField(0));
        shoppingCart.clickUpdateButton();
        checkMessage("Please enter valid quantity");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(131)
    @QaseTitle("MAX - 1")
    @Description("MAX - 1")
    public void belowMax() {

        setBelowMax(shoppingCart.getTable().getQuantityField(0));
        shoppingCart.clickUpdateButton();
        checkMessage("Cart updated");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(132)
    @QaseTitle("MAX")
    @Description("MAX")
    public void max() {

        setMax(shoppingCart.getTable().getQuantityField(0));
        shoppingCart.clickUpdateButton();
        checkMessage("Cart updated");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(133)
    @QaseTitle("MAX + 1")
    @Description("MAX + 1")
    public void aboveMax() {

        setAboveMax(shoppingCart.getTable().getQuantityField(0));
        shoppingCart.clickUpdateButton();
        checkMessage("Please enter valid quantity");
    }

    @Test(dataProvider = DataProviderNames.SPECIAL_CHARACTERS, dataProviderClass = SpecialCharactersDataProvider.class)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(134)
    @QaseTitle("Entering a special character")
    @Description("Entering a special character")
    public void specialCharacters(String character) {

        shoppingCart.getTable().getQuantityField(0).setQuantity(character);
        checkValidationMessageVisibility(shoppingCart.getTable().getQuantityField(0));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(135)
    @QaseTitle("Blank the quantity field")
    @Description("Blank the quantity field")
    public void blankQuantityField() {

        shoppingCart.getTable().getQuantityField(0).setQuantity("");
        shoppingCart.clickUpdateButton();
        checkMessage("Please enter a quantity");
    }
}
