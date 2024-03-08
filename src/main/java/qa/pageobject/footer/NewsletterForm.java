package qa.pageobject.footer;

import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.support.toby.ToBy;

public class NewsletterForm extends BasePage {

    public NewsletterForm(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "es_txt_name")
    WebElement nameField;

    @FindBy(id = "es_txt_email")
    WebElement emailField;

    @FindBy(id = "es_txt_button")
    WebElement subscribeButton;

    @FindBy(id = "es_widget_msg")
    WebElement message;

    @io.qameta.allure.Step("Enter a name")
    @io.qase.api.annotation.Step("Enter a name")
    public void setName(String name) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(nameField))).sendKeys(name);
    }

    @io.qameta.allure.Step("Enter an email")
    @io.qase.api.annotation.Step("Enter an email")
    public void setEmail(String email) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(emailField))).sendKeys(email);
    }

    public int getNameFieldMaxLength() {

        return Integer.parseInt(nameField.getAttribute("maxlength"));
    }

    public int getEmailFieldMaxLength() {

        return Integer.parseInt(emailField.getAttribute("maxlength"));
    }

    public String getName() {

        return nameField.getAttribute("value");
    }

    public String getEmail() {

        return emailField.getAttribute("value");
    }

    public void clickSubscribeButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(subscribeButton)).click();
    }

    public void waitUntilMessageContentIs(String text) {

        getWebDriverWait().until(ExpectedConditions.textToBePresentInElement(message, text));
    }
}
