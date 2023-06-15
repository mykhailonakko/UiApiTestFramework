package org.rptest.core.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaUtilLogger implements ILogger {
    private final Logger logger;

    public JavaUtilLogger() {
        this.logger = Logger.getLogger(getCallerClassName());
    }

    public void info(String message) {
        logger.log(Level.INFO, message);
    }

    public void error(String message) {
        logger.log(Level.SEVERE, message);
    }

    private String getCallerClassName() {
        StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
        String className = stElements[3].getClassName();
        try {
            return Class.forName(className).getName();
        } catch (ClassNotFoundException e) {
            error(e.getMessage());
            return null;
        }
    }
}
