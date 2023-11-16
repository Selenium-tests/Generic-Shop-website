package qa.utils;

import org.openqa.selenium.WebElement;

public class Section {

    private final WebElement webElement;
    private final String name;

    public Section(WebElement webElement, String name) {

        this.webElement = webElement;
        this.name = name;
    }

    public WebElement getWebElement() {

        return webElement;
    }

    public String getName() {

        return name;
    }
}
