package pages.components;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.List;


public class AddressForm extends BasePage {

    private final CountryDropdownList countryDropdownList;
    public AddressForm(WebDriver driver) throws AWTException {

        super(driver);

        countryDropdownList = new CountryDropdownList(driver);
    }

    @FindBy(className = "input-text")
    List<WebElement> inputs;

    @FindBy(className = "button")
    WebElement button;

    @FindBy(xpath = "//ul[@class='woocommerce-error']")
    List<WebElement> errorMessage;

    public CountryDropdownList getCountryDropdownList() {

        return countryDropdownList;
    }

    public void setData(int index, String data) {

        inputs.get(index).clear();
        inputs.get(index).sendKeys(data);
    }

    public String getData(int index) {

        return inputs.get(index).getAttribute("value");
    }

    public void clickButton() {

        button.click();
    }

    public boolean isErrorMessageDisplayed() {

        if (!errorMessage.isEmpty()) {

            return errorMessage.get(0).isDisplayed();
        }

        return false;
    }
}
