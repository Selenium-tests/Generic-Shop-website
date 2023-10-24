package qa.pageobject.header;

import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultsPage extends BasePage {

    public ResultsPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(className = "page-header")
    WebElement pageHeader;

    @FindBy(className = "title")
    List<WebElement> headers;

    public int resultsSize() {

        return headers.size();
    }
    public String getResult(int index) {

        return headers.get(index).getText();
    }

    public boolean hasNoResults() {

        return headers.isEmpty();
    }
}
