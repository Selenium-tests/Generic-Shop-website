package qa.pageobject.loginform;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.support.toby.ToBy;


public class LoginForm extends BasePage {

    public LoginForm(WebDriver driver) {

        super(driver);
    }

    @FindBy(css = ".woocommerce-form.woocommerce-form-login.login")
    WebElement contents;

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(name = "login")
    WebElement loginButton;

    @FindBy(className = "woocommerce-error")
    WebElement errorMessage;

    @io.qameta.allure.Step("Enter an username or email address")
    @io.qase.api.annotation.Step("Enter an username or email address")
    public void setUsername(String username) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(usernameField))).sendKeys(username);
    }

    @io.qameta.allure.Step("Enter a password")
    @io.qase.api.annotation.Step("Enter a password")
    public void setPassword(String password) throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(ToBy.get(passwordField))).sendKeys(password);
    }

    public String getUsername() {

        return usernameField.getAttribute("value");
    }

    public String getPassword() {

        return passwordField.getAttribute("value");
    }

    @io.qameta.allure.Step("Click the \"Login\" button")
    @io.qase.api.annotation.Step("Click the \"Login\" button")
    public void clickLoginButton() {

        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void waitForErrorMessage() throws IllegalAccessException {

        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(ToBy.get(errorMessage)));
    }

    public String getErrorMessageContent() {

        return errorMessage.getText();
    }

    public void waitForContentsLocatorValidAttribute() {

        getWebDriverWait().until(
                ExpectedConditions.not(ExpectedConditions.attributeToBe(contents, "style", "display: none;"))
        );
    }
}