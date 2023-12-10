package qa.pageobject.productpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;


public class QuantityField extends BasePage {

    public QuantityField(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = ".//input[@type='number']")
    WebElement field;

    public void setQuantity(String quantity) throws IllegalAccessException {

        field.clear();
        field.sendKeys(quantity);
    }

    public String getValidationMessage() {

        return field.getAttribute("validationMessage");
    }
}
