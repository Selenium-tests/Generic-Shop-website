package tests.productpage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.ValidationMessageTest;
import qa.data.Quantity;
import qa.enums.URLs;
import qa.pageobject.productpage.ProductPage;
import qa.dataproviders.DataProviders;


public class QuantityFieldTest extends ValidationMessageTest {

    private ProductPage productPage;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToSpecificPage(URLs.BLACK_TOP_PRODUCT_PAGE.getName());
        productPage = new ProductPage(getDriver());
    }

    private void fill(String quantity) throws IllegalAccessException {

        productPage.getQuantityField().setQuantity(quantity);
    }

    private void checkMessageVisibility() {

        try {
            productPage.waitForMessage();
        } catch (Exception e) {
            Assert.fail("No message displayed");
        }
    }

    private void checkMessageContent(String expectedMessageContent) {

        Assert.assertTrue(productPage.getMessageText().contains(expectedMessageContent),
                "The message does not contain the \"" + expectedMessageContent + "\"");
    }

    private void actions(Quantity quantity) throws IllegalAccessException {

        fill(quantity.getValue());
        checkMessageVisibility();
        checkMessageContent(quantity.getMessage());
    }

    @Test(dataProvider = "QF_min", dataProviderClass = DataProviders.class)
    public void minimumValue(Quantity quantity) throws IllegalAccessException {

        actions(quantity);
    }

    @Test(dataProvider = "QF_aboveMin", dataProviderClass = DataProviders.class)
    public void aboveMinimum(Quantity quantity) throws IllegalAccessException {

        actions(quantity);
    }

    @Test(dataProvider = "QF_nominal", dataProviderClass = DataProviders.class)
    public void nominal(Quantity quantity) throws IllegalAccessException {

        actions(quantity);
    }

    @Test(dataProvider = "QF_belowMax", dataProviderClass = DataProviders.class)
    public void belowMaximum(Quantity quantity) throws IllegalAccessException {

        actions(quantity);
    }

    @Test(dataProvider = "QF_max", dataProviderClass = DataProviders.class)
    public void maximum(Quantity quantity) throws IllegalAccessException {

        actions(quantity);
    }

    @Test(dataProvider = "QF_belowZero", dataProviderClass = DataProviders.class)
    public void belowZero(Quantity quantity) throws IllegalAccessException {

        actions(quantity);
    }

    @Test(dataProvider = "QF_aboveMax", dataProviderClass = DataProviders.class)
    public void aboveMaximum(Quantity quantity) throws IllegalAccessException {

        actions(quantity);
    }

    @Test(dataProvider = "QF_characters1", dataProviderClass = DataProviders.class)
    public void specialCharacters1(String value) throws IllegalAccessException {

        fill(value);
        checkValidationMessageVisibility(productPage.getQuantityField());
        checkValidationMessageContent( productPage.getQuantityField(), "Wpisz liczbę");
    }

    @Test(dataProvider = "QF_characters2", dataProviderClass = DataProviders.class)
    public void specialCharacters2(String value) throws IllegalAccessException {

        fill(value);
        checkValidationMessageVisibility(productPage.getQuantityField());
        checkValidationMessageContent(productPage.getQuantityField(), "Podaj prawidłową wartość. Dwie najbliższe prawidłowe wartości");
    }
}
