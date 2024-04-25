package qa.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ISuite;
import org.testng.ISuiteListener;


public class SuiteListener implements ISuiteListener {

    private final Logger logger = LoggerFactory.getLogger(SuiteListener.class);

    @Override
    public void onStart(ISuite suite) {

        logger.info("Suite: {}", suite.getName());
        logger.info("*".repeat(60));
    }

    @Override
    public void onFinish(ISuite suite) {

        logger.info("Finish tests on suite: {}", suite.getName());
        logger.info("*".repeat(60));
    }
}
