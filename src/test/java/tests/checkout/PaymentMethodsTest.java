package tests.checkout;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.ThumbnailCategory;
import qa.helpers.AddressFormFiller;
import qa.helpers.ShoppingCartActions;
import qa.pageobject.checkoutpage.CheckoutPage;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.provider.MyDataProvider;
import qa.records.AddressFormData;

public class PaymentMethodsTest extends BaseTest {

    @BeforeMethod
    public void create() {

        ShoppingCartActions.addToCart(getDriver(), ThumbnailCategory.ALL_BLACK_TOPS, "Black Top");
        ShoppingCartActions.openCartPage(getDriver());

        ShoppingCart shoppingCart = new ShoppingCart(getDriver());
        shoppingCart.clickCheckoutButton();
    }

    @Test(dataProvider = "AF_correctAddress", dataProviderClass = MyDataProvider.class)
    public void directBankTransfer(AddressFormData data) throws InterruptedException {

        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        AddressFormFiller.get(data, getDriver());
        checkoutPage.getPaymentMethodsSection().clickDirectBankTransferCheckbox();
        checkoutPage.clickPlaceOrderButton();

        Thread.sleep(3000);

        Assert.assertTrue(getDriver().getCurrentUrl().contains("https://skleptest.pl/checkout/order-received/"),
                "The page with the address \"https://skleptest.pl/checkout/order-received/\" has not been found");
    }
}
