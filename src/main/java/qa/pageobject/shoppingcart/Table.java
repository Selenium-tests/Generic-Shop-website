package qa.pageobject.shoppingcart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

public class Table extends BasePage {

    private final Row row;

    public Table(WebDriver driver) {

        super(driver);

        row = new Row(driver);
    }

    @FindBy(xpath = ".//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']")
    WebElement contents;


    public Row getRow(int index) {

        row.setParent(contents.findElements(By.xpath(".//tr[@class='woocommerce-cart-form__cart-item cart_item']")).get(index));

        return row;
    }
}
