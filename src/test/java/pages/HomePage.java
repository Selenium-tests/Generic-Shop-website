package pages;

import base.BasePage;
import pages.components.Header;
import pages.components.Footer;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final Header header;
    private final Footer footer;

    HomePage(WebDriver driver) {

        super(driver);

        header = new Header(driver);
        footer = new Footer(driver);
    }

    public Header getHeader() {

        return header;
    }

    public Footer getFooter() {

        return footer;
    }
}

