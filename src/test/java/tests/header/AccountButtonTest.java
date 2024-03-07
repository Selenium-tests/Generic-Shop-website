package tests.header;

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
@Feature("The \"Account\" button")
public class AccountButtonTest extends BaseTest {

    private Header header;

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
        header = new Header(getDriver());
    }

    @Test
    @QaseId(3)
    @QaseTitle("Clicking the \"Account\" button")
    @Description("Clicking the \"Account\" button")
    public void clickingAccountButton() {

        header.clickAccountButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.LOGIN_PAGE.getName());
    }
}
