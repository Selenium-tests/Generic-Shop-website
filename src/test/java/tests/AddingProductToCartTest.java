package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;
import pages.components.header.Header;
import pages.components.thumbnails.ProductThumbnail;
import utils.ExtentReportsManager;

public class AddingProductToCartTest extends BaseTest {

    private Header header;
    private ProductThumbnail productThumbnail;
    private CartPage cartPage;

    @BeforeClass
    private void init() {

        header = new Header(getDriver());
        productThumbnail = new ProductThumbnail(getDriver());
        cartPage = new CartPage(getDriver());
    }

    @Test(priority = 1)
    public void fromHomePage() {

        ExtentReportsManager.setName("Adding product from the home page");

        final int MAX = 5;

        for (int i = 0; i < MAX; i++) {

            productThumbnail.setProduct(i);
            productThumbnail.setPrice(i);
            productThumbnail.clickAddToCart(i);
            header.clickCartButton();

            Assert.assertTrue(cartPage.cartIsNotEmpty());
            Assert.assertEquals(productThumbnail.getName(), cartPage.getLastProductName(i));

            back();
        }
    }

    @Test(priority = 2)
    public void fromProductPage() {

        ExtentReportsManager.setName("Adding product from a product page");
        ProductPage productPage = new ProductPage(getDriver());

        final int BEGIN = 15;
        final int END = 20;

        for (int i = BEGIN; i < END; i++) {

            productThumbnail.setProduct(i);
            productThumbnail.clickToLink(i);
            productPage.clickAddToCart();
            header.clickCartButton();

            Assert.assertTrue(cartPage.cartIsNotEmpty());
            Assert.assertEquals(productThumbnail.getName(), cartPage.getLastProductName(i));

            header.clickLogo();
        }
    }
}
