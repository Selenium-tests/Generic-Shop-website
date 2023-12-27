package qa.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import qa.extentreports.ExtentReportsManager;

public class TestListener implements ITestListener {

    private final Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext iTestContext) {

        logger.info("Suite: " + iTestContext.getSuite());
        ExtentReportsManager.create(iTestContext.getSuite().getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

        logger.info("Test finish");
        ExtentReportsManager.setEnvironment();
        ExtentReportsManager.flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

        logger.info("Starting test omn method: " + iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        logger.info("Test PASSED");
        ExtentReportsManager.setTestPassed("Test passed on method: " + iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        logger.error("Test FAILED: " + iTestResult.getThrowable().getMessage());
        ExtentReportsManager.setTestFailed(iTestResult.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

        logger.info("Test SKIPPED");
        ExtentReportsManager.setTestSkipped("Test skipped on method: " + iTestResult.getMethod().getMethodName());
    }
}
