package tests.checkout;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.URLs;
import qa.helpers.AddressFormFiller;
import qa.helpers.ShoppingCartActions;
import qa.pageobject.checkoutpage.CheckoutPage;
import qa.pageobject.checkoutpage.PaymentMethodsSection;
import qa.dataproviders.DataProviders;
import qa.data.AddressFormData;
import qa.pageobject.orderreceivedpage.OrderPage;
import qa.utils.AccessThrowingConsumer;


public class PaymentMethodsTest extends BaseTest {

    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToSpecificPage(URLs.BLACK_TOP_PRODUCT_PAGE.getName());
        ShoppingCartActions.addToCart(getDriver());
        goToSpecificPage(URLs.CHECKOUT_PAGE.getName());

        checkoutPage = new CheckoutPage(getDriver());

        AddressFormData addressFormData = (AddressFormData) new DataProviders().AF_correctAddress()[0];
        AddressFormFiller.get(addressFormData, getDriver(), true);
    }

    public void waitForOrderPage(URLs url) {

        OrderPage orderPage = new OrderPage(getDriver());

        try {
            orderPage.waitUntilThePageIsOpen(url.getName());
        } catch (Exception e) {
            Assert.fail("The \"" + url.getName() + "\" received page is not open");
        }
    }

    private void check(AccessThrowingConsumer<PaymentMethodsSection> consumer) throws IllegalAccessException {

        consumer.accept(checkoutPage.getPaymentMethodsSection());
        checkoutPage.clickPlaceOrderButton();
    }

    @Test
    public void directBankTransfer() throws IllegalAccessException {

        check(PaymentMethodsSection::clickDirectBankTransferCheckbox);
        waitForOrderPage(URLs.ORDER_RECEIVED);
    }

    @Test
    public void checkPayments() throws IllegalAccessException {

        check(PaymentMethodsSection::clickCheckPaymentsCheckbox);
        waitForOrderPage(URLs.ORDER_RECEIVED);
    }

    @Test
    public void cashOnDelivery() throws IllegalAccessException {

        check(PaymentMethodsSection::clickCashOnDeliveryCheckbox);
        waitForOrderPage(URLs.ORDER_RECEIVED);
    }

    @Test()
    public void payPal() throws IllegalAccessException {

        check(PaymentMethodsSection::clickPayPalCheckbox);
        waitForOrderPage(URLs.PAY_PAL);
    }
}
