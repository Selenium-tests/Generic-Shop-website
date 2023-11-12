package qa.pageobject.shoppingcart;

import qa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ShoppingCart extends BasePage {

    private final Table table;

    public ShoppingCart(WebDriver driver) {

        super(driver);

        table = new Table(driver);
    }

    @FindBy(className = "woocommerce")
    protected WebElement woocommerce;

    @FindBy(name = "update_cart")
    WebElement updateButton;


    public boolean hasContents() {

        return  !(woocommerce.findElements(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']")).isEmpty());
    }

    public void clickUpdateButton() {

        updateButton.click();
    }

    public Table getTable() {

        return table;
    }
}
