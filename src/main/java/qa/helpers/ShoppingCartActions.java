package qa.helpers;

import org.openqa.selenium.WebDriver;
import qa.enums.ProductCategory;
import qa.pageobject.SiteContentSection;
import qa.pageobject.header.Header;
import qa.pageobject.thumbnails.ProductThumbnail;

public class ShoppingCartActions {

    public static void addToCart(WebDriver driver, String productName, ProductCategory category) {

        SiteContentSection section = new SiteContentSection(driver);
        ProductThumbnail productThumbnail = section.getProductThumbnail(driver, productName, category);

        productThumbnail.clickButton();
    }

    public static void openCartPage(WebDriver driver) {

        Header header = new Header(driver);
        header.clickCartButton();
    }
}
