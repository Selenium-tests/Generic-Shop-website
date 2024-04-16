package tests.mainmenu;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import qa.support.constans.URLs;
import qa.pageobject.mainmenu.DropdownList;

import java.util.function.Consumer;

@Epic("E2E")
@Feature("Main menu dropdown list links")
public class MainMenuDropdownListTest extends BaseTest {

    private DropdownList dropdownList;

    @BeforeMethod
    public void create() {

        goToPage(URLs.HOME_PAGE);
        dropdownList = new DropdownList(getDriver());
    }

    private void actions(Consumer<DropdownList> consumer, String expectedUrl) throws IllegalAccessException {

        dropdownList.hoverOverCategoriesLink();
        consumer.accept(dropdownList);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl,
                "The page \"" + expectedUrl + "\" has not been opened");
    }

    @Test(priority = 1)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(15)
    @QaseTitle("Expanding the dropdown list")
    @Description("Expanding the dropdown list")
    public void expandingDropdownList() throws IllegalAccessException {

        dropdownList.hoverOverCategoriesLink();

        try {
            dropdownList.waitForParentVisibility();
        } catch (Exception e) {
            Assert.fail("The dropdown list is not expanded");
        }
    }

    @Test(priority = 2)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(16)
    @QaseTitle("Collapsing the dropdown list")
    @Description("Collapsing the dropdown list")
    public void collapsingDropdownList() throws IllegalAccessException {

        dropdownList.hoverOverCategoriesLink();
        dropdownList.leaveCategoriesLinkArea();

        try {
            dropdownList.waitForParentVisibility();
            Assert.fail("The dropdown list is not collapsed");
        } catch (Exception ignored) {
        }
    }

    @Test(priority = 3)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"All\" link")
    @QaseId(17)
    @QaseTitle("The \"All\" link")
    public void allLink() throws IllegalAccessException {

        actions(DropdownList::clickAllLink, URLs.ALL_PAGE);
    }

    @Test(priority = 4)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"Shirts\" link")
    @QaseId(18)
    @QaseTitle("The \"Shirts\" link")
    public void shirtsLink() throws IllegalAccessException {

        actions(DropdownList::clickShirtsLink, URLs.SHIRTS_PAGE);
    }

    @Test(priority = 5)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"Featured\" link")
    @QaseId(19)
    @QaseTitle("The \"Featured\" link")
    public void featuredLink() throws IllegalAccessException {

        actions(DropdownList::clickFeaturedLink, URLs.FEATURED_PAGE);
    }

    @Test(priority = 6)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"Trends\" link")
    @QaseId(20)
    @QaseTitle("The \"Trends\" link")
    public void trendsLink() throws IllegalAccessException {

        actions(DropdownList::clickTrendsLink, URLs.TRENDS_PAGE);
    }

    @Test(priority = 7)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"Scarfs\" link")
    @QaseId(21)
    @QaseTitle("The \"Scarfs\" link")
    public void scarfsLink() throws IllegalAccessException {

        actions(DropdownList::clickScarfsLink, URLs.SCARFS_PAGE);
    }

    @Test(priority = 8)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"Shoes\" link")
    @QaseId(22)
    @QaseTitle("The \"Shoes\" link")
    public void shoesLink() throws IllegalAccessException {

        actions(DropdownList::clickShoesLink, URLs.SHOES_PAGE);
    }

    @Test(priority = 9)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"Tops\" link")
    @QaseId(23)
    @QaseTitle("The \"Tops\" link")
    public void topsLink() throws IllegalAccessException {

        actions(DropdownList::clickTopsLink, URLs.TOPS_PAGE);
    }

    @Test(priority = 10)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"Blouse\" link")
    @QaseId(24)
    @QaseTitle("The \"Blouse\" link")
    public void blouseLink() throws IllegalAccessException {

        actions(DropdownList::clickBlouseLink, URLs.BLOUSE_PAGE);
    }

    @Test(priority = 11)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"Dresses\" link")
    @QaseId(25)
    @QaseTitle("The \"Dresses\" link")
    public void dressesLink() throws IllegalAccessException {

        actions(DropdownList::clickDressesLink, URLs.DRESSES_PAGE);
    }

    @Test(priority = 12)
    @Owner("Paweł Aksman")
    @Tag("Header")
    @Tag("Main menu")
    @Tag("Dropdown list")
    @Tag("Links")
    @Link(name = "Home page", value = URLs.HOME_PAGE)
    @Severity(SeverityLevel.CRITICAL)
    @Description("The \"Jeans\" link")
    @QaseId(26)
    @QaseTitle("The \"Jeans\" link")
    public void jeansLink() throws IllegalAccessException {

        actions(DropdownList::clickJeansLink, URLs.JEANS_PAGE);
    }
}
