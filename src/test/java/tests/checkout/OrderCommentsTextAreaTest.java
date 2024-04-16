package tests.checkout;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.support.constans.URLs;
import qa.pageobject.checkoutpage.CheckoutPage;
import qa.support.actions.ShoppingCartActions;
import tests.base.BaseTest;

@Epic("E2E")
@Feature("The order comments text area")
public class OrderCommentsTextAreaTest extends BaseTest {

    private CheckoutPage checkoutPage;
    private final String comment = "This is the comment";

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToPage(URLs.BLACK_TOP_PRODUCT_PAGE);
        ShoppingCartActions.addToCart(getDriver());
        goToPage(URLs.CHECKOUT_PAGE);
        checkoutPage = new CheckoutPage(getDriver());
    }

    @Test
    @Owner("Paweł Aksman")
    @Tag("Checkout")
    @Tag("Text area")
    @Link(name = "Home page", value = URLs.CHECKOUT_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(142)
    @QaseTitle("Verification of the order comments text area text input")
    @Description("Verification of the order comments text area text input")
    public void inputTextVerification() throws IllegalAccessException {

        Allure.parameter("Text", comment);
        checkoutPage.getOrderCommentsField().setComment(comment);

        Assert.assertEquals(checkoutPage.getOrderCommentsField().getComment(), comment,
                "Incorrect order comment");
    }
}
