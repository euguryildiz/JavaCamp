package interfaces;


public class Main {

	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setId(1);
		customer.setFirstName("Uğur");
		customer.setLastName("Yıldız");
		
		
		CustomerManager customerManager = new CustomerManager(new Logger[] {new DatabaseLogger(), new EmailLogger(), new FileLogger()});
		customerManager.add(customer);

	}

}
