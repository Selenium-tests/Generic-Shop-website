package qa.listener;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import qa.driver.WebDriverGlobal;


public class TestListener implements ITestListener {

    private final Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {

        return message;
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {

        return ((TakesScreenshot) WebDriverGlobal.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onStart(ITestContext iTestContext) {

        logger.info("Suite: " + iTestContext.getSuite());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

        logger.info("Test finish");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

        logger.info("Starting test on method: " + iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        logger.info("Test PASSED");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        takeScreenshot();
        saveTextLog(iTestResult.getThrowable().getMessage());
        logger.error("Test FAILED: " + iTestResult.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

        logger.info("Test SKIPPED");
    }
}
