package JavaCamp.northwind.core.utilities.result;

public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult(T data) {
		super(false, data);
	}
	
	public ErrorDataResult(String message, T data) {
		super(false, message, data);
	}
}
