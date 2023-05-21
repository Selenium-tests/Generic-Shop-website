package listener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import utils.ScreenshotFileUtils;

public class ScreenshotCaptorListener implements WebDriverListener {
    private final WebDriver driver;

    public ScreenshotCaptorListener(WebDriver driver) {

        this.driver = driver;
    }
    @Override
    public void onError(java.lang.Object target, java.lang.reflect.Method method, java.lang.Object[] args,
                        java.lang.reflect.InvocationTargetException e) {

        ScreenshotFileUtils.saveToFile(driver, method.getName());
    }
}
