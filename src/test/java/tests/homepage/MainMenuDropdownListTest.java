package tests.homepage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.URLs;
import qa.pageobject.mainmenu.DropdownList;
import qa.dataproviders.DataProviders;
import qa.data.Link;

public class MainMenuDropdownListTest extends BaseTest {

    DropdownList dropdownList;

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
        dropdownList = new DropdownList(getDriver());
    }

    @Test(dataProvider = "mainMenuDropdownList", dataProviderClass = DataProviders.class)
    void link(Link link) throws IllegalAccessException {

        dropdownList.hoverParent();
        dropdownList.clickElement(link.getLinkText());

        Assert.assertEquals(getDriver().getCurrentUrl(), link.getPageURL());
    }
}
