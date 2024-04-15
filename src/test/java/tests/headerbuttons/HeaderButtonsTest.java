package tests.headerbuttons;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.support.constans.URLs;
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

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Buttons")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The logo")
    @QaseId(2)
    @QaseTitle("The logo")
    public void logo() {

        goToPage(URLs.LOGIN_PAGE);
        actions(Header::clickLogo, URLs.HOME_PAGE);
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Buttons")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"Account\" button")
    @QaseId(3)
    @QaseTitle("The \"Account\" button")
    public void accountButton() {

        goToPage(URLs.HOME_PAGE);
        actions(Header::clickAccountButton, URLs.LOGIN_PAGE);
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Buttons")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"My Cart\" button")
    @QaseId(4)
    @QaseTitle("The \"My Cart\" button")
    public void cartButton() {

        goToPage(URLs.HOME_PAGE);
        actions(Header::clickCartButton, URLs.SHOPPING_CART_PAGE);
    }
}
