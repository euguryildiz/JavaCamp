package interfaces;

public class CustomerManager {
	
	private Logger[] loggers;
	
	public CustomerManager(Logger[] loggers) {
		this.loggers = loggers;
	}
	public void add(Customer customer) {
		System.out.println("Customer added "+ customer.getFirstName());
		
		Utils.runLogger(loggers, customer.getFirstName()+ " logged");
	
	}
	public void delete(Customer customer) {
		System.out.println("Customed deleted "+customer.getFirstName());
		
		Utils.runLogger(loggers, customer.getFirstName()+ " logged");


	}
}
