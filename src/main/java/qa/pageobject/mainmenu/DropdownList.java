package qa.pageobject.mainmenu;

import org.openqa.selenium.Rectangle;
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

    @FindBy(className =  "dropdown-menu")
    WebElement parent;

    @FindBy(id = "menu-item-123")
    WebElement categoriesLink;

    @FindBy(id = "menu-item-138")
    WebElement allLink;

    @FindBy(id = "menu-item-125")
    WebElement shirtsLink;

    @FindBy(id = "menu-item-126")
    WebElement featuredLink;

    @FindBy(id = "menu-item-127")
    WebElement trendsLink;

    @FindBy(id = "menu-item-129")
    WebElement scarfsLink;

    @FindBy(id = "menu-item-130")
    WebElement shoesLink;

    @FindBy(id = "menu-item-131")
    WebElement topsLink;

    @FindBy(id = "menu-item-132")
    WebElement blouseLink;

    @FindBy(id = "menu-item-134")
    WebElement jeansLink;

    @FindBy(id = "menu-item-133")
    WebElement dressesLink;

    private void clickLink(WebElement element) {

        getWebDriverWait().until(ExpectedConditions.visibilityOf(element)).click();
    }

    public void waitForParentVisibility() {

        getWebDriverWait().until(ExpectedConditions.visibilityOf(parent));
    }

    @io.qameta.allure.Step("Hover over the \"Categories\" link")
    @io.qase.api.annotation.Step("Hover over the \"Categories\" link")
    public void hoverOverCategoriesLink() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(categoriesLink)));
        actions.moveToElement(categoriesLink).moveToElement(categoriesLink).perform();
    }

    @io.qameta.allure.Step("Leave the \"Categories\" link area")
    @io.qase.api.annotation.Step("Leave the \"Categories\" link area")
    public void leaveCategoriesLinkArea() throws IllegalAccessException {

        Rectangle rectangle = categoriesLink.getRect();
        actions.moveByOffset(rectangle.getX(), rectangle.getY() - 20).perform();
    }

    @io.qameta.allure.Step("Click the \"All\" link")
    @io.qase.api.annotation.Step("Click the \"All\" link")
    public void clickAllLink() {

        clickLink(allLink);
    }

    @io.qameta.allure.Step("Click the \"Shirts\" link")
    @io.qase.api.annotation.Step("Click the \"Shirts\" link")
    public void clickShirtsLink() {

        clickLink(shirtsLink);
    }

    @io.qameta.allure.Step("Click the \"Featured\" link")
    @io.qase.api.annotation.Step("Click the \"Featured\" link")
    public void clickFeaturedLink() {

        clickLink(featuredLink);
    }

    @io.qameta.allure.Step("Click the \"Trends\" link")
    @io.qase.api.annotation.Step("Click the \"Trends\" link")
    public void clickTrendsLink() {

        clickLink(trendsLink);
    }

    @io.qameta.allure.Step("Click the \"Scarfs\" link")
    @io.qase.api.annotation.Step("Click the \"Scarfs\" link")
    public void clickScarfsLink() {

        clickLink(scarfsLink);
    }

    @io.qameta.allure.Step("Click the \"Shoes\" link")
    @io.qase.api.annotation.Step("Click the \"Shoes\" link")
    public void clickShoesLink() {

        clickLink(shoesLink);
    }

    @io.qameta.allure.Step("Click the \"Tops\" link")
    @io.qase.api.annotation.Step("Click the \"Tops\" link")
    public void clickTopsLink() {

        clickLink(topsLink);
    }

    @io.qameta.allure.Step("Click the \"Blouse\" link")
    @io.qase.api.annotation.Step("Click the \"Blouse\" link")
    public void clickBlouseLink() {

        clickLink(blouseLink);
    }

    @io.qameta.allure.Step("Click the \"Dresses\" link")
    @io.qase.api.annotation.Step("Click the \"Dresses\" link")
    public void clickDressesLink() {

        clickLink(dressesLink);
    }

    @io.qameta.allure.Step("Click the \"Jeans\" link")
    @io.qase.api.annotation.Step("Click the \"Jeans\" link")
    public void clickJeansLink() {

        clickLink(jeansLink);
    }
}
