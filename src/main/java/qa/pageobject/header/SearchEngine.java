package qa.pageobject.header;

import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.support.toby.ToBy;

public class SearchEngine extends BasePage {

    public SearchEngine(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "search-field-top-bar")
    WebElement field;

    @FindBy(id = "search-top-bar-submit")
    WebElement button;

    @io.qameta.allure.Step("Enter a phrase")
    @io.qase.api.annotation.Step("Enter a phrase")
    public void setPhrase(String phrase) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(field)));
        field.sendKeys(phrase);
    }

    @io.qameta.allure.Step("Click the search button")
    @io.qase.api.annotation.Step("Click the search button")
    public void clickSubmitButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(button)).click();
    }

    public String getPhrase() {

        return field.getAttribute("value");
    }
}
