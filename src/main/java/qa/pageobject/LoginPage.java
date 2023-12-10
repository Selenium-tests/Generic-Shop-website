package qa.pageobject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.tools.toby.ToBy;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = ".//input[@id='username']")
    WebElement usernameField;

    @FindBy(xpath = ".//input[@id='password']")
    WebElement passwordField;

    @FindBy(name = "login")
    WebElement loginButton;

    @FindBy(className = "woocommerce-error")
    WebElement errorMessage;

    public void setUsername(String username) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(usernameField))).sendKeys(username);
    }

    public void setPassword(String password) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(passwordField))).sendKeys(password);
    }

    public void clickLoginButton() throws IllegalAccessException {

        click(ToBy.get(loginButton));
    }

    public boolean isErrorMessageDisplayed() {

        return errorMessage.isDisplayed();
    }
}