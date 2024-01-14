package qa.pageobject.addressform;

import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.tools.toby.ToBy;

import java.util.List;

public class CountryDropdownList extends BasePage {

    public CountryDropdownList(WebDriver driver) {

        super(driver);
    }

    @FindBy(css = "input[class='select2-search__field']")
    WebElement searchField;

    @FindBy(className = "select2-selection__rendered")
    WebElement countryButton;

    @FindBy(css = "li[role='alert']")
    List<WebElement> alert;

    public void clickCountryButton() {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(countryButton)).click();
    }

    public void setCountry(String countryName) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(searchField))).sendKeys(countryName);
    }

    public void pressEnter() {

        searchField.sendKeys(Keys.ENTER);
    }

    public boolean isAlertDisplayed() throws IllegalAccessException {

        return !alert.isEmpty();
    }
}
