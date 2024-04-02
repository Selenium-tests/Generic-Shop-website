package tests.productpage;

import io.qameta.allure.*;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.SpecialCharactersDataProvider;
import qa.enums.URLs;
import qa.pageobject.productpage.ProductPage;
import qa.support.constans.DataProviderNames;
import tests.base.QuantityFieldBaseTest;

@Epic("E2E")
@Feature("The quantity field")
public class QuantityFieldTest extends QuantityFieldBaseTest {

    private ProductPage productPage;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToPage(URLs.BLACK_TOP_PRODUCT_PAGE.getName());
        productPage = new ProductPage(getDriver());
    }

    private void checkMessage(String expectedMessage) {

        checkMessageVisibility(ProductPage::waitForMessage, productPage);
        checkMessageContent(productPage.getMessage(), expectedMessage);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(118)
    @QaseTitle("Verification of the quantity field text input\"")
    @Description("Verification of the quantity field text input\"")
    public void inputTextVerification() {

        String quantity = "50";
        productPage.getQuantityField().setQuantity(quantity);
        Assert.assertEquals(productPage.getQuantityField().getValue(), quantity, "Incorrect the quantity field output");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(119)
    @QaseTitle("MIN - 1")
    @Description("MIN - 1")
    public void belowMin() throws IllegalAccessException {

        setBelowMin(productPage.getQuantityField());
        productPage.clickAddToCart();
        checkValidationMessageVisibility(productPage.getQuantityField());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(120)
    @QaseTitle("MIN")
    @Description("MIN")
    public void min() throws IllegalAccessException {

        setMin(productPage.getQuantityField());
        productPage.clickAddToCart();
        checkMessage("Please enter valid quantity");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(121)
    @QaseTitle("MIN + 1")
    @Description("MIN + 1")
    public void aboveMin() throws IllegalAccessException {

        setAboveMin(productPage.getQuantityField());
        productPage.clickAddToCart();
        checkMessage("Please enter valid quantity");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(122)
    @QaseTitle("MAX - 1")
    @Description("MAX - 1")
    public void belowMax() throws IllegalAccessException {

        setBelowMax(productPage.getQuantityField());
        productPage.clickAddToCart();
        checkMessage(" × “" + productPage.getProductName() + "” have been added to your cart.");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(123)
    @QaseTitle("MAX")
    @Description("MAX")
    public void max() throws IllegalAccessException {

        setMax(productPage.getQuantityField());
        productPage.clickAddToCart();
        checkMessage(" × “" + productPage.getProductName() + "” have been added to your cart.");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(124)
    @QaseTitle("MAX + 1")
    @Description("MAX + 1")
    public void aboveMax() throws IllegalAccessException {

        setAboveMax(productPage.getQuantityField());
        productPage.clickAddToCart();
        checkMessage("Please enter valid quantity");
    }

    @Test(dataProvider = DataProviderNames.SPECIAL_CHARACTERS, dataProviderClass = SpecialCharactersDataProvider.class)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(125)
    @QaseTitle("Entering a special character")
    @Description("Entering a special character")
    public void specialCharacters(String character) throws IllegalAccessException {

        productPage.getQuantityField().setQuantity(character);
        productPage.clickAddToCart();
        checkValidationMessageVisibility(productPage.getQuantityField());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(126)
    @QaseTitle("Blank the quantity field")
    @Description("Blank the quantity field")
    public void blankQuantityField() throws IllegalAccessException {

        productPage.getQuantityField().setQuantity("");
        productPage.clickAddToCart();
        checkMessage("Please enter a quantity");
    }
}
