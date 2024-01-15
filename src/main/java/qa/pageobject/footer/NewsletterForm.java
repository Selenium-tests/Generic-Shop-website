package qa.pageobject.footer;

import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.tools.toby.ToBy;

public class NewsletterForm extends BasePage {

    public NewsletterForm(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "es_txt_name")
    WebElement usernameField;

    @FindBy(id = "es_txt_email")
    WebElement emailField;

    @FindBy(id = "es_txt_button")
    WebElement subscribeButton;

    @FindBy(id = "es_widget_msg")
    WebElement message;

    public void setUsername(String name) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(usernameField))).sendKeys(name);
    }

    public void setEmail(String email) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(emailField))).sendKeys(email);
    }

    public void clickSubscribeButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(subscribeButton)).click();
    }

    public void waitUntilMessageContentIs(String text) {

        getWebDriverWait().until(ExpectedConditions.textToBePresentInElement(message, text));
    }

    public String getMessageText() {

        return message.getText();
    }
}
