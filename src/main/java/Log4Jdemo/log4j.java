package Log4Jdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4j {
	
	static Logger logger = LogManager.getLogger(log4j.class);

	public static void main(String[] args) {
		
		System.out.println("\n Hello World \n");
		
		logger.trace("trace message");
		logger.info("info messege");
		logger.error("error message");
		logger.warn("warn message");
		logger.fatal("fatal message");
		
		System.out.println("\n Comlited");
		

	}

}
