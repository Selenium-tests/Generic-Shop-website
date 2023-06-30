package pages.components.footer;

import base.BasePage;
import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RecentPostsSection extends BasePage {

    WebElement link;
    String name;
    public RecentPostsSection(WebDriver driver) {

        super(driver);
    }

    @FindBy(className = "tyche-recent-posts")
    List<WebElement> buttons;

    public void setRecentPost(int index) {

        link = buttons.get(index).findElement(By.xpath(".//a[@href]"));
        name = link.getText();
    }

    public void clickRecentButton() {

        link.click();
    }

    public String getName() {

        return name;
    }

    public int getSize() {

        return buttons.size();
    }
}
