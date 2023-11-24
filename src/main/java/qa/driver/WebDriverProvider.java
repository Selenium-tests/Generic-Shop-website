package qa.driver;

import qa.enums.Browser;
import org.reflections.Reflections;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class WebDriverProvider {

    public static WebDriverFactory getDriver(Browser browser) {

        String packages = WebDriverFactory.class.getPackage().getName();
        Reflections reflections = new Reflections(packages);

        Set<Class<? extends WebDriverFactory>> factories = reflections.getSubTypesOf(WebDriverFactory.class);

        Class<? extends WebDriverFactory> inherited = factories
                .stream()
                .filter(driver -> driver.getName().toLowerCase().contains(browser.getName().toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Could not find driver with name " + browser.getName()));

        String inheritedClassName = inherited.getName();

        try {

            return (WebDriverFactory) Class.forName(inheritedClassName).getConstructor().newInstance();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {

            throw new IllegalStateException(e);
        }
    }
}
