package qa.pageobject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.tools.toby.ToBy;


public class LoginForm extends BasePage {

    public LoginForm(WebDriver driver) {

        super(driver);
    }

    @FindBy(css = ".woocommerce-form.woocommerce-form-login.login")
    WebElement contents;

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

    public void clickLoginButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isErrorMessageDisplayed() {

        return errorMessage.isDisplayed();
    }

    public void waitForContentsLocatorValidAttribute() {

        getWebDriverWait().until(
                ExpectedConditions.not(ExpectedConditions.attributeToBe(contents, "style", "display: none;"))
        );
    }
}