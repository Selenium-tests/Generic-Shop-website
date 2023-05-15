package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;
import pages.components.Header;
import pages.components.ProductThumbnail;

public class AddToCartTest extends BaseTest {

    @Test
    public void addFromHomePage() {

        ProductThumbnail productThumbnail = new ProductThumbnail(getDriver());
        Header header = new Header(getDriver());
        CartPage cartPage = new CartPage(getDriver());

        final int MAX = 5;

        for (int i = 0; i < MAX; i++) {

            productThumbnail.setProduct(i);
            productThumbnail.clickAddToCart(i);

            header.clickCartButton();

            getSoftAssert().assertEquals(productThumbnail.getName(), cartPage.getProductName(i));

            back();
        }
    }

    @Test
    public void addFromProductPage() {

        Header header = new Header(getDriver());
        ProductPage productPage = new ProductPage(getDriver());
        ProductThumbnail productThumbnail = new ProductThumbnail(getDriver());
        CartPage cartPage = new CartPage(getDriver());

        final int MAX = 5;

        for (int i = 0; i < MAX; i++) {

            productThumbnail.clickToLink(i);
            productPage.clickAddToCart();
            header.clickCartButton();

            getSoftAssert().assertTrue(cartPage.cartIsNotEmpty());

            if (cartPage.cartIsNotEmpty()) {

                getSoftAssert().assertEquals(productThumbnail.getName(), cartPage.getProductName(i));
            }

            header.clickLogo();
        }

        getSoftAssert().assertAll();
    }
}
