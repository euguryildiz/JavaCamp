package interfaces;

public class EmailLogger implements Logger {

	@Override
	public void log(String message) {
		System.out.println("email send : " + message);
		
	}

}
