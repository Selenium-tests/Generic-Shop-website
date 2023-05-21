package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

public class ScreenshotFileUtils {
    private static final String path = "./screenshots/";
    public static void saveToFile(WebDriver driver, String methodName) {

        LocalTime localTime = LocalTime.now();

        String fileName = methodName + "_" + localTime.getHour() + "-" + localTime.getMinute() +
                          "-" + localTime.getSecond() + ".png";

        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotFile, new File(path + fileName));

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
