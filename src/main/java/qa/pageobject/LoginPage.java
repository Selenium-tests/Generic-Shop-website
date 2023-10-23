package qa.pageobject;
import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = ".//input[@id='username']")
    WebElement username;

    @FindBy(xpath = ".//input[@id='password']")
    WebElement password;

    @FindBy(name = "login")
    WebElement login;

    @FindBy(className = "woocommerce-error")
    WebElement errorMessage;

    public void setUsername(String username) {

        this.username.sendKeys(username);
    }

    public void setPassword(String password) {

        this.password.sendKeys(password);
    }

    public void clickLoginButton() {

        login.click();
    }

    public boolean isErrorMessageDisplayed() {

        return errorMessage.isDisplayed();
    }

    public void clearAll() {

        username.clear();
        password.clear();
    }
}