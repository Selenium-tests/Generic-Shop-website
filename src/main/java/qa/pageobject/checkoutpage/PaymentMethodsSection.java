package qa.pageobject.checkoutpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

        directBankTransferCheckbox.click();
    }

    public void clickCheckPaymentsCheckbox() {

        checkPaymentsCheckbox.click();
    }

    public void clickCashOnDeliveryCheckbox() {

        cashOnDeliveryCheckbox.click();
    }

    public void clickPayPalCheckbox() {

        payPalCheckbox.click();
    }
}
