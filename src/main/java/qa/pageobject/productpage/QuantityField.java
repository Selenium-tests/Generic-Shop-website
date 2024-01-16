package qa.pageobject.productpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.tools.toby.ToBy;


public class QuantityField extends BasePage {

    public QuantityField(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = ".//input[@type='number']")
    WebElement field;

    public void setQuantity(String quantity) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(field)));
        field.clear();
        field.sendKeys(quantity);
    }

    public String getValidationMessage() {

        return field.getAttribute("validationMessage");
    }
}
