package pages.components.addressform;

import enums.AddressFormType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.awt.*;


public class BillingAddressForm extends AddressFormBase {

    public BillingAddressForm(WebDriver driver) throws AWTException {

        super(driver, AddressFormType.BILLING);
    }

    @FindBy(id = "billing_phone")
    WebElement phoneField;

    @FindBy(id = "billing_email")
    WebElement emailField;

    public void setPhone(String phone) {

        fill(phoneField, phone);
    }

    public void setEmail(String email) {

        fill(emailField, email);
    }
}
