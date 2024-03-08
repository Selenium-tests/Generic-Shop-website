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

    @FindBy(id = "menu-item-142")
    WebElement shopLink;

    @FindBy(id = "menu-item-128")
    WebElement mostWantedLink;

    @FindBy(id = "menu-item-123")
    WebElement categoriesLink;

    @FindBy(id = "menu-item-118")
    WebElement aboutUsLink;

    @FindBy(id = "menu-item-108")
    WebElement contactLink;

    @FindBy(id = "menu-item-163")
    WebElement blogLink;

    private void clickLink(WebElement element) {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    @io.qameta.allure.Step("Click the \"Shop\" link")
    @io.qase.api.annotation.Step("Click the \"Shop\" link")
    public void clickShopLink() {

        clickLink(shopLink);
    }

    @io.qameta.allure.Step("Click the \"Most Wanted\" link")
    @io.qase.api.annotation.Step("Click the \"Most Wanted\" link")
    public void clickMostWantedLink() {

        clickLink(mostWantedLink);
    }

    @io.qameta.allure.Step("Click the \"About Us\" link")
    @io.qase.api.annotation.Step("Click the \"About Us\" link")
    public void clickAboutUsLink() {

        clickLink(aboutUsLink);
    }

    @io.qameta.allure.Step("Click the \"Contact\" link")
    @io.qase.api.annotation.Step("Click the \"Contact\" link")
    public void clickContactLink() {

        clickLink(contactLink);
    }

    @io.qameta.allure.Step("Click the \"Blog\" link")
    @io.qase.api.annotation.Step("Click the \"Blog\" link")
    public void clickBlogLink() {

        clickLink(blogLink);
    }

    @io.qameta.allure.Step("Click the \"Categories\" link")
    @io.qase.api.annotation.Step("Click the \"Categories\" link")
    public void clickCategoriesLink() {

        clickLink(categoriesLink);
    }

    public void clickLink(String id) {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(siteNavigation.findElement(By.id(id)))).click();
    }
}
