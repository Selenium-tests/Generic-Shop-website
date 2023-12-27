package tests.checkout;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.URLs;
import qa.extentreports.ExtentReportsManager;
import qa.helpers.AddressFormFiller;
import qa.helpers.ShoppingCartActions;
import qa.pageobject.checkoutpage.CheckoutPage;
import qa.pageobject.checkoutpage.PaymentMethodsSection;
import qa.provider.MyDataProvider;
import qa.records.AddressFormData;
import qa.utils.MyConsumer;


public class PaymentMethodsTest extends BaseTest {

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToSpecificPage(URLs.BLACK_TOP_PRODUCT_PAGE.getName());
        ShoppingCartActions.addToCartAndOpen(getDriver());
        goToSpecificPage(URLs.CHECKOUT_PAGE.getName());
    }

    private void check(AddressFormData data, MyConsumer<PaymentMethodsSection> consumer) throws InterruptedException, IllegalAccessException {

        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        AddressFormFiller.get(data, getDriver(), true);
        consumer.accept(checkoutPage.getPaymentMethodsSection());
        checkoutPage.clickPlaceOrderButton();

        Thread.sleep(3000);

        Assert.assertTrue(getDriver().getCurrentUrl().contains(URLs.ORDER_RECEIVED.getName()),
                "The page with the address \"" + URLs.ORDER_RECEIVED.getName() + "\"has not been found");
    }

    @Test(dataProvider = "AF_correctAddress", dataProviderClass = MyDataProvider.class)
    public void directBankTransfer(AddressFormData data) throws InterruptedException, IllegalAccessException {

        ExtentReportsManager.setName("Payment via direct bank transfer");

        check(data, PaymentMethodsSection::clickDirectBankTransferCheckbox);
    }

    @Test(dataProvider = "AF_correctAddress", dataProviderClass = MyDataProvider.class)
    public void checkPayments(AddressFormData data) throws InterruptedException, IllegalAccessException {

        ExtentReportsManager.setName("Payment via check payments");

        check(data, PaymentMethodsSection::clickCheckPaymentsCheckbox);
    }

    @Test(dataProvider = "AF_correctAddress", dataProviderClass = MyDataProvider.class)
    public void cashOnDelivery(AddressFormData data) throws InterruptedException, IllegalAccessException {

        ExtentReportsManager.setName("Payment via cash on delivery");

        check(data, PaymentMethodsSection::clickCashOnDeliveryCheckbox);
    }

    @Test(dataProvider = "AF_correctAddress", dataProviderClass = MyDataProvider.class)
    public void payPal(AddressFormData data) throws InterruptedException, IllegalAccessException {

        ExtentReportsManager.setName("Payment via PayPal");

        check(data, PaymentMethodsSection::clickPayPalCheckbox);
    }
}
