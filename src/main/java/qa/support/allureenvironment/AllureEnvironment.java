package qa.support.allureenvironment;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class AllureEnvironment {

    public static void setEnvironment(WebDriver driver) {

        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Available processors (core)", String.valueOf(Runtime.getRuntime().availableProcessors()))
                        .put("Maximum memory", String.valueOf(Runtime.getRuntime().maxMemory()))
                        .put("Total memory", String.valueOf(Runtime.getRuntime().totalMemory()))
                        .put("Free memory", String.valueOf(Runtime.getRuntime().freeMemory()))
                        .put("Operating system", System.getProperty("os.name") + " " + System.getProperty("os.arch"))
                        .put("Java runtime version", System.getProperty("java.runtime.version"))
                        .put("Browser", ((RemoteWebDriver) driver).getCapabilities().getBrowserName() + " " +
                                                   ((RemoteWebDriver)driver).getCapabilities().getBrowserVersion())
                        .build(), System.getProperty("user.dir") + "/allure-results/"
        );
    }
}
