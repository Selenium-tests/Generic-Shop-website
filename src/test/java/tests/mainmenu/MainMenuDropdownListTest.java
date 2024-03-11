package tests.mainmenu;

import io.qameta.allure.*;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import qa.enums.URLs;
import qa.pageobject.mainmenu.DropdownList;

import java.util.function.Consumer;

@Epic("E2E")
@Feature("Dropdown list")
public class MainMenuDropdownListTest extends BaseTest {

    private DropdownList dropdownList;

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
        dropdownList = new DropdownList(getDriver());
    }

    private void actions(Consumer<DropdownList> consumer, String expectedUrl) throws IllegalAccessException {

        dropdownList.hoverOverCategoriesLink();
        consumer.accept(dropdownList);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl,
                "The page \"" + expectedUrl + "\" has not been opened");
    }

    @Test(priority = 1)
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
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(17)
    @QaseTitle("The \"All\" link")
    @Description("The \"All\" link")
    public void allLink() throws IllegalAccessException {

        actions(DropdownList::clickAllLink, URLs.ALL_PAGE.getName());
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(18)
    @QaseTitle("The \"Shirts\" link")
    @Description("The \"Shirts\" link")
    public void shirtsLink() throws IllegalAccessException {

        actions(DropdownList::clickShirtsLink, URLs.SHIRTS_PAGE.getName());
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(19)
    @QaseTitle("The \"Featured\" link")
    @Description("The \"Featured\" link")
    public void featuredLink() throws IllegalAccessException {

        actions(DropdownList::clickFeaturedLink, URLs.FEATURED_PAGE.getName());
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(20)
    @QaseTitle("The \"Trends\" link")
    @Description("The \"Trends\" link")
    public void trendsLink() throws IllegalAccessException {

        actions(DropdownList::clickTrendsLink, URLs.TRENDS_PAGE.getName());
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(21)
    @QaseTitle("The \"Scarfs\" link")
    @Description("The \"Scarfs\" link")
    public void scarfsLink() throws IllegalAccessException {

        actions(DropdownList::clickScarfsLink, URLs.SCARFS_PAGE.getName());
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(22)
    @QaseTitle("The \"Shoes\" link")
    @Description("The \"Shoes\" link")
    public void shoesLink() throws IllegalAccessException {

        actions(DropdownList::clickShoesLink, URLs.SHOES_PAGE.getName());
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(23)
    @QaseTitle("The \"Tops\" link")
    @Description("The \"Tops\" link")
    public void topsLink() throws IllegalAccessException {

        actions(DropdownList::clickTopsLink, URLs.TOPS_PAGE.getName());
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(24)
    @QaseTitle("The \"Blouse\" link")
    @Description("The \"Blouse\" link")
    public void blouseLink() throws IllegalAccessException {

        actions(DropdownList::clickBlouseLink, URLs.BLOUSE_PAGE.getName());
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(25)
    @QaseTitle("The \"Dresses\" link")
    @Description("The \"Dresses\" link")
    public void dressesLink() throws IllegalAccessException {

        actions(DropdownList::clickDressesLink, URLs.DRESSES_PAGE.getName());
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.CRITICAL)
    @QaseId(26)
    @QaseTitle("The \"Jeans\" link")
    @Description("The \"Jeans\" link")
    public void jeansLink() throws IllegalAccessException {

        actions(DropdownList::clickJeansLink, URLs.JEANS_PAGE.getName());
    }
}
