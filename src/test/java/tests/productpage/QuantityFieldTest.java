package tests.productpage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.ProductCategory;
import qa.pageobject.SiteContentSection;
import qa.pageobject.productpage.ProductPage;
import qa.pageobject.productpage.QuantityField;
import qa.provider.MyDataProvider;
import qa.extentreports.ExtentReportsManager;

import java.util.function.Consumer;


public class QuantityFieldTest extends BaseTest {

    private ProductPage productPage;
    private String productName;

    @BeforeMethod
    public void create() {

        productName = "Black Top";

        SiteContentSection section = new SiteContentSection(getDriver());
        section.clickLink(productName, ProductCategory.ALL_BLACK_TOPS);

        productPage = new ProductPage(getDriver());
    }

    private void check(String quantity, String expectedMessageText) {

        productPage.getQuantityField().setQuantity(quantity);
        productPage.clickAddToCart();

        Assert.assertTrue(productPage.isMessageVisible(), "No message displayed");
        Assert.assertEquals(productPage.getMessageText(), expectedMessageText, "Incorrect message text");
    }

    private void validationCheck(String quantity, Consumer<QuantityField> consumer) {

        productPage.getQuantityField().setQuantity(quantity);
        productPage.clickAddToCart();

        consumer.accept(productPage.getQuantityField());
    }

    @Parameters({"min"})
    @Test
    public void minimumValue(String value) {

        ExtentReportsManager.create("\"" + value + "\" as the minimum value in the quantity field");

        check(value, "View cart\n" + productName + "” has been added to your cart.");
    }

    @Parameters({"aboveMin"})
    @Test
    public void aboveMinimum(String value) {

        ExtentReportsManager.create("\"" + value + "\" as the min + 1 value in the quantity field");

        check(value, "View cart\n" + value + " × “" + productName + "” have been added to your cart.");
    }

    @Parameters({"nominal"})
    @Test
    public void nominal(String value) {

        ExtentReportsManager.create("\"" + value + "\" as the nominal value in the quantity field");

        check(value, "View cart\n"+value + " × “" + productName + "” have been added to your cart.");
    }

    @Parameters({"belowMax"})
    @Test
    public void belowMaximum(String value) {

        ExtentReportsManager.create("\"" + value + "\" as the maximum - 1 value in the quantity field");

        check(value, "View cart\n"+value + " × “" + productName + "” have been added to your cart.");
    }

    @Parameters({"belowMin"})
    @Test
    public void belowMinimum(String value) {

        ExtentReportsManager.create("\"" + value + "\" as the minimum - 1 value in the quantity field");

        check(value, "Cannot add product with \"" + value + "\" quantity");
    }

    @Parameters({"aboveMax"})
    @Test
    public void aboveMaximum(String value) {

        ExtentReportsManager.create("\"" + value + "\" as the maximum + 1 value in the quantity field");

        check(value, "Cannot add product with \"" + value + "\" quantity");
    }

    @Test(dataProvider = "QF_characters1", dataProviderClass = MyDataProvider.class)
    public void specialCharacters1(String value) {

        ExtentReportsManager.create("\"" + value + "\" as the value in the quantity field");

        validationCheck(value,
                (QuantityField qf)->{
                    Assert.assertFalse(qf.getValidationMessage().isEmpty(), "No validation message");
                    Assert.assertEquals(qf.getValidationMessage(), "Wpisz liczbę.", "Incorrect message content");
        });
    }

    @Test(dataProvider = "QF_characters2", dataProviderClass = MyDataProvider.class)
    public void specialCharacters2(String value) {

        ExtentReportsManager.create("\"" + value + "\" as the value in the quantity field");

        validationCheck(value,
                (QuantityField qf)->{
                    Assert.assertFalse(qf.getValidationMessage().isEmpty(), "No validation message");
                    Assert.assertTrue(qf.getValidationMessage().contains("Podaj prawidłową wartość. Dwie najbliższe prawidłowe wartości"), "Incorrect message content");
                });
    }
}
