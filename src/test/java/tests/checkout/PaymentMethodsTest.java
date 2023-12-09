package tests.checkout;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.ThumbnailCategory;
import qa.helpers.AddressFormFiller;
import qa.helpers.ShoppingCartActions;
import qa.pageobject.checkoutpage.CheckoutPage;
import qa.pageobject.checkoutpage.PaymentMethodsSection;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.provider.MyDataProvider;
import qa.records.AddressFormData;

import java.util.function.Consumer;

public class PaymentMethodsTest extends BaseTest {

    private final String url = "https://skleptest.pl/checkout/order-received/";

    @BeforeMethod
    public void create() {

        ShoppingCartActions.addToCart(getDriver(), ThumbnailCategory.ALL_BLACK_TOPS, "Black Top");
        ShoppingCartActions.openCartPage(getDriver());

        ShoppingCart shoppingCart = new ShoppingCart(getDriver());
        shoppingCart.clickCheckoutButton();
    }

    private void check(AddressFormData data, Consumer<PaymentMethodsSection> consumer) throws InterruptedException {

        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        AddressFormFiller.get(data, getDriver());
        consumer.accept(checkoutPage.getPaymentMethodsSection());
        checkoutPage.clickPlaceOrderButton();

        Thread.sleep(3000);

        Assert.assertTrue(getDriver().getCurrentUrl().contains("https://skleptest.pl/checkout/order-received/"),
                "The page with the address \"" + url + "\"has not been found");
    }

    @Test(dataProvider = "AF_correctAddress", dataProviderClass = MyDataProvider.class)
    public void directBankTransfer(AddressFormData data) throws InterruptedException {

        check(data, PaymentMethodsSection::clickDirectBankTransferCheckbox);
    }

    @Test(dataProvider = "AF_correctAddress", dataProviderClass = MyDataProvider.class)
    public void checkPayments(AddressFormData data) throws InterruptedException {

        check(data, PaymentMethodsSection::clickCheckPaymentsCheckbox);
    }

    @Test(dataProvider = "AF_correctAddress", dataProviderClass = MyDataProvider.class)
    public void cashOnDelivery(AddressFormData data) throws InterruptedException {

        check(data, PaymentMethodsSection::clickCashOnDeliveryCheckbox);
    }

    @Test(dataProvider = "AF_correctAddress", dataProviderClass = MyDataProvider.class)
    public void payPal(AddressFormData data) throws InterruptedException {

        check(data, PaymentMethodsSection::clickPayPalCheckbox);
    }
}
