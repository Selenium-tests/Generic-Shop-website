package tests.checkout;

import io.qameta.allure.*;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import qa.enums.URLs;
import qa.support.addressformfiller.AddressFormFiller;
import qa.support.actions.ShoppingCartActions;
import qa.support.modelsbuilder.ModelsBuilder;
import qa.pageobject.checkoutpage.CheckoutPage;
import qa.pageobject.checkoutpage.PaymentMethodsSection;
import qa.models.AddressData;
import qa.pageobject.orderreceivedpage.OrderPage;
import qa.support.constans.DataProviderNames;
import qa.support.testdataloader.TestdataLoader;
import qa.support.consumer.AccessThrowingConsumer;

@Epic("E2E")
@Feature("Payment methods")
public class PaymentMethodsTest extends BaseTest {

    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToPage(URLs.BLACK_TOP_PRODUCT_PAGE.getName());
        ShoppingCartActions.addToCart(getDriver());
        goToPage(URLs.CHECKOUT_PAGE.getName());

        checkoutPage = new CheckoutPage(getDriver());

        String source = TestdataLoader.loadQuickly("GSP_Address");
        AddressData addressData = ModelsBuilder.getAddressFormData(DataProviderNames.CORRECT, source)[0];
        AddressFormFiller.get(addressData, getDriver());
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

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(143)
    @QaseTitle("The \"Direct bank transfer\" method")
    @Description("The \"Direct bank transfer\" method")
    public void directBankTransfer() throws IllegalAccessException {

        check(PaymentMethodsSection::clickDirectBankTransferCheckbox);
        waitForOrderPage(URLs.ORDER_RECEIVED);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(144)
    @QaseTitle("The \"Check payments\" method")
    @Description("The \"Check payments\" method")
    public void checkPayments() throws IllegalAccessException {

        check(PaymentMethodsSection::clickCheckPaymentsCheckbox);
        waitForOrderPage(URLs.ORDER_RECEIVED);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(145)
    @QaseTitle("The \"Cash on delivery\" method")
    @Description("The \"Cash on delivery\" method")
    public void cashOnDelivery() throws IllegalAccessException {

        check(PaymentMethodsSection::clickCashOnDeliveryCheckbox);
        waitForOrderPage(URLs.ORDER_RECEIVED);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(146)
    @QaseTitle("The \"PayPal\" method")
    @Description("The \"PayPal\" method")
    public void payPal() throws IllegalAccessException {

        check(PaymentMethodsSection::clickPayPalCheckbox);
        waitForOrderPage(URLs.PAY_PAL);
    }
}
