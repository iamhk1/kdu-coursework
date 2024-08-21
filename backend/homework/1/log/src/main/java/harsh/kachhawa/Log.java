package harsh.kachhawa;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {

    private static final Logger logger
            = LoggerFactory.getLogger(Log.class);

    public static void setLogger(String message) {
        logger.info(message);
    }
}