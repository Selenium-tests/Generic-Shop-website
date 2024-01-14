package qa.pageobject.checkoutpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;


public class PaymentMethodsSection extends BasePage {

    public PaymentMethodsSection(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "payment_method_bacs")
    WebElement directBankTransferCheckbox;

    @FindBy(id = "payment_method_cheque")
    WebElement checkPaymentsCheckbox;

    @FindBy(id = "payment_method_cod")
    WebElement cashOnDeliveryCheckbox;

    @FindBy(id = "payment_method_paypal")
    WebElement payPalCheckbox;

    public void clickDirectBankTransferCheckbox() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(directBankTransferCheckbox)).click();
    }

    public void clickCheckPaymentsCheckbox() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(checkPaymentsCheckbox)).click();
    }

    public void clickCashOnDeliveryCheckbox() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(cashOnDeliveryCheckbox)).click();
    }

    public void clickPayPalCheckbox() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(payPalCheckbox)).click();
    }
}
