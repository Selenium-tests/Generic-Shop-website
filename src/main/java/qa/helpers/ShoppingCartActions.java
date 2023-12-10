package qa.helpers;

import org.openqa.selenium.WebDriver;
import qa.pageobject.productpage.ProductPage;
import qa.pageobject.header.Header;


public class ShoppingCartActions {

    public static void addToCart(WebDriver driver) throws IllegalAccessException {

        ProductPage productPage = new ProductPage(driver);
        productPage.getQuantityField().setQuantity("1");
        productPage.clickAddToCart();
    }

    public static void openCartPage(WebDriver driver) throws IllegalAccessException {

        Header header = new Header(driver);
        header.clickCartButton();
    }
}
