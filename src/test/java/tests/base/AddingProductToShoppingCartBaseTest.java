package tests.base;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import qa.models.ProductData;
import qa.enums.URLs;
import qa.pageobject.shoppingcart.ShoppingCart;

import java.util.List;

public class AddingProductToShoppingCartBaseTest extends BaseTest {

    protected void checkShoppingCartRowsCount(ShoppingCart shoppingCart, int expectedRowsCount) {

        goToSpecificPage(URLs.SHOPPING_CART.getName());
        shoppingCart.getTable().findRows();

        Assert.assertEquals(shoppingCart.getTable().getRowsCount(), expectedRowsCount);
    }
    protected void checkShoppingCartTableCells(ShoppingCart shoppingCart, List<ProductData> productData) {

        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < shoppingCart.getTable().getRowsCount(); i++) {

            softAssert.assertEquals(shoppingCart.getTable().getProductName(i), productData.get(i).getName(),
                    "Incorrect product name");
            softAssert.assertEquals(shoppingCart.getTable().getPrice(i), productData.get(i).getPrice(),
                    "Incorrect price");
            softAssert.assertEquals(shoppingCart.getTable().getQuantityField(i).getValue(), productData.get(i).getQuantity(),
                    "Incorrect quantity");
        }

        softAssert.assertAll();
    }
}
