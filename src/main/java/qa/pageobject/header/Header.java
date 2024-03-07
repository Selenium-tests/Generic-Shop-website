package qa.pageobject.header;

import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Header extends BasePage {

    private final SearchEngine searchEngine;

    public Header(WebDriver driver) {

        super(driver);

        searchEngine = new SearchEngine(driver);
    }

    @FindBy(className = "site-title")
    protected WebElement logo;

    @FindBy(className = "top-account")
    protected WebElement accountButton;

    @FindBy(className = "top-cart")
    protected WebElement cartButton;


    @io.qameta.allure.Step("Click the logo")
    @io.qase.api.annotation.Step("Click the logo")
    public void clickLogo() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(logo)).click();
    }


    @io.qameta.allure.Step("Click the \"My Cart\" button")
    @io.qase.api.annotation.Step("Click the \"My Cart\" button")
    public void clickCartButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(cartButton)).click();
    }

    @io.qameta.allure.Step("Click the \"Account\" button")
    @io.qase.api.annotation.Step("Click the \"Account\" button")
    public void clickAccountButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(accountButton)).click();
    }
}
