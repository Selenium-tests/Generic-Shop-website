package tests.slidersection;

import io.qameta.allure.*;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.enums.URLs;
import qa.slidersection.SliderSection;
import tests.base.BaseTest;

@Epic("E2E")
@Feature("The slider section buttons")
public class SliderSectionTest extends BaseTest {

    private SliderSection sliderSection;

    @BeforeMethod
    public void create() {

        goToPage(URLs.HOME_PAGE.getName());
        sliderSection = new SliderSection(getDriver());
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(27)
    @QaseTitle("The \"Shop Now\" button")
    @Description("The \"Shop Now\" button")
    public void shopNowButton() {

        sliderSection.clickShopNowLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.MOST_WANTED_PAGE.getName(),
                "The page \"" + URLs.MOST_WANTED_PAGE.getName() + "\" has not been opened");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(28)
    @QaseTitle("The \"Learn More\" button")
    @Description("The \"Learn More\" button")
    public void learnMoreNowButton() {

        sliderSection.clickLearnMoreLinkText();
        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.CONTACT_PAGE.getName(),
                "The page \"" + URLs.CONTACT_PAGE.getName() + "\" has not been opened");
    }
}
