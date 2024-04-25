package qa.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IDataProviderListener;
import org.testng.IDataProviderMethod;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;

public class DataProviderListener implements IDataProviderListener {

    private final Logger logger = LoggerFactory.getLogger(DataProviderListener.class);

    @Override
    public void beforeDataProviderExecution(IDataProviderMethod dataProviderMethod, ITestNGMethod method, ITestContext iTestContext) {

        logger.info("Getting data from the \"{}\" data provider method", dataProviderMethod.getName());
        logger.info("*".repeat(60));
    }
}
