package qa.pageobject.header;

import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {


    public SearchResultsPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(css = "article[id]")
    List<WebElement> articles;


    public int getNumberOfArticles() {

        return articles.size();
    }
}
