package day_01.ex03;

// The TransactionNotFoundException is a custom exception class that is thrown
// when a transaction with a specific ID is not found in the transaction list.

public class TransactionNotFoundException extends RuntimeException {
	public TransactionNotFoundException(String message) {
		super(message);
	}
}