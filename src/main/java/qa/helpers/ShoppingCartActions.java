package qa.helpers;

import org.openqa.selenium.WebDriver;
import qa.enums.ThumbnailType;
import qa.pageobject.thumbnails.Thumbnail;
import qa.enums.ThumbnailCategory;
import qa.pageobject.header.Header;
import qa.pageobject.thumbnails.ProductThumbnail;
import qa.thumbnailgenerators.ThumbnailProvider;

public class ShoppingCartActions {

    public static void addToCart(WebDriver driver, ThumbnailCategory category, String productName) {

        Thumbnail thumbnail = ThumbnailProvider
                .getFactory(ThumbnailType.PRODUCT)
                .createThumbnail(driver, category, productName);

        if (thumbnail instanceof ProductThumbnail) {

            ((ProductThumbnail) thumbnail).clickAddToCartButton();
        }
    }

    public static void openCartPage(WebDriver driver) {

        Header header = new Header(driver);
        header.clickCartButton();
    }
}
