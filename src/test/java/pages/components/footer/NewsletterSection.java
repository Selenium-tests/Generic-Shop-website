package pages.components.footer;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsletterSection extends BasePage {

    public NewsletterSection(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "es_txt_name")
    WebElement name;

    @FindBy(id = "es_txt_email")
    WebElement email;

    @FindBy(id = "es_txt_button")
    WebElement subscribeButton;

    @FindBy(id = "es_widget_msg")
    WebElement newsletterMessage;

    public void setName(String name) {

        this.name.sendKeys(name);
    }

    public void setEmail(String email) {

        this.email.sendKeys(email);
    }

    public void clickSubscribeButton() {

        subscribeButton.click();
    }

    public void clearAll() {

        name.clear();
        email.clear();
    }

    public boolean isNewsletterMessageDisplayed() {

        return newsletterMessage.isDisplayed();
    }
}
