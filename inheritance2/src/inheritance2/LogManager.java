package inheritance2;

public class LogManager {
	
	public void log(int logType) {
		if (logType == 1) {
			System.out.println("Database Log");
		}else if (logType == 2) {
			System.out.println("File Log");
		}else {
			System.out.println("Mail Log");
		}
	}
}
