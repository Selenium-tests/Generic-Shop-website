package qa.dataproviders;

import org.testng.annotations.DataProvider;
import qa.jsonreader.ModelsBuilder;
import qa.support.dataprovidernames.DataProviderNames;

public class ProductsToCartDataProvider {

    @DataProvider(name = DataProviderNames.PRODUCTS_TO_CART)
    public Object[] productsToCart() {

        return ModelsBuilder.getProductsToCart();
    }
}
