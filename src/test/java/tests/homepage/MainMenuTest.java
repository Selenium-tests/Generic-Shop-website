package tests.homepage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.URLs;
import qa.pageobject.mainmenu.MainMenu;
import qa.dataproviders.DataProviders;
import qa.data.Link;

public class MainMenuTest extends BaseTest {

    private MainMenu mainMenu;

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
        mainMenu = new MainMenu(getDriver());
    }

    @Test(dataProvider = "mainMenu", dataProviderClass = DataProviders.class)
    public void mainMenu(Link link) {

        mainMenu.clickLink(link.getLinkText());

        Assert.assertEquals(getDriver().getCurrentUrl(), link.getPageURL());
    }
}
