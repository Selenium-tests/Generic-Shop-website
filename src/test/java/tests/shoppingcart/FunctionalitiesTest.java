package tests.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.SiteContentSections;
import qa.pageobject.SiteContentSection;
import qa.pageobject.header.Header;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.pageobject.thumbnails.ProductThumbnail;

public class FunctionalitiesTest extends BaseTest {

    private ShoppingCart shoppingCart;

    @BeforeMethod
    public void create() {

        shoppingCart = new ShoppingCart(getDriver());
        SiteContentSection section = new SiteContentSection(getDriver());
        ProductThumbnail productThumbnail = section.getProductThumbnail(getDriver(), "Manago Shirt", SiteContentSections.FEATURED);

        productThumbnail.clickButton();

        Header header = new Header(getDriver());
        header.clickCartButton();
    }

    @Test
    public void removeProduct() {

        shoppingCart.getTable().getRow(0).clickRemoveButton();

        Assert.assertFalse(shoppingCart.hasContents());
    }

    @Test
    public void changingQuantity() {

        shoppingCart.getTable().getRow(0).getQuantityField().setQuantity("10");
    }
}
