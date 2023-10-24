package qa.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

public class ScreenshotFileUtils {
    private static final String path = "./screenshots/";
    public static void saveToFile(WebDriver driver, String testName) {

        LocalTime localTime = LocalTime.now();

        String fileName = testName + "_" + localTime.getHour() + "-" + localTime.getMinute() +
                          "-" + localTime.getSecond() + ".png";

        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotFile, new File(path + fileName));

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
