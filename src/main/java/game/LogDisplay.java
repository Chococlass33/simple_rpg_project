package game;

import edu.monash.fit2099.engine.Display;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The LogDisplay will also log any messages to the INFO level log
 */
public class LogDisplay extends Display {

    private Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Print a message to console and log
     * @param s
     */
    @Override
    public void println(String s) {
        logger.info(s);
        System.out.println(s);
    }

}
