package qa.pageobject.footer;

import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void setName(String name) {

        this.nameField.sendKeys(name);
    }

    public void setEmail(String email) {

        this.emailField.sendKeys(email);
    }

    public void clickSubscribeButton() {

        subscribeButton.click();
    }

    public void clearAll() {

        nameField.clear();
        emailField.clear();
    }

    public boolean isMessageDisplayed() {

        return message.isDisplayed();
    }

    public String getMessageText() {

        return message.getText();
    }
}
