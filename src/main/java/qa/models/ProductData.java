package qa.models;

import lombok.Getter;

@Getter
public class ProductData {

    private final String name;
    private final String price;
    private final String quantity;

    public ProductData(String name, String price, String quantity) {

        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
