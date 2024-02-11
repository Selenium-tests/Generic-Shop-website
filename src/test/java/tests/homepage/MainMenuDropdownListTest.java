package tests.homepage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.dataproviders.LinksDataProviders;
import qa.enums.URLs;
import qa.pageobject.mainmenu.DropdownList;
import qa.data.LinkData;
import qa.support.dataprovidernames.DataProviderNames;

public class MainMenuDropdownListTest extends BaseTest {

    DropdownList dropdownList;

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
        dropdownList = new DropdownList(getDriver());
    }

    @Test(dataProvider = DataProviderNames.MAIN_MENU_DROPDOWN_LIST, dataProviderClass = LinksDataProviders.class)
    void link(LinkData linkData) throws IllegalAccessException {

        dropdownList.hoverParent();
        dropdownList.clickElement(linkData.getLink());

        Assert.assertEquals(getDriver().getCurrentUrl(), linkData.getUrl());
    }
}
