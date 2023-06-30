package pages.components.addressform;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.awt.*;
import java.awt.event.KeyEvent;

public class CountryDropdownList extends BasePage {

    private final Robot robot;
    public CountryDropdownList(WebDriver driver) throws AWTException {

        super(driver);

        robot = new Robot();
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
        robot.keyPress(KeyEvent.VK_ENTER);
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
