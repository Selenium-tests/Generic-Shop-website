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
@Feature("The logo image")
public class LogoTest extends BaseTest {

    private Header header;

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.LOGIN_PAGE.getName());
        header = new Header(getDriver());
    }

    @Test
    @QaseId(2)
    @QaseTitle("Clicking the logo")
    @Description("Clicking the logo")
    public void clickingLogo() {

        header.clickLogo();
        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.HOME_PAGE.getName());
    }
}
