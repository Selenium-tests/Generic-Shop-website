package pages.components;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchEngine extends BasePage {

    public SearchEngine(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "search-field-top-bar")
    WebElement field;

    @FindBy(id = "search-top-bar-submit")
    WebElement button;

    public void setPhrase(String phrase) {

        field.sendKeys(phrase);
    }

    public void clickSubmitButton() {

        button.click();
    }

    public String getPhrase() {

        return field.getText();
    }
}
