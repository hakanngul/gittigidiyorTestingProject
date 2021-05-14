package Model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class CustomLogger {
    private final Logger logger = LogManager.getLogger(CustomLogger.class);
    private static CustomLogger customLogger;

    private CustomLogger() {

    }

    public static CustomLogger getInstance() {
        if (customLogger == null) {
            customLogger = new CustomLogger();
        }
        return customLogger;
    }

    public void info(String str) {
        logger.info(str);
    }

    public void warn(String str) {
        logger.warn(str);
    }

    public void error(String str) {
        logger.error(str);
    }
}