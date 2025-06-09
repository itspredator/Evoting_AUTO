package utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class mylogger {
	

	    private static final Logger logger = LoggerFactory.getLogger(mylogger.class);

	    public static void main(String[] args) {
	        logger.info("This is an info message.");
	        logger.debug("This is a debug message.");
	        logger.error("This is an error message.");
	    }
	}



