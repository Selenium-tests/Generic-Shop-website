package tests.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.SiteContentSections;
import qa.pageobject.SiteContentSection;
import qa.pageobject.header.Header;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.pageobject.thumbnails.ProductThumbnail;
import qa.utils.Price;

import java.math.BigInteger;


public class QuantityFieldTest extends BaseTest {

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

    private void check(String quantity) throws InterruptedException {

        BigInteger price = Price.toInt(shoppingCart.getTable().getRow(0).getPrice());
        BigInteger qty = new BigInteger(quantity);

        String result = Price.toString(price.multiply(qty));

        shoppingCart.getTable().getRow(0).getQuantityField().setQuantity(quantity);
        shoppingCart.clickUpdateButton();

        Thread.sleep(3000);
        //waitUntilPageIsLoaded();

        Assert.assertEquals(shoppingCart.getTable().getRow(0).getSubtotal(), result, "Incorrect subtotal");
    }

    @Parameters({"min"})
    @Test
    public void minimumValue(String value) throws InterruptedException {

        check(value);
    }

    @Parameters({"aboveMin"})
    @Test
    public void aboveMinimum(String value) throws InterruptedException {

        check(value);
    }

    @Parameters({"nominal"})
    @Test
    public void nominal(String value) throws InterruptedException {

        check(value);
    }

    @Parameters({"belowMax"})
    @Test
    public void belowMaximum() throws InterruptedException {

        check("9223372036854775806");
    }

    @Parameters({"max"})
    @Test
    public void maximum(String value) throws InterruptedException {

        check(value);
    }

    @Parameters({"belowZero"})
    @Test
    public void belowZero() {

    }

    @Test
    public void aboveMaximum() {

    }
}
