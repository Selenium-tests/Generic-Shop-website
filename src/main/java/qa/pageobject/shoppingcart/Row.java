package qa.pageobject.shoppingcart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.pageobject.productpage.QuantityField;
import qa.tools.toby.ToBy;


public class Row extends BasePage {

    private WebElement parent;
    private final QuantityField quantityField;

    public Row(WebDriver driver) {

        super(driver);

        quantityField = new QuantityField(driver);
    }

    public void setParent(WebElement parent) {

        this.parent = parent;
    }

    public void clickRemoveButton() {

        parent.findElement(By.xpath(".//a[@class='remove']")).click();
    }

    public String getName() {

        return parent.findElement(By.className("product-name")).getText();
    }

    public String getPrice() {

        return parent.findElement(By.className("product-price")).getText();
    }

    public String getSubtotal() throws IllegalAccessException {

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(parent.findElement(By.className("product-subtotal")))));
        return parent.findElement(By.className("product-subtotal")).getText();
    }

    public QuantityField getQuantityField() {

        return quantityField;
    }
}
