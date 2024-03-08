package tests.mainmenu;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import qa.enums.URLs;
import qa.pageobject.mainmenu.MainMenu;

@Epic("E2E")
@Feature("Main menu")
public class MainMenuTest extends BaseTest {

    private MainMenu mainMenu;

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
        mainMenu = new MainMenu(getDriver());
    }

    @Test
    @QaseId(9)
    @QaseTitle("The \"Shop\" link")
    @Description("The \"Shop\" link")
    public void shopLink() {

        mainMenu.clickShopLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.HOME_PAGE.getName());
    }

    @Test
    @QaseId(10)
    @QaseTitle("The \"Most Wanted\" link")
    @Description("The \"Most Wanted\" link")
    public void mostWantedLink() {

        mainMenu.clickMostWantedLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.MOST_WANTED_PAGE.getName());
    }

    @Test
    @QaseId(11)
    @QaseTitle("The \"About Us\" link")
    @Description("The \"About Us\" link")
    public void aboutUsLink() {

        mainMenu.clickAboutUsLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.ABOUT_US_PAGE.getName());
    }

    @Test
    @QaseId(12)
    @QaseTitle("The \"Contact\" link")
    @Description("The \"Contact\" link")
    public void contactMenu() {

        mainMenu.clickContactLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.CONTACT_PAGE.getName());
    }

    @Test
    @QaseId(13)
    @QaseTitle("The \"Blog\" link")
    @Description("The \"Blog\" link")
    public void blogLink() {

        mainMenu.clickBlogLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.BLOG_LINK.getName());
    }
}
