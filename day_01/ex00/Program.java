package day_01.ex00;

/*
 * The Program class demonstrates the functionality of the User and Transaction classes.
 * It creates User objects, performs transactions between them, and prints the state
 * of the users and transactions to the console. It also showcases error handling
 * for invalid transaction amounts and insufficient funds.
 */

public class Program {
	public static void main(String[] args) {
		User alice = new User(1, "Alice", 100);
		User bob = new User(2, "Bob", 50);

		System.out.println("Initial state:");
		System.out.println(alice);
		System.out.println(bob);

		try {
			Transaction t1 = new Transaction(alice, bob, -30, Transaction.TransferCategory.OUTGOING);
			System.out.println("\nTransaction 1:");
			System.out.println(t1);
		} catch (IllegalArgumentException e) {
			System.err.println("Transaction 1 Error: " + e.getMessage());
		}

		System.out.println("\nAfter transaction 1:");
		System.out.println(alice);
		System.out.println(bob);

		try {
			Transaction t2 = new Transaction(alice, bob, 20, Transaction.TransferCategory.INCOMING);
			System.out.println("\nTransaction 2:");
			System.out.println(t2);
		} catch (IllegalArgumentException e) {
			System.err.println("Transaction 2 Error: " + e.getMessage());
		}


		System.out.println("\nFinal state:");
		System.out.println(alice);
		System.out.println(bob);


		try {
			Transaction t3 = new Transaction(alice, bob, -150, Transaction.TransferCategory.OUTGOING);
			System.out.println("\nTransaction 3:");
			System.out.println(t3);
		} catch (IllegalArgumentException e) {
			System.err.println("Transaction 3 Error: " + e.getMessage());
		}

		System.out.println("\nAfter transaction 3 (error):");
		System.out.println(alice);
		System.out.println(bob);

	}
}