package edu.najah.it.capp.logger;


public class Logger {
	private static Logger instance; 
	
	private Logger() {
		
	}
	
	public static Logger getInstance() {
		if(instance == null) {
			instance = new Logger();
		}
		return instance;
	}
	

	public void logInfo(String message) {
		System.out.println(  " [Info] " + message);
	}	
	public void logDebug(String message) {
		System.out.println( " [Debug] " + message);
	}
	public void logWarning(String message) {
		System.err.println(  " [Warn] " + message);
	}
	public void logError(String message) {
		System.err.println( " [Error] " + message);
	}
	
}
