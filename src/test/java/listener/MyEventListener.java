package listener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.WebElement;
import java.util.Arrays;
import java.util.List;

public class MyEventListener implements WebDriverListener {

    @Override
    public void beforePerform(WebDriver driver, java.util.Collection<Sequence> actions) {

        System.out.println("###### Before perform ######" +
                           "\n#### URL: " + driver.getCurrentUrl() +
                           "\n#### actions:");

        actions.forEach(a->System.out.println("#### Action: " + a.toString() + " ####"));
        System.out.println("#######################");
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {

        System.out.println("###### Before find element ######" +
                "\n#### Title: " + driver.getTitle() +
                "\n#### URL: " + driver.getCurrentUrl() +
                "\n#### Locator: " + locator.toString() +
                "\n#########");
    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {

        System.out.println("###### Before find elements ######" +
                "\n#### Title: " + driver.getTitle() +
                "\n#### URL: " + driver.getCurrentUrl() +
                "\n#### Locator: " + locator.toString() +
                "\n#########");
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {

        System.out.println("###### After find element ######" +
                "\n#### Title: " + driver.getTitle() +
                "\n#### URL: " + driver.getCurrentUrl() +
                "\n#### Locator: " + locator.toString() +
                "\n####Result: " + result.toString() +
                "\n#########");
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {

        System.out.println("###### After find elements ######" +
                "\n#### Title: " + driver.getTitle() +
                "\n#### URL: " + driver.getCurrentUrl() +
                "\n#### Locator: " + locator.toString() +
                "\n#### Number of found elements: " + result.size() +
                "\n#### Results:");

        result.forEach(r->System.out.println("#### " + r.getText()));

        System.out.println("#########");
    }
    @Override
    public void afterMaximize(WebDriver.Window window) {

        System.out.println("###### After maximize ######" +
                           "\n#### Window: " + window.toString() +
                           "\n#### Size: " + window.getSize().toString() );
    }
    @Override
    public void beforeClick(WebElement element) {

        System.out.println("###### Before click ###### \n" +
                           "#### Element: " + element.getText() + "\nTag: " + element.getTagName() +
                           "\n#########");
    }
    @Override
    public void afterClick(WebElement element) {

        System.out.println("###### After click ###### \n" +
                "#### Element: " + element.getText() + "\nTag: " + element.getTagName() +
                "\n#########");
    }

    @Override
    public void beforeSendKeys(WebElement element, java.lang.CharSequence... keysToSend) {

        System.out.println("###### Before send keys ######" +
                "\n#### Tag: " + element.getTagName() +
                "\n#### Keys: " + Arrays.toString(keysToSend) +
                "\n#########");
    }
    @Override
    public void afterSendKeys(WebElement element, java.lang.CharSequence... keysToSend) {

        System.out.println("###### After send keys ######" +
                "\n#### Tag: " + element.getTagName() +
                "\n#### Keys: " + Arrays.toString(keysToSend) +
                "\n#########");
    }

    @Override
    public void beforeIsDisplayed(WebElement element) {

        System.out.println("###### Before is displayed ######" +
                "\n#### Tag: " + element.getTagName() +
                "\n#########\n");
    }

    @Override
    public void afterIsDisplayed(WebElement element, boolean result) {

        System.out.println("####### After is displayed #######" +
                "\n#### Tag: " + element.getTagName() +
                "\n#### Is displayed: " + result +
                "\n#########\n");
    }

    @Override
    public void onError(java.lang.Object target, java.lang.reflect.Method method, java.lang.Object[] args,
                        java.lang.reflect.InvocationTargetException e) {

        System.out.println("###### ERROR ######" +
                "\n#### On target: " + target.toString() +
                "\n#### On method: " + method.getName() +
                "\n#### Args:");

        for (Object o : args) {

            System.out.println("#### " + o.toString());
        }

        System.out.println("#### Exception: " + e.toString() +
                "\n####################\n");

    }
}
