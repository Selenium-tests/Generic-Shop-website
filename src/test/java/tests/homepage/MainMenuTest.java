package tests.homepage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.extentreports.ExtentReportsManager;
import qa.pageobject.mainmenu.MainMenu;
import qa.provider.MyDataProvider;
import qa.records.Link;

public class MainMenuTest extends BaseTest {

    private MainMenu mainMenu;

    @BeforeMethod
    public void create() {

        mainMenu = new MainMenu(getDriver());
    }

    @Test(dataProvider = "mainMenu", dataProviderClass = MyDataProvider.class)
    public void mainMenu(Link link) {

        ExtentReportsManager.setName("Clicking the \"" + link.linkText() + "\" link in the main menu");

        mainMenu.clickLink(link.linkText());

        Assert.assertEquals(getDriver().getCurrentUrl(), link.pageURL());
    }
}
