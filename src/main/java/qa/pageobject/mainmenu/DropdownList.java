package qa.pageobject.mainmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.support.toby.ToBy;

public class DropdownList extends BasePage {

    private final Actions actions;

    public DropdownList(WebDriver driver) {

        super(driver);

        actions = new Actions(driver);
    }

    @FindBy(id = "menu-item-123")
    WebElement parent;

    public void hoverParent() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(parent)));
        actions.moveToElement(parent).moveToElement(parent).perform();
    }

    public void clickElement(String id) {

        getWebDriverWait().until(ExpectedConditions.visibilityOf(parent.findElement(By.id(id)))).click();
    }

}
