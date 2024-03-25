package qa.pageobject.slidersection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

public class SliderSection extends BasePage {

    private final String XPATH = ".//a[@href]";
    private final int SHOP_NOW_LINK = 0;
    private final int LEARN_MORE_LINK = 1;

    public SliderSection(WebDriver driver) {

        super(driver);
    }

    @FindBy(className = "btn-group")
    WebElement buttonGroup;

    private void clickButton(int index) {

        WebElement element = buttonGroup.findElements(By.xpath(XPATH)).get(index);
        getJavascriptExecutor().executeScript("arguments[0].click();", element);
    }

    @io.qameta.allure.Step("Click the \"Shop Now\" button")
    @io.qase.api.annotation.Step("Click the \"Shop Now\" button")
    public void clickShopNowLink() {

        clickButton(SHOP_NOW_LINK);
    }

    @io.qameta.allure.Step("Click the \"Learn More\" button")
    @io.qase.api.annotation.Step("Click the \"Learn More\" button")
    public void clickLearnMoreLinkText() {

        clickButton(LEARN_MORE_LINK);
    }
}
