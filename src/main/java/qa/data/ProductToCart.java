package qa.data;

import lombok.Getter;

@Getter
public class ProductToCart {

    private final String url;
    private final String quantity;

    public ProductToCart(String url, String quantity) {

        this.url = url;
        this.quantity = quantity;
    }
}
