package pages.components;

import base.BasePage;
import enums.SiteContentSections;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SiteContentSection extends BasePage {

    private final String[] xPaths = {

            ".//div[@id='tyche_products-1']",
            ".//div[@id='tyche_products-2']",
            ".//section[@class='content-area-2']",
            ".//div[@id='tyche_products-6']",
            ".//div[@id='tyche_products-7']",
            ".//section[@class='content-area-4']"
    };

    public SiteContentSection(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = ".//div[@class='site-content']")
    WebElement siteContent;

    public void clickLink(String linkText, SiteContentSections sections) {

        siteContent.findElement(By.xpath(xPaths[sections.ordinal()])).findElement(By.linkText(linkText)).click();
    }
}
