package pages.components;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TagsSection extends BasePage {

    WebElement button;
    String name;
    public TagsSection(WebDriver driver) {

        super(driver);
    }

    @FindBy(className = "tagcloud")
    WebElement buttons;

    public void setTag(int index) {

        List<WebElement> links = buttons.findElements(By.className("tag-cloud-link"));
        button = links.get(index);
        name = button.getText();
    }

    public void clickTagButton() {

        button.click();
    }

    public String getName() {

        return name;
    }

    public int getSize() {

        return buttons.findElements(By.className("tag-cloud-link")).size();
    }
}
