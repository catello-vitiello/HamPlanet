package utils;

public class UtilityClass {
	
	public static void print(String... messages) {
		String message = "";
		for(String s : messages) {
			message += s+"\n";
		}
		System.out.print(message);
	}
	
	public static void print(Exception exception) {
		UtilityClass.print("Exception: " + exception.getMessage());
		exception.printStackTrace();
	}
	
}
