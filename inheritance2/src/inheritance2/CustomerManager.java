package inheritance2;

public class CustomerManager {
	
	public void add(Logger logger) {
		System.out.println("Customer added");
		DatabaseLogger databaseLogger = new DatabaseLogger();
		databaseLogger.log();
	}
}
