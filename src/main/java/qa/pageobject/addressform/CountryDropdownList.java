package qa.pageobject.addressform;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.support.toby.ToBy;

import java.util.List;

public class CountryDropdownList extends BasePage {

    public CountryDropdownList(WebDriver driver) {

        super(driver);
    }

    @FindBy(css = "input[class='select2-search__field']")
    WebElement searchField;

    @FindBy(name = "billing_country")
    WebElement selectList;

    @FindBy(className = "select2-selection__rendered")
    WebElement triggerElement;

    @FindBy(className = "select2-results__options")
    WebElement contents;

    @FindBy(className = "select2-results")
    WebElement results;

    @io.qameta.allure.Step("Click the trigger element")
    @io.qase.api.annotation.Step("Click the trigger element")
    public void clickTriggerElement() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(triggerElement)).click();
    }

    @io.qameta.allure.Step("Enter a country")
    @io.qase.api.annotation.Step("Enter a country")
    public void setCountry(String country) {

        Select select = new Select(selectList);
        select.selectByVisibleText(country);
    }

    @io.qameta.allure.Step("Enter a country")
    @io.qase.api.annotation.Step("Enter a country")
    public void typeCountry(String country) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(searchField))).sendKeys(country);
    }

    public String getCountry() {

        Select select = new Select(selectList);

        return select.getAllSelectedOptions().get(0).getText();
    }

    public String getSearchFieldContent() {

        return searchField.getAttribute("value");
    }

    public List<String> getResults() {

        return results.findElements(By.tagName("li")).stream().map(WebElement::getText).toList();
    }

    public void waitForContentsVisibility() {

        getWebDriverWait().until(ExpectedConditions.visibilityOf(contents));
    }
}
