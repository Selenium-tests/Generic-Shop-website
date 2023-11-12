package qa.pageobject.shoppingcart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.base.BasePage;

public class Row extends BasePage {

    private WebElement parent;

    public Row(WebDriver driver) {

        super(driver);
    }

    public void setParent(WebElement parent) {

        this.parent = parent;
    }

    public String getName() {

        return parent.findElement(By.className("product-name")).getText();
    }

    public String getPrice() {

        return parent.findElement(By.className("product-price")).getText();
    }

    public String getSubtotal() {

        return parent.findElement(By.className("product-subtotal")).getText();
    }
}
