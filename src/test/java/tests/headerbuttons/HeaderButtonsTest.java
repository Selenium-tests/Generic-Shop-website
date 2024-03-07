package tests.headerbuttons;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import tests.base.BaseTest;
import qa.pageobject.header.Header;

@Epic("E2E")
@Feature("The header buttons")
public class HeaderButtonsTest extends BaseTest {

    private Header header;

    @BeforeMethod
    public void create() {

        header = new Header(getDriver());
    }

    @Test
    @QaseId(2)
    @QaseTitle("The logo")
    @Description("The logo")
    public void logo() {

        goToSpecificPage(URLs.LOGIN_PAGE.getName());
        header.clickLogo();
        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.HOME_PAGE.getName());
    }

    @Test
    @QaseId(3)
    @QaseTitle("The \"Account\" button")
    @Description("The \"Account\" button")
    public void accountButton() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
        header.clickAccountButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.LOGIN_PAGE.getName());
    }

    @Test
    @QaseId(4)
    @QaseTitle("The \"My Cart\" button")
    @Description("The \"My Cart\" button")
    public void cartButton() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
        header.clickCartButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.SHOPPING_CART.getName());
    }
}
