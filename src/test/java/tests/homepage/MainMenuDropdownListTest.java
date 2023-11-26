package tests.homepage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.extentreports.ExtentReportsManager;
import qa.pageobject.mainmenu.DropdownList;
import qa.provider.MyDataProvider;
import qa.records.Link;

public class MainMenuDropdownListTest extends BaseTest {

    DropdownList dropdownList;

    @BeforeMethod
    public void create() {

        dropdownList = new DropdownList(getDriver());
    }

    @Test(dataProvider = "mainMenuDropdownList", dataProviderClass = MyDataProvider.class)
    void link(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link + "\" item in the main menu drop-down list");

        dropdownList.hoveParent();
        dropdownList.clickElement(link.linkText());

        Assert.assertEquals(getDriver().getCurrentUrl(), link.pageURL());
    }
}
