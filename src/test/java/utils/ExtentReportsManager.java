package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ExtentReportsManager {

    private ExtentReports extentReports = new ExtentReports();

    private ExtentTest logger;


    public ExtentReportsManager() {

        extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Projekty\\Testowanie\\Generic-Shop-tests-master\\reports\\myReport.html");
        sparkReporter.config().setTheme(Theme.STANDARD);
        extentReports.attachReporter(sparkReporter);
    }

    public void setName(String testName) {

        logger = extentReports.createTest(testName);
    }

    public void setInfo(String message) {

        logger.log(Status.INFO, MarkupHelper.createLabel(message, ExtentColor.CYAN));
    }

    public void setTestPassed(String message) {

        logger.log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.GREEN));
    }

    public void setTestFailed(String message) {

        logger.log(Status.FAIL, MarkupHelper.createLabel(message, ExtentColor.RED));
    }

    private void flush() {

        extentReports.flush();
    }
}
