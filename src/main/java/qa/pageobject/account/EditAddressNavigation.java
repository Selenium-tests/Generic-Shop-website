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

    @FindBy(xpath = ".//div[@class='u-column1 col-1 woocommerce-Address']")
    WebElement billingAddress;

    @FindBy(xpath = ".//div[@class='u-column2 col-2 woocommerce-Address']")
    WebElement shippingAddress;


    public void clickBillingAddressLink() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(".//a[@href]"))).click();
    }

    public void clickShippingAddressLink() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(shippingAddress.findElement(By.xpath(".//a[@href]")))).click();
    }
}
