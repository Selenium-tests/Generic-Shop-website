package tests.mainmenu;

import io.qameta.allure.*;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import qa.enums.URLs;
import qa.pageobject.mainmenu.MainMenu;

import java.util.function.Consumer;

@Epic("E2E")
@Feature("Main menu")
public class MainMenuTest extends BaseTest {

    private MainMenu mainMenu;

    @BeforeMethod
    public void create() {

        goToPage(URLs.HOME_PAGE.getName());
        mainMenu = new MainMenu(getDriver());
    }

    private void actions(Consumer<MainMenu> consumer, String expectedUrl) {

        consumer.accept(mainMenu);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl, "The page " + expectedUrl + " has not been opened");
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(9)
    @QaseTitle("The \"Shop\" link")
    @Description("The \"Shop\" link")
    public void shopLink() {

        actions(MainMenu::clickShopLink, URLs.HOME_PAGE.getName());
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(10)
    @QaseTitle("The \"Most Wanted\" link")
    @Description("The \"Most Wanted\" link")
    public void mostWantedLink() {

        actions(MainMenu::clickMostWantedLink, URLs.MOST_WANTED_PAGE.getName());
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @QaseId(11)
    @QaseTitle("The \"About Us\" link")
    @Description("The \"About Us\" link")
    public void aboutUsLink() {

        actions(MainMenu::clickAboutUsLink, URLs.ABOUT_US_PAGE.getName());
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(12)
    @QaseTitle("The \"Contact\" link")
    @Description("The \"Contact\" link")
    public void contactMenu() {

        actions(MainMenu::clickContactLink, URLs.CONTACT_PAGE.getName());
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @QaseId(13)
    @QaseTitle("The \"Blog\" link")
    @Description("The \"Blog\" link")
    public void blogLink() {

        actions(MainMenu::clickBlogLink, URLs.BLOG_PAGE.getName());
        mainMenu.clickBlogLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.BLOG_PAGE.getName());
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(14)
    @QaseTitle("The \"Categories\" link")
    @Description("The \"Categories\" link")
    public void categoriesLink() {

        actions(MainMenu::clickCategoriesLink, URLs.CATEGORIES_PAGE.getName());
    }
}
