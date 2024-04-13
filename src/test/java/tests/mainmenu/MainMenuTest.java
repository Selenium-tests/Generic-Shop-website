package tests.mainmenu;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
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

        goToPage(URLs.HOME_PAGE);
        mainMenu = new MainMenu(getDriver());
    }

    private void actions(Consumer<MainMenu> consumer, String expectedUrl) {

        consumer.accept(mainMenu);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl, "The page " + expectedUrl + " has not been opened");
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Main menu")
    @Tag("Links")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"Shop\" link")
    @QaseId(9)
    @QaseTitle("The \"Shop\" link")
    public void shopLink() {

        actions(MainMenu::clickShopLink, URLs.HOME_PAGE);
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Main menu")
    @Tag("Links")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"Most Wanted\" link")
    @QaseId(10)
    @QaseTitle("The \"Most Wanted\" link")
    public void mostWantedLink() {

        actions(MainMenu::clickMostWantedLink, URLs.MOST_WANTED_PAGE);
    }

    @Test(priority = 5)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Main menu")
    @Tag("Links")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("The \"About Us\" link")
    @QaseId(11)
    @QaseTitle("The \"About Us\" link")
    public void aboutUsLink() {

        actions(MainMenu::clickAboutUsLink, URLs.ABOUT_US_PAGE);
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Main menu")
    @Tag("Links")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"Contact\" link")
    @QaseId(12)
    @QaseTitle("The \"Contact\" link")
    public void contactMenu() {

        actions(MainMenu::clickContactLink, URLs.CONTACT_PAGE);
    }

    @Test(priority = 6)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Main menu")
    @Tag("Links")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.NORMAL)
    @Description("The \"Blog\" link")
    @QaseId(13)
    @QaseTitle("The \"Blog\" link")
    public void blogLink() {

        actions(MainMenu::clickBlogLink, URLs.BLOG_PAGE);
        mainMenu.clickBlogLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), URLs.BLOG_PAGE);
    }

    @Test(priority = 4)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Main menu")
    @Tag("Links")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"Categories\" link")
    @QaseId(14)
    @QaseTitle("The \"Categories\" link")
    public void categoriesLink() {

        actions(MainMenu::clickCategoriesLink, URLs.CATEGORIES_PAGE);
    }
}
