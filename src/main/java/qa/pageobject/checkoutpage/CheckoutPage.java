package qa.pageobject.checkoutpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.pageobject.LoginForm;
import qa.pageobject.addressform.ShippingAddressForm;
import qa.pageobject.shoppingcart.CouponCodeForm;


public class CheckoutPage extends BasePage {

    private final LoginForm loginForm;
    private final CouponCodeForm couponCodeForm;
    private final ShippingAddressForm shippingAddressForm;
    private final OrderCommentsField orderCommentsField;
    private final PaymentMethodsSection paymentMethodsSection;

    public CheckoutPage(WebDriver driver) {

        super(driver);

        loginForm = new LoginForm(driver);
        couponCodeForm = new CouponCodeForm(driver);
        shippingAddressForm = new ShippingAddressForm(driver);
        orderCommentsField = new OrderCommentsField(driver);
        paymentMethodsSection = new PaymentMethodsSection(driver);
    }

    @FindBy(className = "showlogin")
    WebElement loginLink;

    @FindBy(className = "showcoupon")
    WebElement couponCodeLink;

    @FindBy(id = "ship-to-different-address-checkbox")
    WebElement differentAddressCheckbox;

    @FindBy(id = "place_order")
    WebElement placeOrderButton;

    public void clickLoginLink() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }

    public void clickCouponCodeLink() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(couponCodeLink)).click();
    }

    public void clickDifferentAddressCheckbox() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(differentAddressCheckbox)).click();
    }

    public void clickPlaceOrderButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }

    public LoginForm getLoginForm() {

        return loginForm;
    }

    public CouponCodeForm getCouponCodeForm() {

        return couponCodeForm;
    }

    public ShippingAddressForm getShippingAddressForm() {

        return shippingAddressForm;
    }

    public OrderCommentsField getOrderCommentsField() {

        return orderCommentsField;
    }

    public PaymentMethodsSection getPaymentMethodsSection() {

        return paymentMethodsSection;
    }
}
