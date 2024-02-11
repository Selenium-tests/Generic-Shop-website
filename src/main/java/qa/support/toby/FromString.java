package qa.support.toby;

import org.openqa.selenium.By;

public class FromString {

    public static By get(String locator) {

        String[] split = locator.split(": ");

        if (split.length != 2) {

            throw new IllegalStateException(String.format("The %s does not have 2 elements", locator));
        }

        String using = split[0];
        String value = split[1];

        if (using.equals("xpath")) {

            value = value.substring(0, value.length() - 3);
        }

        switch (using) {

            case "By.xpath", "xpath" -> {
                return By.xpath(value);
            }
            case "By.cssSelector", "css selector" -> {
                return By.cssSelector(value);
            }
            case "By.id", "id" -> {
                return By.id(value);
            }
            case "By.linkText", "link text" -> {
                return By.linkText(value);
            }
            case "By.partialLinkText" -> {
                return By.partialLinkText(value);
            }
            case "By.name", "name" -> {
                return By.name(value);
            }
            case "By.tagName", "tag name" -> {
                return By.tagName(value);
            }
            case "By.className", "class name" -> {
                return By.className(value);
            }
            default -> {
                throw new IllegalStateException("Cannot define locator for WebElement definition " + locator);
            }
        }
    }
}
