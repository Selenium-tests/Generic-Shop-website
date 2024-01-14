package qa.pageobject.checkoutpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import qa.tools.toby.ToBy;

public class OrderCommentsField extends BasePage {
    protected OrderCommentsField(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "order_comments")
    WebElement field;

    public void setComment(String comment) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(field))).sendKeys(comment);
    }

    public String getComment() {

        return field.getAttribute("value");
    }
}
