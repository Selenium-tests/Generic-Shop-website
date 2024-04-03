package tests.headerbuttons;

import io.qameta.allure.*;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import tests.base.BaseTest;
import qa.pageobject.header.Header;

import java.util.function.Consumer;

@Epic("E2E")
@Feature("Header")
public class HeaderButtonsTest extends BaseTest {

    private Header header;

    @BeforeMethod
    public void create() {

        header = new Header(getDriver());
    }

    private void actions(Consumer<Header> consumer, String expectedUrl) {

        consumer.accept(header);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl, "The page " + expectedUrl + " has not been opened");
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(2)
    @QaseTitle("The logo")
    @Description("The logo")
    public void logo() {

        goToPage(URLs.LOGIN_PAGE.getName());
        actions(Header::clickLogo, URLs.HOME_PAGE.getName());
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(3)
    @QaseTitle("The \"Account\" button")
    @Description("The \"Account\" button")
    public void accountButton() {

        goToPage(URLs.HOME_PAGE.getName());
        actions(Header::clickAccountButton, URLs.LOGIN_PAGE.getName());
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(4)
    @QaseTitle("The \"My Cart\" button")
    @Description("The \"My Cart\" button")
    public void cartButton() {

        goToPage(URLs.HOME_PAGE.getName());
        actions(Header::clickCartButton, URLs.SHOPPING_CART.getName());
    }
}
