package qa.pageobject.account;

import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EditAddressNavigation extends BasePage {

    public EditAddressNavigation(WebDriver driver) {

        super(driver);
    }

    @FindBy(css = ".u-column1.col-1.woocommerce-Address")
    WebElement billingAddress;

    @FindBy(css = "..u-column2.col-2.woocommerce-Address']")
    WebElement shippingAddress;


    @io.qameta.allure.Step("Click the \"Edit\" link in the billing address section")
    @io.qase.api.annotation.Step("Click the \"Edit\" link in the billing address section")
    public void clickBillingAddressLink() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(billingAddress.findElement(By.xpath(".//a[@href]")))).click();
    }

    @io.qameta.allure.Step("Click the \"Edit\" link in the shipping address section")
    @io.qase.api.annotation.Step("Click the \"Edit\" link in the shipping address section")
    public void clickShippingAddressLink() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(shippingAddress.findElement(By.xpath(".//a[@href]")))).click();
    }
}
