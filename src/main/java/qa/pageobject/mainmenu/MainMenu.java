package qa.pageobject.mainmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;

public class MainMenu extends BasePage {

    public MainMenu(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "desktop-menu")
    WebElement siteNavigation;

    public void clickLink(String id) {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(siteNavigation.findElement(By.id(id)))).click();
    }
}
