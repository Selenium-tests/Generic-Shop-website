package tests.homepage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.URLs;
import qa.extentreports.ExtentReportsManager;
import qa.pageobject.mainmenu.MainMenu;
import qa.provider.MyDataProvider;
import qa.records.Link;

public class MainMenuTest extends BaseTest {

    private MainMenu mainMenu;

    @BeforeMethod
    public void create() {

        goToSpecificPage(URLs.HOME_PAGE.getName());
        mainMenu = new MainMenu(getDriver());
    }

    @Test(dataProvider = "mainMenu", dataProviderClass = MyDataProvider.class)
    public void mainMenu(Link link) throws IllegalAccessException {

        ExtentReportsManager.setName("Clicking the \"" + link.getLinkText() + "\" link in the main menu");

        mainMenu.clickLink(link.getLinkText());

        Assert.assertEquals(getDriver().getCurrentUrl(), link.getPageURL());
    }
}
