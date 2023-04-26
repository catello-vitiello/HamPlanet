package utils;

import java.util.logging.Logger;

public class UtilityClass {
	
	public static Logger logger = Logger.getLogger("global");
	
	public static void print(String... messages) {
		String message = "";
		for(String s : messages) {
			message += s+"\n";
		}
		logger.info(message);
	}
	
	public static void print(Exception exception) {
		UtilityClass.print("Exception: " + exception.getMessage());
		exception.printStackTrace();
	}
	
}
