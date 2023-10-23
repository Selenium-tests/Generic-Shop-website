package qa.pageobject;

import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogPage extends BasePage {

    public BlogPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(className = "entry-title")
    WebElement blogTitle;

    public String getBlogTitle() {

        return blogTitle.getText();
    }

}
