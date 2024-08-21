package org.logger;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Log {
    private static final Logger LOGGER = Logger.getLogger(Log.class.getName());

    public static void info(String message) {
        LOGGER.log(Level.INFO, message);
    }

    public static void warning(String message) {
        LOGGER.log(Level.WARNING, message);
    }

    public static void error(String message) {
        LOGGER.log(Level.SEVERE, message);
    }
}
