package qa.enums;

public enum URLs {

    HOME_PAGE("http://skleptest.pl/"),
    LOGIN_PAGE("https://skleptest.pl/my-account/"),
    BLACK_TOP_PRODUCT_PAGE("https://skleptest.pl/product/black-top/"),
    SHOPPING_CART("https://skleptest.pl/cart/"),
    CHECKOUT_PAGE("https://skleptest.pl/checkout/"),
    BILLING_ADDRESS_FORM("https://skleptest.pl/my-account/edit-address/billing/"),
    EDIT_ADDRESS_NAVIGATION("https://skleptest.pl/my-account/edit-address/"),
    ORDER_RECEIVED("https://skleptest.pl/checkout/order-received/");

    private final String name;

    URLs(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
}
