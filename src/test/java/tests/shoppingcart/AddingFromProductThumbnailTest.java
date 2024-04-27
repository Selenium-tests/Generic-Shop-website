package tests.shoppingcart;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.models.ProductData;
import qa.models.ThumbnailData;
import qa.dataproviders.ThumbnailsDataProviders;
import qa.support.constans.URLs;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.pageobject.thumbnails.ProductThumbnail;
import qa.support.thumbnailprovider.ProductThumbnailProvider;
import tests.base.AddingProductToShoppingCartBaseTest;

import java.util.ArrayList;
import java.util.List;

@Epic("E2E")
@Feature("Adding a product to the shopping cart")
public class AddingFromProductThumbnailTest extends AddingProductToShoppingCartBaseTest {

    private ShoppingCart shoppingCart;
    private ThumbnailData[] thumbnailData;
    private List<ProductData> productData;

    @BeforeMethod
    private void prepare() throws JsonProcessingException {

        goToPage(URLs.HOME_PAGE);
        shoppingCart = new ShoppingCart(getDriver());
        ThumbnailsDataProviders thumbnailsDataProviders = new ThumbnailsDataProviders();
        thumbnailData = (ThumbnailData[]) thumbnailsDataProviders.thumbnails();
        productData = new ArrayList<>();
    }

    private void addToCart(ThumbnailData thumbnailData) {

        ProductThumbnail productThumbnail = ProductThumbnailProvider.create(getDriver(), thumbnailData.getTycheProduct(), thumbnailData.getLink());

        productData.add(new ProductData(thumbnailData.getLink(), productThumbnail.getPrice(),"1"));
        productThumbnail.clickAddToCartButton();
        productThumbnail.waitForViewCartButton();
    }

    @Test
    @Owner("Paweł Aksman")
    @Tag("Thumbnails")
    @Tag("Shopping cart")
    @Tag("Products")
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(128)
    @QaseTitle("Adding product from a product thumbnail")
    @Description("Adding product from a product thumbnail")
    public void addingProduct() {

        for (ThumbnailData td : thumbnailData) {
            addToCart(td);
        }

        checkShoppingCartRowsCount(shoppingCart, thumbnailData.length);
        checkShoppingCartTableCells(shoppingCart, productData);
    }
}
