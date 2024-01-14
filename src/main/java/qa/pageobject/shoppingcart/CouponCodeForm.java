package qa.pageobject.shoppingcart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.tools.toby.ToBy;

public class CouponCodeForm extends BasePage {

    public CouponCodeForm(WebDriver driver) {

        super(driver);
    }

    @FindBy(className = "checkout_coupon")
    WebElement contents;

    @FindBy(id = "coupon_code")
    WebElement couponCodeField;

    @FindBy(name = "apply_coupon")
    WebElement applyCouponButton;

    public void setCouponCode(String couponCode) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(couponCodeField))).sendKeys(couponCode);
    }

    public void clickApplyButton() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(applyCouponButton))).click();
    }

    public void waitForContentsLocatorValidAttribute() {

        getWebDriverWait().until(
                ExpectedConditions.not(ExpectedConditions.attributeToBe(contents, "style", "display: none;"))
        );
    }
}
