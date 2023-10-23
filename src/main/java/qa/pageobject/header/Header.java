package qa.pageobject.header;

import qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage {

    private final SearchEngine searchEngine;
    public Header(WebDriver driver) {

        super(driver);

        searchEngine = new SearchEngine(driver);
    }

    @FindBy(xpath = "//a[@class='site-title']")
    protected WebElement logo;

    @FindBy(xpath = ".//a[@href='https://skleptest.pl/my-account/']")
    protected WebElement accountButton;

    @FindBy(className = "top-cart")
    protected WebElement cartButton;

    public void clickLogo() {

        logo.click();
    }
    public void clickCartButton() {

        cartButton.click();
    }

    public void clickAccountButton() {

        accountButton.click();
    }
}
