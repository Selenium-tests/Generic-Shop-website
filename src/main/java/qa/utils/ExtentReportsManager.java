package qa.utils;

import qa.base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.remote.RemoteWebDriver;


public class ExtentReportsManager {

    private static ExtentReports extentReports = new ExtentReports();

    private static ExtentTest extentTest;
    private static final String path = "./reports/";

    public static void create(String fileName) {

        extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path + fileName);
        sparkReporter.config().setTheme(Theme.STANDARD);
        extentReports.attachReporter(sparkReporter);
    }

    public static void setName(String testName) {

        extentTest = extentReports.createTest(testName);
    }

    public static void setInfo(String message) {

        extentTest.log(Status.INFO, MarkupHelper.createLabel(message, ExtentColor.CYAN));
    }

    public static void setTestPassed(String message) {

        extentTest.log(Status.PASS, message);
    }

    public static void setTestFailed(String message) {

        extentTest.log(Status.FAIL, message);
    }

    public static void setTestSkipped(String message) {

        extentTest.log(Status.SKIP, message);
    }

    public static void setEnvironment() {

        extentReports.setSystemInfo("System property", System.getProperty("user.dir"));
        extentReports.setSystemInfo("Operating system", System.getProperty("os.name") +
                " " + System.getProperty("os.arch"));
        extentReports.setSystemInfo("Browser", ((RemoteWebDriver)BaseTest.getDriver()).getCapabilities().getBrowserName() +
                " " + (((RemoteWebDriver) BaseTest.getDriver()).getCapabilities().getBrowserVersion()));
        extentReports.setSystemInfo("Java runtime version", System.getProperty("java.runtime.version"));
    }

    public static void flush() {

        extentReports.flush();
    }
}
