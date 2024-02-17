package tests.productpage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.SpecialCharactersDataProvider;
import qa.enums.URLs;
import qa.pageobject.productpage.ProductPage;
import qa.support.dataprovidernames.DataProviderNames;
import tests.base.QuantityFieldBaseTest;

public class QuantityFieldTest extends QuantityFieldBaseTest {

    private ProductPage productPage;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToSpecificPage(URLs.BLACK_TOP_PRODUCT_PAGE.getName());
        productPage = new ProductPage(getDriver());
    }

    private void checkMessage(String expectedMessage) {

        checkMessageVisibility(ProductPage::waitForMessage, productPage);
        checkMessageContent(productPage.getMessage(), expectedMessage);
    }

    @Test
    public void belowMin() throws IllegalAccessException {

        setBelowMin(productPage.getQuantityField());
        productPage.clickAddToCart();
        checkValidationMessageVisibility(productPage.getQuantityField());
    }

    @Test
    public void min() throws IllegalAccessException {

        setMin(productPage.getQuantityField());
        productPage.clickAddToCart();
        checkMessage("Please enter valid quantity");
    }

    @Test
    public void aboveMin() throws IllegalAccessException {

        setAboveMin(productPage.getQuantityField());
        productPage.clickAddToCart();
        checkMessage("Please enter valid quantity");
    }

    @Test
    public void belowMax() throws IllegalAccessException {

        setBelowMax(productPage.getQuantityField());
        productPage.clickAddToCart();
        checkMessage(" × “" + productPage.getProductName() + "” have been added to your cart.");
    }

    @Test
    public void max() throws IllegalAccessException {

        setMax(productPage.getQuantityField());
        productPage.clickAddToCart();
        checkMessage(" × “" + productPage.getProductName() + "” have been added to your cart.");
    }

    @Test
    public void aboveMax() throws IllegalAccessException {

        setAboveMax(productPage.getQuantityField());
        productPage.clickAddToCart();
        checkMessage("Please enter valid quantity");
    }

    @Test(dataProvider = DataProviderNames.SPECIAL_CHARACTERS, dataProviderClass = SpecialCharactersDataProvider.class)
    public void specialCharacters(String character) throws IllegalAccessException {

        productPage.getQuantityField().setQuantity(character);
        productPage.clickAddToCart();
        checkValidationMessageVisibility(productPage.getQuantityField());
    }

    @Test
    public void blankQuantityField() throws IllegalAccessException {

        productPage.getQuantityField().setQuantity("");
        productPage.clickAddToCart();
        checkMessage("Please enter a quantity");
    }
}
