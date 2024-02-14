package tests.shoppingcart;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import qa.base.BaseTest;
import qa.data.ProductData;
import qa.data.ProductToCart;
import qa.dataproviders.ProductsToCartDataProvider;
import qa.enums.URLs;
import qa.pageobject.productpage.ProductPage;
import qa.pageobject.shoppingcart.ShoppingCart;

import java.util.ArrayList;
import java.util.List;


public class AddingFromProductPageTest extends BaseTest {

    private ProductPage productPage;
    private ShoppingCart shoppingCart;
    private ProductToCart[] productsToCart;
    private List<ProductData> productData;

    @BeforeMethod
    public void create() {

        productPage = new ProductPage(getDriver());
        shoppingCart = new ShoppingCart(getDriver());
        ProductsToCartDataProvider dataProvider = new ProductsToCartDataProvider();
        productsToCart = (ProductToCart[]) dataProvider.productsToCart();
        productData = new ArrayList<>();
    }

    private void addToCart(ProductToCart data) throws IllegalAccessException {

        productData.add(new ProductData(
                productPage.getProductName(),
                productPage.getPrice(),
                data.getQuantity()
        ));

        productPage.getQuantityField().setQuantity(data.getQuantity());
        productPage.clickAddToCart();
    }

    private void checkShoppingCartRowsCount() {

        goToSpecificPage(URLs.SHOPPING_CART.getName());
        shoppingCart.getTable().findRows();

        Assert.assertEquals(shoppingCart.getTable().getRowsCount(), productsToCart.length);
    }

    private void checkShoppingCartTableCells() {

        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < shoppingCart.getTable().getRowsCount(); i++) {

            softAssert.assertEquals(shoppingCart.getTable().getRow(i).getName(), productData.get(i).getName(),
                    "Incorrect product name");
            softAssert.assertEquals(shoppingCart.getTable().getRow(i).getPrice(), productData.get(i).getPrice(),
                    "Incorrect price");
            softAssert.assertEquals(shoppingCart.getTable().getQuantityField(i).getValue(), productData.get(i).getQuantity(),
                    "Incorrect quantity");
        }

        softAssert.assertAll();
    }

    private void actions(ProductToCart data) throws IllegalAccessException {

        String baseUrl = "https://skleptest.pl/product/";
        goToSpecificPage(baseUrl + data.getUrl());
        addToCart(data);
    }

    @Test
    public void adding() throws IllegalAccessException {

        for (ProductToCart pc : productsToCart) {
            actions(pc);
        }

        checkShoppingCartRowsCount();
        checkShoppingCartTableCells();
    }
}
