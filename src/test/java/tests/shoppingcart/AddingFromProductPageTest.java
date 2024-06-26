package tests.shoppingcart;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
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

@Epic("E2E")
@Feature("Adding a product to the shopping cart")
public class AddingFromProductPageTest extends AddingProductToShoppingCartBaseTest {

    private ProductPage productPage;
    private ShoppingCart shoppingCart;
    private ProductToCart[] productsToCart;
    private List<ProductData> productData;

    @BeforeMethod
    public void prepare() throws JsonProcessingException {

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
    @Owner("Paweł Aksman")
    @Tag("Product page")
    @Tag("Shopping cart")
    @Tag("Products")
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(127)
    @QaseTitle("Adding product from a product page")
    @Description("Adding product from a product page")
    public void adding() throws IllegalAccessException {

        for (ProductToCart pc : productsToCart) {
            actions(pc);
        }

        checkShoppingCartRowsCount(shoppingCart, productsToCart.length);
        checkShoppingCartTableCells(shoppingCart, productData);
    }
}
