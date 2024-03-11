package qa.enums;

import lombok.Getter;

@Getter
public enum URLs {

    HOME_PAGE("https://skleptest.pl/"),
    LOGIN_PAGE("https://skleptest.pl/my-account/"),
    BLACK_TOP_PRODUCT_PAGE("https://skleptest.pl/product/black-top/"),
    SHOPPING_CART("https://skleptest.pl/cart/"),
    CHECKOUT_PAGE("https://skleptest.pl/checkout/"),
    MOST_WANTED_PAGE("https://skleptest.pl/product-category/most-wanted/"),
    CATEGORIES_PAGE("https://skleptest.pl/catergries/"),
    ABOUT_US_PAGE("https://skleptest.pl/about-us/"),
    CONTACT_PAGE("https://skleptest.pl/test-contact-blablabla/"),
    BLOG_PAGE("https://skleptest.pl/blog/"),
    ALL_PAGE("https://skleptest.pl/shop/"),
    SHIRTS_PAGE("https://skleptest.pl/product-category/shirts/"),
    FEATURED_PAGE("https://skleptest.pl/product-category/featured/"),
    TRENDS_PAGE("https://skleptest.pl/product-category/trends/"),
    SCARFS_PAGE("https://skleptest.pl/product-category/scarfs/"),
    SHOES_PAGE("https://skleptest.pl/product-category/shoes/"),
    TOPS_PAGE("https://skleptest.pl/product-category/tops/"),
    BLOUSE_PAGE("https://skleptest.pl/product-category/blouse/"),
    JEANS_PAGE("https://skleptest.pl/product-category/jeans/"),
    DRESSES_PAGE("https://skleptest.pl/product-category/dresses/"),
    BILLING_ADDRESS_FORM("https://skleptest.pl/my-account/edit-address/billing/"),
    EDIT_ADDRESS_NAVIGATION("https://skleptest.pl/my-account/edit-address/"),
    ORDER_RECEIVED("https://skleptest.pl/checkout/order-received/"),
    PAY_PAL("https://www.paypal.com/"),
    ORDERS_PAGE("https://skleptest.pl/my-account/orders/"),
    DASHBOARD_PAGE("https://skleptest.pl/my-account/"),
    DOWNLOADS_PAGE("https://skleptest.pl/my-account/downloads/"),
    ADDRESSES_PAGE("https://skleptest.pl/my-account/edit-address/"),
    ACCOUNT_DETAILS_PAGE("https://skleptest.pl/my-account/account-details/"),
    LOGOUT_PAGE("https://skleptest.pl/my-account/customer-logout/");

    private final String name;

    URLs(String name) {

        this.name = name;
    }

}
