package tests.productpage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.ValidationMessageTest;
import qa.dataproviders.SpecialCharactersDataProvider;
import qa.enums.URLs;
import qa.pageobject.productpage.ProductPage;
import qa.support.dataprovidernames.DataProviderNames;

import java.math.BigInteger;


public class QuantityFieldTest extends ValidationMessageTest {

    private ProductPage productPage;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToSpecificPage(URLs.BLACK_TOP_PRODUCT_PAGE.getName());
        productPage = new ProductPage(getDriver());
    }

    private void fill(String quantity) throws IllegalAccessException {

        productPage.getQuantityField().setQuantity(quantity);
        productPage.clickAddToCart();
    }

    private void checkMessageVisibility() {

        try {
            productPage.waitForMessage();
        } catch (Exception e) {
            Assert.fail("No message displayed");
        }
    }

    private void checkMessageContent(String expectedMessageContent) {

        Assert.assertEquals(productPage.getMessageText(), expectedMessageContent,
                "The message does not contain the \"" + expectedMessageContent + "\"");
    }

    private void actions(String value, String expectedMessage) throws IllegalAccessException {

        fill(value);
        checkMessageVisibility();
        checkMessageContent(expectedMessage);
    }

    @Test
    public void belowMin() throws IllegalAccessException {

        String value = String.valueOf(Long.parseLong(productPage.getQuantityField().getMin()) - 1);
        fill(value);
        checkValidationMessageVisibility(productPage.getQuantityField());
    }

    @Test
    public void min() throws IllegalAccessException {

        actions(productPage.getQuantityField().getMin(), "Please enter valid quantity");
    }

    @Test
    public void aboveMin() throws IllegalAccessException {

        String value = String.valueOf(Long.parseLong(productPage.getQuantityField().getMin()) + 1);
        actions(value, "Please enter valid quantity");
    }

    @Test
    public void belowMax() throws IllegalAccessException {

        String value = String.valueOf(Long.MAX_VALUE - 1);
        actions(value, value + " × “" + productPage.getProductTitle() + "” have been added to your cart.");
    }

    @Test
    public void max() throws IllegalAccessException {

        String value = String.valueOf(Long.MAX_VALUE);
        actions(value, value + " × “" + productPage.getProductTitle() + "” have been added to your cart.");
    }

    @Test
    public void aboveMax() throws IllegalAccessException {

        String value = String.valueOf(BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE));
        actions(value, String.valueOf(Long.MAX_VALUE) + " × “" + productPage.getProductTitle() + "” have been added to your cart.");
    }

    @Test(dataProvider = DataProviderNames.SPECIAL_CHARACTERS, dataProviderClass = SpecialCharactersDataProvider.class)
    public void specialCharacters(String character) throws IllegalAccessException {

        fill(character);
        checkValidationMessageVisibility(productPage.getQuantityField());
    }

    @Test
    public void blankQuantityField() throws IllegalAccessException {

        actions("", "Please enter a quantity");
    }
}
