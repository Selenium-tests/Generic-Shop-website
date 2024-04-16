package tests.productpage;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.dataproviders.SpecialCharactersDataProvider;
import qa.support.constans.URLs;
import qa.pageobject.productpage.ProductPage;
import qa.support.constans.DataProviderNames;
import tests.base.QuantityFieldBaseTest;

@Epic("E2E")
@Feature("The quantity field")
public class QuantityFieldTest extends QuantityFieldBaseTest {

    private ProductPage productPage;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToPage(URLs.BLACK_TOP_PRODUCT_PAGE);
        productPage = new ProductPage(getDriver());
    }

    private void checkMessage(String expectedMessage) {

        checkMessageVisibility(ProductPage::waitForMessage, productPage);
        checkMessageContent(productPage.getMessage(), expectedMessage);
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Product page")
    @Tag("Fields")
    @Tag("Quantity fields")
    @Tag("Quantity")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.BLACK_TOP_PRODUCT_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(118)
    @QaseTitle("Verification of the quantity field text input")
    @Description("Verification of the quantity field text input")
    public void inputTextVerification() {

        String quantity = "50";
        productPage.getQuantityField().setQuantity(quantity);
        Assert.assertEquals(productPage.getQuantityField().getValue(), quantity, "Incorrect the quantity field output");
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Product page")
    @Tag("Fields")
    @Tag("Quantity fields")
    @Tag("Quantity")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.BLACK_TOP_PRODUCT_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(119)
    @QaseTitle("Quantity- shorter than minimum (min - 1)")
    @Description("Quantity- shorter than minimum (min - 1)")
    public void belowMin() throws IllegalAccessException {

        setBelowMin(productPage.getQuantityField());
        productPage.clickAddToCart();
        checkValidationMessageVisibility(productPage.getQuantityField());
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Product page")
    @Tag("Fields")
    @Tag("Quantity fields")
    @Tag("Quantity")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.BLACK_TOP_PRODUCT_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(120)
    @QaseTitle("Quantity- minimum")
    @Description("Quantity- minimum")
    public void min() throws IllegalAccessException {

        setMin(productPage.getQuantityField());
        productPage.clickAddToCart();
        checkMessage("Please enter valid quantity");
    }

    @Test(priority = 4)
    @Owner("Paweł Aksman")
    @Tag("Product page")
    @Tag("Fields")
    @Tag("Quantity fields")
    @Tag("Quantity")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.BLACK_TOP_PRODUCT_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(121)
    @QaseTitle("Quantity- exceeding minimum (min + 1)")
    @Description("Quantity- exceeding minimum (min + 1)")
    public void aboveMin() throws IllegalAccessException {

        setAboveMin(productPage.getQuantityField());
        productPage.clickAddToCart();
        checkMessage("Please enter valid quantity");
    }

    @Test(priority = 5)
    @Owner("Paweł Aksman")
    @Tag("Product page")
    @Tag("Fields")
    @Tag("Quantity fields")
    @Tag("Quantity")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.BLACK_TOP_PRODUCT_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(122)
    @QaseTitle("Quantity- shorter than maximum (max - 1)")
    @Description("Quantity- shorter than maximum (max - 1)")
    public void belowMax() throws IllegalAccessException {

        setBelowMax(productPage.getQuantityField());
        productPage.clickAddToCart();
        checkMessage(" × “" + productPage.getProductName() + "” have been added to your cart.");
    }

    @Test(priority = 6)
    @Owner("Paweł Aksman")
    @Tag("Product page")
    @Tag("Fields")
    @Tag("Quantity fields")
    @Tag("Quantity")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.BLACK_TOP_PRODUCT_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(123)
    @QaseTitle("Quantity- maximum")
    @Description("Quantity- maximum")
    public void max() throws IllegalAccessException {

        setMax(productPage.getQuantityField());
        productPage.clickAddToCart();
        checkMessage(" × “" + productPage.getProductName() + "” have been added to your cart.");
    }

    @Test(priority = 7)
    @Owner("Paweł Aksman")
    @Tag("Product page")
    @Tag("Fields")
    @Tag("Quantity fields")
    @Tag("Quantity")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.BLACK_TOP_PRODUCT_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(124)
    @QaseTitle("Quantity- exceeding maximum (max + 1)")
    @Description("Quantity- exceeding maximum (max + 1)")
    public void aboveMax() throws IllegalAccessException {

        setAboveMax(productPage.getQuantityField());
        productPage.clickAddToCart();
        checkMessage("Please enter valid quantity");
    }

    @Test(priority = 8, dataProvider = DataProviderNames.SPECIAL_CHARACTERS, dataProviderClass = SpecialCharactersDataProvider.class)
    @Owner("Paweł Aksman")
    @Tag("Product page")
    @Tag("Fields")
    @Tag("Quantity fields")
    @Tag("Quantity")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.BLACK_TOP_PRODUCT_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(125)
    @QaseTitle("Entering a special character")
    @Description("Entering a special character")
    public void specialCharacters(String character) throws IllegalAccessException {

        Allure.parameter("Character", character);
        productPage.getQuantityField().setQuantity(character);
        productPage.clickAddToCart();
        checkValidationMessageVisibility(productPage.getQuantityField());
    }

    @Test(priority = 9)
    @Owner("Paweł Aksman")
    @Tag("Product page")
    @Tag("Fields")
    @Tag("Quantity fields")
    @Tag("Quantity")
    @Tag("Boundary value analysis")
    @Link(name = "Home page", value = URLs.BLACK_TOP_PRODUCT_PAGE)
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
