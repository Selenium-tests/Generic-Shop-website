package tests.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.ProductCategory;
import qa.helpers.ShoppingCartActions;
import qa.pageobject.productpage.QuantityField;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.provider.MyDataProvider;
import qa.utils.ExtentReportsManager;
import qa.utils.Price;
import java.math.BigInteger;
import java.util.function.Consumer;


public class QuantityFieldTest extends BaseTest {

    private ShoppingCart shoppingCart;
    private int rowIndex;

    @BeforeMethod
    public void create() {

        shoppingCart = new ShoppingCart(getDriver());

        ShoppingCartActions.addToCart(getDriver(), "Manago Shirt", ProductCategory.FEATURED);
        ShoppingCartActions.openCartPage(getDriver());

        rowIndex = 0;
    }

    @Test
    public void removeProduct() {

        shoppingCart.getTable().getRow(rowIndex).clickRemoveButton();

        Assert.assertFalse(shoppingCart.hasContents());
    }

    private void check(String quantity) throws InterruptedException {

        BigInteger price = Price.toInt(shoppingCart.getTable().getRow(0).getPrice());
        BigInteger qty = new BigInteger(quantity);

        String result = Price.toString(price.multiply(qty));

        shoppingCart.getTable().getRow(rowIndex).getQuantityField().setQuantity(quantity);
        shoppingCart.clickUpdateButton();

        Thread.sleep(3000);
        //waitUntilPageIsLoaded();

        Assert.assertEquals(shoppingCart.getTable().getRow(rowIndex).getSubtotal(), result, "Incorrect subtotal");
    }

    private void validationCheck(String quantity, Consumer<QuantityField> consumer) {

        shoppingCart.getTable().getRow(rowIndex).getQuantityField().setQuantity(quantity);
        shoppingCart.clickUpdateButton();

        consumer.accept(shoppingCart.getTable().getRow(rowIndex).getQuantityField());
    }

    @Parameters({"min"})
    @Test
    public void minimumValue(String value) throws InterruptedException {

        ExtentReportsManager.create("\"" + value + "\" as the minimum value in the quantity field");

        check(value);
    }

    @Parameters({"aboveMin"})
    @Test
    public void aboveMinimum(String value) throws InterruptedException {

        ExtentReportsManager.create("\"" + value + "\" as the min + 1 value in the quantity field");

        check(value);
    }

    @Parameters({"nominal"})
    @Test
    public void nominal(String value) throws InterruptedException {

        ExtentReportsManager.create("\"" + value + "\" as the nominal value in the quantity field");

        check(value);
    }

    @Parameters({"belowMax"})
    @Test
    public void belowMaximum(String value) throws InterruptedException {

        ExtentReportsManager.create("\"" + value + "\" as the maximum - 1 value in the quantity field");

        check(value);
    }

    @Parameters({"max"})
    @Test
    public void maximum(String value) throws InterruptedException {

        ExtentReportsManager.create("\"" + value + "\" as the maximum value in the quantity field");

        check(value);
    }

    @Parameters({"belowZero"})
    @Test
    public void belowZero(String value) throws InterruptedException {

        ExtentReportsManager.create("\"" + value + "\" as the below zero value in the quantity field");

        int abs = Math.abs(Integer.parseInt(value));

        check(String.valueOf(abs));
    }

    @Parameters("aboveMax")
    @Test
    public void aboveMaximum(String value) throws InterruptedException {

        ExtentReportsManager.create("\"" + value + "\" as the maximum + 1 value in the quantity field");

        BigInteger bigInteger = new BigInteger(value);
        bigInteger = bigInteger.subtract(new BigInteger("1"));

        check(String.valueOf(bigInteger));
    }

    @Test
    public void zero() {

        ExtentReportsManager.create("Zero value in the quantity field");

        shoppingCart.getTable().getRow(rowIndex).getQuantityField().setQuantity("0");
        shoppingCart.clickUpdateButton();

        Assert.assertTrue(shoppingCart.getContentsLocator().isEmpty());
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
