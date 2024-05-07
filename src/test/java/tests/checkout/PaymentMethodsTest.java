package tests.checkout;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.support.actions.Authentication;
import tests.base.BaseTest;
import qa.support.constans.URLs;
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
    public void prepare() throws IllegalAccessException, JsonProcessingException {

        goToPage(URLs.LOGIN_PAGE);
        Authentication.loginWithCredentials(getDriver());
        goToPage(URLs.BLACK_TOP_PRODUCT_PAGE);
        ShoppingCartActions.addToCart(getDriver());
        goToPage(URLs.CHECKOUT_PAGE);

        checkoutPage = new CheckoutPage(getDriver());

        String source = TestdataLoader.loadQuickly("GSS_Address");
        AddressData addressData = ModelsBuilder.getAddressFormData(DataProviderNames.CORRECT, source)[0];
        AddressFormFiller.get(addressData, getDriver());
    }

    public void waitForOrderPage(String url) {

        OrderPage orderPage = new OrderPage(getDriver());

        try {
            orderPage.waitUntilThePageIsOpen(url);
        } catch (Exception e) {
            Assert.fail("The \"" + url + "\" received page is not open");
        }
    }

    private void actions(AccessThrowingConsumer<PaymentMethodsSection> consumer) throws IllegalAccessException {

        consumer.accept(checkoutPage.getPaymentMethodsSection());
        checkoutPage.clickPlaceOrderButton();
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Checkout")
    @Tag("Payment")
    @Link(name = "Home page", value = URLs.CHECKOUT_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(143)
    @QaseTitle("The \"Direct bank transfer\" method")
    @Description("The \"Direct bank transfer\" method")
    public void directBankTransfer() throws IllegalAccessException {

        actions(PaymentMethodsSection::clickDirectBankTransferCheckbox);
        waitForOrderPage(URLs.ORDER_RECEIVED_PAGE);
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Checkout")
    @Tag("Payment")
    @Link(name = "Home page", value = URLs.CHECKOUT_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(144)
    @QaseTitle("The \"Check payments\" method")
    @Description("The \"Check payments\" method")
    public void actionsPayments() throws IllegalAccessException {

        actions(PaymentMethodsSection::clickCheckPaymentsCheckbox);
        waitForOrderPage(URLs.ORDER_RECEIVED_PAGE);
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Checkout")
    @Tag("Payment")
    @Link(name = "Home page", value = URLs.CHECKOUT_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(145)
    @QaseTitle("The \"Cash on delivery\" method")
    @Description("The \"Cash on delivery\" method")
    public void cashOnDelivery() throws IllegalAccessException {

        actions(PaymentMethodsSection::clickCashOnDeliveryCheckbox);
        waitForOrderPage(URLs.ORDER_RECEIVED_PAGE);
    }

    @Test(priority = 4)
    @Owner("Paweł Aksman")
    @Tag("Checkout")
    @Tag("Payment")
    @Link(name = "Home page", value = URLs.CHECKOUT_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(146)
    @QaseTitle("The \"PayPal\" method")
    @Description("The \"PayPal\" method")
    public void payPal() throws IllegalAccessException {

        actions(PaymentMethodsSection::clickPayPalCheckbox);
        waitForOrderPage(URLs.PAY_PAL_PAGE);
    }
}
