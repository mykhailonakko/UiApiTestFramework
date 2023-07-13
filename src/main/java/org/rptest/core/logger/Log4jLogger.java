package org.rptest.core.logger;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jLogger implements ILogger {
    private final Logger logger;
    public Log4jLogger() {
        this.logger = LogManager.getLogger();
    }

    public void info(String message) {
        logger.info(message);
    }

    public void error(String message) {
        logger.error(message);
    }
}
