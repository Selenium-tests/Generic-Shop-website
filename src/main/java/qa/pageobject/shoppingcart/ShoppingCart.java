package qa.pageobject.shoppingcart;

import qa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;


public class ShoppingCart extends BasePage {

    private final Table table;

    public ShoppingCart(WebDriver driver) {

        super(driver);

        table = new Table(driver);
    }

    @FindBy(xpath = "//form[@class='woocommerce-cart-form']")
    List<WebElement> contents;

    @FindBy(className = "woocommerce")
    WebElement woocommerce;

    @FindBy(name = "update_cart")
    WebElement updateButton;

    @FindBy(className = "wc-proceed-to-checkout")
    WebElement checkoutButton;


    public List<WebElement> getContentsLocator() {

        return contents;
    }

    public boolean hasContents() {

        return !(woocommerce.findElements(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']")).isEmpty());
    }

    public void clickUpdateButton() {

        updateButton.click();
    }

    public void clickCheckoutButton() {

        checkoutButton.click();
    }

    public Table getTable() {

        return table;
    }
}
