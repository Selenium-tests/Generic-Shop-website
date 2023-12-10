package qa.pageobject.checkoutpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.pageobject.addressform.AddressForm;
import qa.pageobject.addressform.ShippingAddressForm;


public class CheckoutPage extends BasePage {

    private final AddressForm addressForm;
    private final ShippingAddressForm shippingAddressForm;
    private final PaymentMethodsSection paymentMethodsSection;

    public CheckoutPage(WebDriver driver) {

        super(driver);

        addressForm = new AddressForm(driver);
        shippingAddressForm = new ShippingAddressForm(driver);
        paymentMethodsSection = new PaymentMethodsSection(driver);
    }

    @FindBy(id = "ship-to-different-address-checkbox")
    WebElement differentAddressCheckbox;

    @FindBy(id = "place_order")
    WebElement placeOrderButton;

    public void clickDifferentAddressCheckbox() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(differentAddressCheckbox)).click();
    }

    public void clickPlaceOrderButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }

    public AddressForm getAddressForm() {

        return addressForm;
    }

    public ShippingAddressForm getShippingAddressForm() {

        return shippingAddressForm;
    }

    public PaymentMethodsSection getPaymentMethodsSection() {

        return paymentMethodsSection;
    }
}
