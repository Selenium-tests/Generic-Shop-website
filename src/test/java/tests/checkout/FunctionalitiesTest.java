package tests.checkout;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.ThumbnailCategory;
import qa.extentreports.ExtentReportsManager;
import qa.helpers.ShoppingCartActions;
import qa.pageobject.checkoutpage.CheckoutPage;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.provider.MyDataProvider;
import qa.records.Link;

public class FunctionalitiesTest extends BaseTest {

    private ShoppingCart shoppingCart;

    @BeforeMethod
    public void create() {

        ShoppingCartActions.addToCart(getDriver(), ThumbnailCategory.ALL_BLACK_TOPS, "Black Top");
        ShoppingCartActions.openCartPage(getDriver());

        shoppingCart = new ShoppingCart(getDriver());
    }

    @Test(dataProvider = "checkoutPage", dataProviderClass = MyDataProvider.class)
    public void clickingCheckoutButton(Link link) {

        ExtentReportsManager.setName("clicking the \"Proceed to checkout\" button");

        shoppingCart.clickCheckoutButton();

        Assert.assertEquals(getDriver().getCurrentUrl(), link.pageURL(),
                "The page with the address \"" + link.pageURL() + "\" has not been found");
    }

    @Test
    public void makingShippingAddressFormVisible() {

        ExtentReportsManager.setName("Clicking the checkbox above the shipping address form");

        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        shoppingCart.clickCheckoutButton();
        checkoutPage.clickDifferentAddressCheckbox();

        Assert.assertTrue(checkoutPage.getShippingAddressForm().isVisible(),
                "The shipping address form is not visible");
    }
}
