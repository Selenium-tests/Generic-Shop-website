package qa.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private final Logger logger = LoggerFactory.getLogger(TestListener.class);

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

        logger.info("Starting test omn method: " + iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        logger.info("Test PASSED");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        logger.error("Test FAILED: " + iTestResult.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

        logger.info("Test SKIPPED");
    }
}
