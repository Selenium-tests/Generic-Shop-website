package tests.slidersection;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.support.constans.URLs;
import qa.pageobject.slidersection.SliderSection;
import tests.base.BaseTest;

@Epic("E2E")
@Feature("The slider section buttons")
public class SliderSectionTest extends BaseTest {

    private SliderSection sliderSection;

    @BeforeMethod
    public void create() {

        goToPage(URLs.HOME_PAGE);
        sliderSection = new SliderSection(getDriver());
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Buttons")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @QaseId(27)
    @QaseTitle("The \"Shop Now\" button")
    @Description("The \"Shop Now\" button")
    public void shopNowButton() {

        sliderSection.clickShopNowLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.MOST_WANTED_PAGE,
                "The page \"" + URLs.MOST_WANTED_PAGE + "\" has not been opened");
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Buttons")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.MINOR)
    @QaseId(28)
    @QaseTitle("The \"Learn More\" button")
    @Description("The \"Learn More\" button")
    public void learnMoreNowButton() {

        sliderSection.clickLearnMoreLinkText();
        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.CONTACT_PAGE,
                "The page \"" + URLs.CONTACT_PAGE + "\" has not been opened");
    }
}
