package tests.shoppingcart;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.data.ProductData;
import qa.data.ThumbnailData;
import qa.dataproviders.ThumbnailsDataProviders;
import qa.enums.URLs;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.pageobject.thumbnails.ProductThumbnail;
import qa.thumbnailgenerators.ProductThumbnailProvider;
import tests.base.AddingProductToShoppingCartBaseTest;

import java.util.ArrayList;
import java.util.List;

public class AddingFromProductThumbnailTest extends AddingProductToShoppingCartBaseTest {

    private ShoppingCart shoppingCart;
    private ThumbnailData[] thumbnailData;
    private List<ProductData> productData;

    @BeforeMethod
    private void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
        shoppingCart = new ShoppingCart(getDriver());
        ThumbnailsDataProviders thumbnailsDataProviders = new ThumbnailsDataProviders();
        thumbnailData = (ThumbnailData[]) thumbnailsDataProviders.thumbnails();
        productData = new ArrayList<>();
    }

    private void addToCart(ThumbnailData thumbnailData) throws IllegalAccessException {

        ProductThumbnail productThumbnail = ProductThumbnailProvider.create(getDriver(), thumbnailData.getTycheProduct(), thumbnailData.getLink());

        productData.add(new ProductData(thumbnailData.getLink(), productThumbnail.getPrice(),"1"));
        productThumbnail.clickAddToCartButton();
        productThumbnail.waitForViewCartButton();
    }

    @Test
    public void adding() throws IllegalAccessException {

        for (ThumbnailData td : thumbnailData) {
            addToCart(td);
        }

        checkShoppingCartRowsCount(shoppingCart, thumbnailData.length);
        checkShoppingCartTableCells(shoppingCart, productData);
    }
}
