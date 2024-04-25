package qa.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IConfigurationListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class ConfigurationListener implements IConfigurationListener {

    private final Logger logger = LoggerFactory.getLogger(ConfigurationListener.class);

    @Override
    public void onConfigurationSuccess(ITestResult tr, ITestNGMethod tm) {

        logger.info("Configuration success on method: {}", tr.getMethod());
        logger.info("*".repeat(60));
    }

    @Override
    public void onConfigurationFailure(ITestResult tr, ITestNGMethod tm) {

        logger.info("Configuration failure on method: {}", tr.getMethod());
        logger.info("*".repeat(60));
    }

    @Override
    public void onConfigurationSkip(ITestResult tr, ITestNGMethod tm) {

        logger.info("Configuration skipped on method: {}", tr.getMethod());
        logger.info("*".repeat(60));
    }

    @Override
    public void beforeConfiguration(ITestResult tr, ITestNGMethod tm) {

        logger.info("Preparing configuration on method: {}", tr.getMethod().getMethodName());
        logger.info("*".repeat(60));
    }
}
