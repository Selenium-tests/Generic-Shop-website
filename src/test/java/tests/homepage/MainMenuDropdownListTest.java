package tests.homepage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.URLs;
import qa.extentreports.ExtentReportsManager;
import qa.pageobject.mainmenu.DropdownList;
import qa.provider.MyDataProvider;
import qa.data.Link;

public class MainMenuDropdownListTest extends BaseTest {

    DropdownList dropdownList;

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
        dropdownList = new DropdownList(getDriver());
    }

    @Test(dataProvider = "mainMenuDropdownList", dataProviderClass = MyDataProvider.class)
    void link(Link link) throws IllegalAccessException {

        ExtentReportsManager.setName("Clicking the \"" + link + "\" item in the main menu drop-down list");

        dropdownList.hoveParent();
        dropdownList.clickElement(link.getLinkText());

        Assert.assertEquals(getDriver().getCurrentUrl(), link.getPageURL());
    }
}
