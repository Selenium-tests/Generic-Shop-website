package qa.pageobject.mainmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

public class MainMenu extends BasePage {

    public MainMenu(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "desktop-menu")
    WebElement siteNavigation;

    public void clickLink(String id) {

        siteNavigation.findElement(By.id(id)).click();
    }
}
