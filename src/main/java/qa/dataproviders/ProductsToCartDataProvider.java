package qa.dataproviders;

import org.testng.annotations.DataProvider;
import qa.support.modelsbuilder.ModelsBuilder;
import qa.support.constans.DataProviderNames;

public class ProductsToCartDataProvider {

    @DataProvider(name = DataProviderNames.PRODUCTS_TO_CART)
    public Object[] productsToCart() {

        return ModelsBuilder.getProductsToCart();
    }
}
