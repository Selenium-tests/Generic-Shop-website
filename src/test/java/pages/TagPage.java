package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TagPage extends BasePage {

    public TagPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(className = "page-title")
    WebElement title;

    public String getPageTitle() {

        return title.getText();
    }
}
