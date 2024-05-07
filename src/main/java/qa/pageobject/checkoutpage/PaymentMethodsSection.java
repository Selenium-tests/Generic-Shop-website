package qa.pageobject.checkoutpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;


public class PaymentMethodsSection extends BasePage {

    private final String blockOverlaySelector = ".blockUI.blockOverlay";

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

    private void waitForBlockOverlayInvisibility() {

        getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(blockOverlaySelector)));
    }

    public void clickDirectBankTransferCheckbox() {

        waitForBlockOverlayInvisibility();
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(directBankTransferCheckbox)).click();
    }

    public void clickCheckPaymentsCheckbox() {

        waitForBlockOverlayInvisibility();
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(checkPaymentsCheckbox)).click();
    }

    public void clickCashOnDeliveryCheckbox() {

        waitForBlockOverlayInvisibility();
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(cashOnDeliveryCheckbox)).click();
    }

    public void clickPayPalCheckbox() {

        waitForBlockOverlayInvisibility();
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(payPalCheckbox)).click();
    }
}
