package qa.pageobject;

import qa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(className = "woocommerce")
    protected WebElement woocommerce;

    @FindBy(xpath = "//td[@data-title='Product']")
    protected List<WebElement> products;

    @FindBy(xpath = "//td[@data-title='Price']")
    protected List<WebElement> price;

    @FindBy(xpath = "//a[@class='arrow-up incrementor']")
    protected List<WebElement> arrowUp;

    @FindBy(xpath = "//a[@class='arrow-up incrementor']")
    protected List<WebElement> arrowDown;

    @FindBy(xpath = "//input[@type='number']")
    protected List<WebElement> quantity;

    public void checkIfTableExists() {

        woocommerce.findElement(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']"));
    }
    public boolean cartIsNotEmpty() {

        return !(products.isEmpty());
    }

    public String getProductName() {

        return products.get(products.size() - 1).getText();
    }
}
