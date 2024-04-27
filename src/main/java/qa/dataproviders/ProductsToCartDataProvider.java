package qa.dataproviders;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.DataProvider;
import qa.support.modelsbuilder.ModelsBuilder;
import qa.support.constans.DataProviderNames;

public class ProductsToCartDataProvider {

    @DataProvider(name = DataProviderNames.PRODUCTS_TO_CART)
    public Object[] productsToCart() throws JsonProcessingException {

        return ModelsBuilder.getProductsToCart();
    }
}
