package qa.pageobject.header;

import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.tools.toby.ToBy;

public class SearchEngine extends BasePage {

    public SearchEngine(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "search-field-top-bar")
    WebElement field;

    @FindBy(id = "search-top-bar-submit")
    WebElement button;

    public void setPhrase(String phrase) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(field)));
        field.sendKeys(phrase);
    }

    public void clickSubmitButton() throws IllegalAccessException {

        button.click();
    }

    public String getPhrase() {

        return field.getText();
    }
}
