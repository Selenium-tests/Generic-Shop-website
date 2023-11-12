package tests.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.SiteContentSections;
import qa.pageobject.SiteContentSection;
import qa.pageobject.productpage.ProductPage;


public class QuantityFieldTest extends BaseTest {

    private ProductPage productPage;
    private String productName;

    @BeforeMethod
    public void create() {

        productName = "Black Top";

        SiteContentSection section = new SiteContentSection(getDriver());
        section.clickLink(productName, SiteContentSections.ALL_BLACK_TOPS);

        productPage = new ProductPage(getDriver());
    }

    private void check(String quantity, String expectedMessageText) {

        productPage.getQuantityField().setQuantity(quantity);
        productPage.clickAddToCart();

        Assert.assertTrue(productPage.isMessageVisible(), "No message displayed");
        Assert.assertEquals(productPage.getMessageText(), expectedMessageText, "Incorrect message text");
    }

    @Parameters({"min"})
    @Test
    public void minimumValue(String value) {

        check(value, "View cart\n" + productName + "” has been added to your cart.");
    }

    @Parameters({"aboveMin"})
    @Test
    public void aboveMinimum(String value) throws InterruptedException {

        check(value, "View cart\n" + value + " × “" + productName + "” have been added to your cart.");
    }

    @Parameters({"nominal"})
    @Test
    public void nominal(String value) {

        check(value, "View cart\n"+value + " × “" + productName + "” have been added to your cart.");
    }

    @Parameters({"belowMax"})
    @Test
    public void belowMaximum(String value) throws InterruptedException {

        check(value, "View cart\n"+value + " × “" + productName + "” have been added to your cart.");
    }

    @Parameters({"belowMin"})
    @Test
    public void belowMinimum(String value) throws InterruptedException {

        check(value, "Cannot add product with \"" + value + "\" quantity");
    }

    @Parameters({"aboveMax"})
    @Test
    public void aboveMaximum(String value) {

        check(value, "Cannot add product with \"" + value + "\" quantity");
    }
}
