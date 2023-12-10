package tests.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.URLs;
import qa.pageobject.header.Header;
import qa.pageobject.productpage.ProductPage;
import qa.pageobject.productpage.QuantityField;
import qa.pageobject.shoppingcart.ShoppingCart;
import qa.provider.MyDataProvider;
import qa.extentreports.ExtentReportsManager;
import qa.utils.Price;
import java.math.BigInteger;
import java.util.function.Consumer;


public class QuantityFieldTest extends BaseTest {

    private ShoppingCart shoppingCart;
    private final int rowIndex = 0;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToSpecificPage(URLs.BLACK_TOP_PRODUCT_PAGE.getName());

        ProductPage productPage = new ProductPage(getDriver());
        productPage.getQuantityField().setQuantity("1");
        productPage.clickAddToCart();

        shoppingCart = new ShoppingCart(getDriver());

        Header header = new Header(getDriver());
        header.clickCartButton();
    }

    private void check(String quantity) throws IllegalAccessException, InterruptedException {

        BigInteger price = Price.toInt(shoppingCart.getTable().getRow(0).getPrice());
        BigInteger qty = new BigInteger(quantity);

        String result = Price.toString(price.multiply(qty));

        shoppingCart.getTable().getRow(rowIndex).getQuantityField().setQuantity(quantity);
        shoppingCart.clickUpdateButton();

        Thread.sleep(1000);

        Assert.assertEquals(shoppingCart.getTable().getRow(rowIndex).getSubtotal(), result, "Incorrect subtotal");
    }

    private void validationCheck(String quantity, Consumer<QuantityField> consumer) throws IllegalAccessException {

        shoppingCart.getTable().getRow(rowIndex).getQuantityField().setQuantity(quantity);
        shoppingCart.clickUpdateButton();

        consumer.accept(shoppingCart.getTable().getRow(rowIndex).getQuantityField());
    }

    @Test(dataProvider = "QF_min", dataProviderClass = MyDataProvider.class)
    public void minimumValue(String value) throws InterruptedException, IllegalAccessException {

        ExtentReportsManager.setName("{" + value + "} as the minimum value in the quantity field");

        check(value);
    }

    @Test(dataProvider = "QF_aboveMin", dataProviderClass = MyDataProvider.class)
    public void aboveMinimum(String value) throws InterruptedException, IllegalAccessException {

        ExtentReportsManager.create("{" + value + "} as the min + 1 value in the quantity field");

        check(value);
    }

    @Test(dataProvider = "QF_nominal", dataProviderClass = MyDataProvider.class)
    public void nominal(String value) throws InterruptedException, IllegalAccessException {

        ExtentReportsManager.setName("{" + value + "} as the nominal value in the quantity field");

        check(value);
    }

    @Test(dataProvider = "QF_belowMax", dataProviderClass = MyDataProvider.class)
    public void belowMaximum(String value) throws InterruptedException, IllegalAccessException {

        ExtentReportsManager.setName("{" + value + "} as the maximum - 1 value in the quantity field");

        check(value);
    }

    @Test(dataProvider = "QF_max", dataProviderClass = MyDataProvider.class)
    public void maximum(String value) throws InterruptedException, IllegalAccessException {

        ExtentReportsManager.setName("{" + value + "} as the maximum value in the quantity field");

        check(value);
    }

    @Test(dataProvider = "QF_belowZero", dataProviderClass = MyDataProvider.class)
    public void belowZero(String value) throws InterruptedException, IllegalAccessException {

        ExtentReportsManager.setName("{" + value + "} as the below zero value in the quantity field");

        int abs = Math.abs(Integer.parseInt(value));

        check(String.valueOf(abs));
    }

    @Test(dataProvider = "QF_aboveMax", dataProviderClass = MyDataProvider.class)
    public void aboveMaximum(String value) throws InterruptedException, IllegalAccessException {

        ExtentReportsManager.setName("{" + value + "} as the maximum + 1 value in the quantity field");

        BigInteger bigInteger = new BigInteger(value);
        bigInteger = bigInteger.subtract(new BigInteger("1"));

        check(String.valueOf(bigInteger));
    }

    @Test
    public void zero() throws IllegalAccessException {

        ExtentReportsManager.setName("Zero value in the quantity field");

        shoppingCart.getTable().getRow(rowIndex).getQuantityField().setQuantity("0");
        shoppingCart.clickUpdateButton();

        Assert.assertTrue(shoppingCart.getContentsLocator().isEmpty());
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
