package qa.helpers;

import org.openqa.selenium.WebDriver;
import qa.pageobject.productpage.ProductPage;


public class ShoppingCartActions {

    public static void addToCart(WebDriver driver) throws IllegalAccessException {

        ProductPage productPage = new ProductPage(driver);
        productPage.getQuantityField().setQuantity("1");
        productPage.clickAddToCart();
    }
}
