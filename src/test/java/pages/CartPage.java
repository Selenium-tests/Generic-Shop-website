package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    //private int elementWait = 80;
    //private String pageTitle = "Cart title";
    //private int totalAmount;

    //private List<String> productsInCart = new ArrayList<>();
    //private List<String> prices = new ArrayList<>();

    public CartPage(WebDriver driver) {

        super(driver);
    }

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

    public boolean cartIsNotEmpty() {

        return !(products.isEmpty());
    }
    public String getProductName(int index) {

        return products.get(index).getText();
    }
}
