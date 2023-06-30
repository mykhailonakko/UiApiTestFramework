package org.rptest.core.logger;

import lombok.experimental.UtilityClass;
import org.rptest.core.config.Property;

@UtilityClass
public class LoggerFactory {
    public enum LoggerLibrary {
        LOG4J,
        JAVA_UTIL_LOGGER
    }

    public static ILogger getLogger() {
        LoggerLibrary loggerLibrary = Enum.valueOf(LoggerLibrary.class, Property.COMMON_PROPERTY.loggerLibrary().toUpperCase());
        switch (loggerLibrary) {
            case LOG4J:
                return new Log4jLogger();
            case JAVA_UTIL_LOGGER:
                return new JavaUtilLogger();
            default:
                throw new IllegalArgumentException("Unsupported library: " + loggerLibrary);
        }
    }
}
