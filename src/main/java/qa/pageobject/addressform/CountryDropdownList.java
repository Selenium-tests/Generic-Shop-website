package qa.pageobject.addressform;

import qa.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CountryDropdownList extends BasePage {

    public CountryDropdownList(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//input[@class='select2-search__field']")
    WebElement searchField;

    @FindBy(className = "select2-selection__rendered")
    WebElement countryButton;

    @FindBy(xpath = "//li[@role='alert']")
    List<WebElement> alert;

    public void clickCountryButton() {

        countryButton.click();
    }

    public void setCountry(String countryName) {

        searchField.sendKeys(countryName);
    }

    public void pressEnter() {

        searchField.sendKeys(Keys.ENTER);
    }

    public String getCountry() {

        return countryButton.getText();
    }

    public boolean isAlertDisplayed() {

        if (!alert.isEmpty()) {

            return alert.get(0).isDisplayed();
        }

        return false;
    }
}
