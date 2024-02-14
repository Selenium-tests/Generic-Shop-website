package qa.quantityfield;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;

public class QuantityField extends BasePage {

    private final String inputFieldSelector;
    private final WebElement parent;

    public QuantityField(WebDriver driver, WebElement parent) {

        super(driver);

        this.inputFieldSelector = "input[type='number']";
        this.parent = parent;
    }

    public void setQuantity(String quantity) {

        WebElement element = getWebDriverWait().until(ExpectedConditions.elementToBeClickable(
                parent.findElement(By.cssSelector(inputFieldSelector))));
        element.clear();
        element.sendKeys(quantity);
    }

    public String getValue() {

        return parent.findElement(By.cssSelector(inputFieldSelector)).getAttribute("value");
    }

    public String getMin() {

        return getWebDriverWait().until(ExpectedConditions.elementToBeClickable(
                parent.findElement(By.cssSelector(inputFieldSelector)))).getAttribute("min");
    }

    public String getValidationMessage() {

        return getWebDriverWait().until(ExpectedConditions.elementToBeClickable(
                parent.findElement(By.cssSelector(inputFieldSelector)))).getAttribute("validationMessage");
    }
}
