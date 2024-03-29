package tests.shoppingcart;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.models.ProductData;
import qa.models.ProductToCart;
import qa.dataproviders.ProductsToCartDataProvider;
import qa.pageobject.productpage.ProductPage;
import qa.pageobject.shoppingcart.ShoppingCart;
import tests.base.AddingProductToShoppingCartBaseTest;

import java.util.ArrayList;
import java.util.List;


public class AddingFromProductPageTest extends AddingProductToShoppingCartBaseTest {

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

        productData.add(new ProductData(productPage.getProductName(), productPage.getPrice(), data.getQuantity()));
        productPage.getQuantityField().setQuantity(data.getQuantity());
        productPage.clickAddToCart();
    }

    private void actions(ProductToCart data) throws IllegalAccessException {

        String baseUrl = "https://skleptest.pl/product/";
        goToPage(baseUrl + data.getUrl());
        addToCart(data);
    }

    @Test
    public void adding() throws IllegalAccessException {

        for (ProductToCart pc : productsToCart) {
            actions(pc);
        }

        checkShoppingCartRowsCount(shoppingCart, productsToCart.length);
        checkShoppingCartTableCells(shoppingCart, productData);
    }
}
