package tests.homepage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.dataproviders.LinksDataProviders;
import qa.enums.URLs;
import qa.pageobject.mainmenu.MainMenu;
import qa.data.LinkData;
import qa.support.dataprovidernames.DataProviderNames;

public class MainMenuTest extends BaseTest {

    private MainMenu mainMenu;

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
        mainMenu = new MainMenu(getDriver());
    }

    @Test(dataProvider = DataProviderNames.MAIN_MENU, dataProviderClass = LinksDataProviders.class)
    public void mainMenu(LinkData linkData) {

        mainMenu.clickLink(linkData.getLink());

        Assert.assertEquals(getDriver().getCurrentUrl(), linkData.getUrl());
    }
}
