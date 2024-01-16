package qa.data;

import lombok.Getter;

@Getter
public class Quantity {

    private final String value;
    private final String message;

    public Quantity(String value, String message) {

        this.value = value;
        this.message = message;
    }
}
