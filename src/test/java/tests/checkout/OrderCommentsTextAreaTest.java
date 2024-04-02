package tests.checkout;

import io.qameta.allure.*;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.pageobject.checkoutpage.CheckoutPage;
import qa.support.actions.ShoppingCartActions;
import tests.base.BaseTest;

@Epic("E2E")
@Feature("The order comments text area")
public class OrderCommentsTextAreaTest extends BaseTest {

    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        goToPage(URLs.BLACK_TOP_PRODUCT_PAGE.getName());
        ShoppingCartActions.addToCart(getDriver());
        goToPage(URLs.CHECKOUT_PAGE.getName());
        checkoutPage = new CheckoutPage(getDriver());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(140)
    @QaseTitle("Input text verification")
    @Description("Input text verification")
    public void inputTextVerification() throws IllegalAccessException {

        String comment = "This is the comment";
        checkoutPage.getOrderCommentsField().setComment(comment);

        Assert.assertEquals(checkoutPage.getOrderCommentsField().getComment(), comment,
                "Incorrect order comment");
    }
}
