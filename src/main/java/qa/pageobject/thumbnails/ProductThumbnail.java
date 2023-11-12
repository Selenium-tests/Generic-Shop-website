package qa.pageobject.thumbnails;

import qa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.utils.Pair;


public class ProductThumbnail extends BasePage {

    private WebElement price;
    private WebElement button;
    private String name;

    public ProductThumbnail(WebDriver driver, Pair<WebElement, String> data) {

        super(driver);

        setLocators(data);
    }

    private void setLocators(Pair<WebElement, String> data) {

        WebElement parent = data.first().findElement(By.xpath("./..")).findElement(By.xpath("./.."));

        name = data.second();
        price = parent.findElement(By.xpath(".//span[@class='price']"));
        button = parent.findElement(By.className("ajax_add_to_cart"));
    }

    public void clickButton() {

        button.click();
    }

    public String getName() {

        return name;
    }

    public String getPrice() {

        return price.getText();
    }
}
