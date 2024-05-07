package qa.driver;

import org.reflections.Reflections;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class WebDriverProvider {

    public static WebDriverFactory getDriver() {

        String browser = System.getenv("BROWSER_TYPE");

        if (browser == null || browser.isEmpty()) {
            browser = "firefox";
        }

        String packages = WebDriverFactory.class.getPackage().getName();
        Reflections reflections = new Reflections(packages);

        Set<Class<? extends WebDriverFactory>> factories = reflections.getSubTypesOf(WebDriverFactory.class);

        String finalBrowser = browser;
        Class<? extends WebDriverFactory> inherited = factories
                .stream()
                .filter(driver -> driver.getName().toLowerCase().contains(finalBrowser.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Could not find driver with name " + finalBrowser));

        String inheritedClassName = inherited.getName();

        try {

            return (WebDriverFactory) Class.forName(inheritedClassName).getConstructor().newInstance();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {

            throw new IllegalStateException(e);
        }
    }
}
