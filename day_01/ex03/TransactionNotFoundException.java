package day_01.ex03;

public class TransactionNotFoundException extends RuntimeException{
	public TransactionNotFoundException(String message) {
		super(message);
	}
}
