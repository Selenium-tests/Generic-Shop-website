package qa.retryanalyzer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private final int maxRetryCount = 5;

    private final Logger logger = LoggerFactory.getLogger(RetryAnalyzer.class);

    @Override
    public boolean retry(ITestResult iTestResult) {

        if (retryCount < maxRetryCount) {

            logger.info("Retrying test on method: {}", iTestResult.getMethod().getMethodName());
            retryCount++;
            return true;
        }

        return false;
    }
}
