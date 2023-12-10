package tests.productpage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.pageobject.productpage.ProductPage;
import qa.pageobject.productpage.QuantityField;
import qa.provider.MyDataProvider;
import qa.extentreports.ExtentReportsManager;
import java.util.function.Consumer;


public class QuantityFieldTest extends BaseTest {

    private ProductPage productPage;
    private String productName;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToSpecificPage("https://skleptest.pl/product/black-top/");
        productName = "Black Top";
        productPage = new ProductPage(getDriver());
    }

    private void check(String quantity, String expectedMessageText) throws IllegalAccessException {

        productPage.getQuantityField().setQuantity(quantity);
        productPage.clickAddToCart();

        Assert.assertTrue(productPage.isMessageVisible(), "No message displayed");
        Assert.assertEquals(productPage.getMessageText(), expectedMessageText, "Incorrect message text");
    }

    private void validationCheck(String quantity, Consumer<QuantityField> consumer) throws IllegalAccessException {

        productPage.getQuantityField().setQuantity(quantity);
        productPage.clickAddToCart();

        consumer.accept(productPage.getQuantityField());
    }

    @Test(dataProvider = "QF_min", dataProviderClass = MyDataProvider.class)
    public void minimumValue(String value) throws IllegalAccessException {

        //ExtentReportsManager.setName("{" + value + "} as the minimum value in the quantity field");

        check(value, "View cart\n" + productName + "” has been added to your cart.");
    }

    @Test(dataProvider = "QF_aboveMin", dataProviderClass = MyDataProvider.class)
    public void aboveMinimum(String value) throws IllegalAccessException {

        //ExtentReportsManager.setName("{" + value + "} as the min + 1 value in the quantity field");

        check(value, "View cart\n" + value + " × “" + productName + "” have been added to your cart.");
    }

    @Test(dataProvider = "QF_nominal", dataProviderClass = MyDataProvider.class)
    public void nominal(String value) throws IllegalAccessException {

        //ExtentReportsManager.setName("{" + value + "} as the nominal value in the quantity field");

        check(value, "View cart\n"+value + " × “" + productName + "” have been added to your cart.");
    }

    @Test(dataProvider = "QF_belowMax", dataProviderClass = MyDataProvider.class)
    public void belowMaximum(String value) throws IllegalAccessException {

        //ExtentReportsManager.setName("{" + value + "} as the maximum - 1 value in the quantity field");

        check(value, "View cart\n "+value + " × “" + productName + "” have been added to your cart.");
    }

    @Test(dataProvider = "QF_max", dataProviderClass = MyDataProvider.class)
    public void maximum(String value) throws IllegalAccessException {

        //ExtentReportsManager.setName("{" + value + "} as the maximum value in the quantity field");

        check(value, "View cart\n "+value + " × “" + productName + "” have been added to your cart.");
    }

    @Test(dataProvider = "QF_belowZero", dataProviderClass = MyDataProvider.class)
    public void belowZero(String value) throws IllegalAccessException {

       // ExtentReportsManager.setName("{" + value + "} as the below zero value in the quantity field");

        int abs = Math.abs(Integer.parseInt(value));

        check(String.valueOf(abs), "View cart\n "+value + " × “" + productName + "” have been added to your cart.");
    }

    @Test(dataProvider = "QF_aboveMax", dataProviderClass = MyDataProvider.class)
    public void aboveMaximum(String value) throws IllegalAccessException {

        ExtentReportsManager.setName("{" + value + "} as the maximum + 1 value in the quantity field");

        check(value, "Cannot add product with \"" + value + "\" quantity");
    }

    @Test(dataProvider = "QF_characters1", dataProviderClass = MyDataProvider.class)
    public void specialCharacters1(String value) throws IllegalAccessException {

        ExtentReportsManager.setName("{" + value + "} as the value in the quantity field");

        validationCheck(value,
                (QuantityField qf)->{
                    Assert.assertFalse(qf.getValidationMessage().isEmpty(), "No validation message");
                    Assert.assertEquals(qf.getValidationMessage(), "Wpisz liczbę.", "Incorrect message content");
        });
    }

    @Test(dataProvider = "QF_characters2", dataProviderClass = MyDataProvider.class)
    public void specialCharacters2(String value) throws IllegalAccessException {

        ExtentReportsManager.setName("{" + value + "} as the value in the quantity field");

        validationCheck(value,
                (QuantityField qf)->{
                    Assert.assertFalse(qf.getValidationMessage().isEmpty(), "No validation message");
                    Assert.assertTrue(qf.getValidationMessage().contains("Podaj prawidłową wartość. Dwie najbliższe prawidłowe wartości"), "Incorrect message content");
                });
    }
}
