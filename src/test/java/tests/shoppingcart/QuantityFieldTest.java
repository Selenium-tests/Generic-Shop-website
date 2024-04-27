package tests.shoppingcart;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.SpecialCharactersDataProvider;
import qa.support.constans.URLs;
import qa.support.actions.ShoppingCartActions;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.support.constans.DataProviderNames;
import tests.base.QuantityFieldBaseTest;

@Epic("E2E")
@Feature("The shopping cart quantity field")
public class QuantityFieldTest extends QuantityFieldBaseTest {

    private ShoppingCart shoppingCart;

    @BeforeMethod
    public void prepare() throws IllegalAccessException {

        goToPage(URLs.BLACK_TOP_PRODUCT_PAGE);
        ShoppingCartActions.addToCart(getDriver());
        goToPage(URLs.SHOPPING_CART_PAGE);
        shoppingCart = new ShoppingCart(getDriver());
        shoppingCart.getTable().findRows();
    }

    private void checkMessage(String expectedMessage) {

        checkMessageVisibility(ShoppingCart::waitForMessage, shoppingCart);
        checkMessageContent(shoppingCart.getMessage(), expectedMessage);
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Shopping cart")
    @Tag("Fields")
    @Tag("Quantity fields")
    @Tag("Quantity")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.SHOPPING_CART_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(129)
    @QaseTitle("Verification of the quantity field text input")
    @Description("Verification of the quantity field text input")
    public void inputTextVerification() {

        String quantity = "25";
        shoppingCart.getTable().getQuantityField(0).setQuantity(quantity);
        Assert.assertEquals(shoppingCart.getTable().getQuantityField(0).getValue(), quantity, "Incorrect the quantity field output");
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Shopping cart")
    @Tag("Fields")
    @Tag("Quantity fields")
    @Tag("Quantity")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.SHOPPING_CART_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(130)
    @QaseTitle("Quantity- shorter than minimum (min - 1)")
    @Description("Quantity- shorter than minimum (min - 1)")
    public void belowMin() {

        setBelowMin(shoppingCart.getTable().getQuantityField(0));
        checkValidationMessageVisibility(shoppingCart.getTable().getQuantityField(0));
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Shopping cart")
    @Tag("Fields")
    @Tag("Quantity fields")
    @Tag("Quantity")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.SHOPPING_CART_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(131)
    @QaseTitle("Quantity- minimum")
    @Description("Quantity- minimum")
    public void min() {

        setMin(shoppingCart.getTable().getQuantityField(0));
        shoppingCart.clickUpdateButton();
        checkMessage("Please enter valid quantity");
    }

    @Test(priority = 4)
    @Owner("Paweł Aksman")
    @Tag("Shopping cart")
    @Tag("Fields")
    @Tag("Quantity fields")
    @Tag("Quantity")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.SHOPPING_CART_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(132)
    @QaseTitle("Quantity- exceeding minimum (min + 1)")
    @Description("Quantity- exceeding minimum (min + 1)")
    public void aboveMin() {

        setAboveMin(shoppingCart.getTable().getQuantityField(0));
        shoppingCart.clickUpdateButton();
        checkMessage("Please enter valid quantity");
    }

    @Test(priority = 5)
    @Owner("Paweł Aksman")
    @Tag("Shopping cart")
    @Tag("Fields")
    @Tag("Quantity fields")
    @Tag("Quantity")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.SHOPPING_CART_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(133)
    @QaseTitle("Quantity- shorter than maximum (max - 1)")
    @Description("Quantity- shorter than maximum (max - 1)")
    public void belowMax() {

        setBelowMax(shoppingCart.getTable().getQuantityField(0));
        shoppingCart.clickUpdateButton();
        checkMessage("Cart updated");
    }

    @Test(priority = 6)
    @Owner("Paweł Aksman")
    @Tag("Shopping cart")
    @Tag("Fields")
    @Tag("Quantity fields")
    @Tag("Quantity")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.SHOPPING_CART_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(134)
    @QaseTitle("Quantity- maximum")
    @Description("Quantity- maximum")
    public void max() {

        setMax(shoppingCart.getTable().getQuantityField(0));
        shoppingCart.clickUpdateButton();
        checkMessage("Cart updated");
    }

    @Test(priority = 7)
    @Owner("Paweł Aksman")
    @Tag("Shopping cart")
    @Tag("Fields")
    @Tag("Quantity fields")
    @Tag("Quantity")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.SHOPPING_CART_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(135)
    @QaseTitle("Quantity- exceeding maximum (max + 1)")
    @Description("Quantity- exceeding maximum (max + 1)")
    public void aboveMax() {

        setAboveMax(shoppingCart.getTable().getQuantityField(0));
        shoppingCart.clickUpdateButton();
        checkMessage("Please enter valid quantity");
    }

    @Test(priority = 8, dataProvider = DataProviderNames.SPECIAL_CHARACTERS, dataProviderClass = SpecialCharactersDataProvider.class)
    @Owner("Paweł Aksman")
    @Tag("Shopping cart")
    @Tag("Fields")
    @Tag("Quantity fields")
    @Tag("Quantity")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.SHOPPING_CART_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(136)
    @QaseTitle("Entering a special character")
    @Description("Entering a special character")
    public void specialCharacters(String character) {

        Allure.parameter("Character", character);
        shoppingCart.getTable().getQuantityField(0).setQuantity(character);
        checkValidationMessageVisibility(shoppingCart.getTable().getQuantityField(0));
    }

    @Test(priority = 9)
    @Owner("Paweł Aksman")
    @Tag("Shopping cart")
    @Tag("Fields")
    @Tag("Quantity fields")
    @Tag("Quantity")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.SHOPPING_CART_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(137)
    @QaseTitle("Blank the quantity field")
    @Description("Blank the quantity field")
    public void blankQuantityField() {

        shoppingCart.getTable().getQuantityField(0).setQuantity("");
        shoppingCart.clickUpdateButton();
        checkMessage("Please enter a quantity");
    }
}
