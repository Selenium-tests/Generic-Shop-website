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
import qa.provider.MyDataProvider;
import qa.records.AddressFormData;
import qa.utils.MyConsumer;


public class PaymentMethodsTest extends BaseTest {

    private final String url = "https://skleptest.pl/checkout/order-received/";

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToSpecificPage(URLs.BLACK_TOP_PRODUCT_PAGE.getName());
        ShoppingCartActions.addToCartAndOpen(getDriver());
        goToSpecificPage(URLs.CHECKOUT_PAGE.getName());
    }

    private void check(AddressFormData data, MyConsumer<PaymentMethodsSection> consumer) throws InterruptedException, IllegalAccessException {

        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        AddressFormFiller.get(data, getDriver());
        consumer.accept(checkoutPage.getPaymentMethodsSection());
        checkoutPage.clickPlaceOrderButton();

        Thread.sleep(3000);

        Assert.assertTrue(getDriver().getCurrentUrl().contains("https://skleptest.pl/checkout/order-received/"),
                "The page with the address \"" + url + "\"has not been found");
    }

    @Test(dataProvider = "AF_correctAddress", dataProviderClass = MyDataProvider.class)
    public void directBankTransfer(AddressFormData data) throws InterruptedException, IllegalAccessException {

        check(data, PaymentMethodsSection::clickDirectBankTransferCheckbox);
    }

    @Test(dataProvider = "AF_correctAddress", dataProviderClass = MyDataProvider.class)
    public void checkPayments(AddressFormData data) throws InterruptedException, IllegalAccessException {

        check(data, PaymentMethodsSection::clickCheckPaymentsCheckbox);
    }

    @Test(dataProvider = "AF_correctAddress", dataProviderClass = MyDataProvider.class)
    public void cashOnDelivery(AddressFormData data) throws InterruptedException, IllegalAccessException {

        check(data, PaymentMethodsSection::clickCashOnDeliveryCheckbox);
    }

    @Test(dataProvider = "AF_correctAddress", dataProviderClass = MyDataProvider.class)
    public void payPal(AddressFormData data) throws InterruptedException, IllegalAccessException {

        check(data, PaymentMethodsSection::clickPayPalCheckbox);
    }
}
