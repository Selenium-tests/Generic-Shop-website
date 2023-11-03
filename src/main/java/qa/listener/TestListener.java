package qa.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import qa.base.BaseTest;
import qa.utils.ExtentReportsManager;
import qa.utils.ScreenshotFileUtils;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext iTestContext) {

        ExtentReportsManager.create(iTestContext.getSuite().getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

        System.out.println("End testing on suite " + iTestContext.getSuite().getName());
        ExtentReportsManager.setEnvironment();
        ExtentReportsManager.flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

        System.out.println("Starting test with method: " + iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        System.out.println("Test passed on method " + iTestResult.getMethod().getMethodName());
        ExtentReportsManager.setTestPassed("Test passed on method: " + iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        System.out.println("Test failed on method " + iTestResult.getMethod().getMethodName());
        ExtentReportsManager.setTestFailed(iTestResult.getThrowable().getMessage());

        ScreenshotFileUtils.saveToFile(BaseTest.getDriver(), iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

        System.out.println("Test skipped on method " + iTestResult.getMethod().getMethodName());
        ExtentReportsManager.setTestSkipped("Test skipped on method: " + iTestResult.getMethod().getMethodName());
    }
}
