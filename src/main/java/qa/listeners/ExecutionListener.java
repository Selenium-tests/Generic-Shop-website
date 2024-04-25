package qa.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IExecutionListener;

public class ExecutionListener implements IExecutionListener {

    private final Logger logger = LoggerFactory.getLogger(ExecutionListener.class);

    @Override
    public void onExecutionStart() {

        logger.info("STARTING EXECUTION");
    }

    @Override
    public void onExecutionFinish() {

        logger.info("EXECUTION FINISH");
    }
}
