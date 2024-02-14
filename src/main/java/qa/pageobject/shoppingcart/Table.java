package qa.pageobject.shoppingcart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;
import qa.quantityfield.QuantityField;

import java.util.List;

public class Table extends BasePage {

    private final String rowSelector;
    private List<WebElement> rows;
    private final Row row;

    public Table(WebDriver driver) {

        super(driver);

        rowSelector = ".woocommerce-cart-form__cart-item.cart_item";
        row = new Row(driver);
    }

    @FindBy(css = "table.shop_table.shop_table_responsive.cart.woocommerce-cart-form__contents")
    WebElement contents;

    public void findRows() {

        rows = contents.findElements(By.cssSelector(rowSelector));
    }

    public int getRowsCount() {

        return rows.size();
    }

    public String getProductName(int row) {

        return rows.get(row).findElement(By.className("product-name")).getText();
    }

    public String getPrice(int row) {

        return rows.get(row).findElement(By.className("product-price")).getText();
    }

    public String getTotal(int row) {

        return rows.get(row).findElement(By.className("product-subtotal")).getText();
    }

    public QuantityField getQuantityField(int row) {

        return new QuantityField(getDriver(), rows.get(row));
    }

    public Row getRow(int index) {

        row.setParent(contents.findElements(By.xpath(".//tr[@class='woocommerce-cart-form__cart-item cart_item']")).get(index));

        return row;
    }
}
