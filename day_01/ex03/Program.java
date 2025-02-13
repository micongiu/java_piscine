package day_01.ex03;

// The Program class serves as the entry point for the application.
// It demonstrates the creation of users, transactions, and the use of the
// TransactionsList interface and related classes. It performs sample
// transactions, prints user information, and showcases transaction removal.
public class Program {

	private static void printTransactions(TransactionsList transactions) {
		Transaction[] transactionArray = transactions.ToArry();
		if (transactionArray != null) {
			for (Transaction t : transactionArray) {
				System.out.println(t);
			}
		}
	}

	public static void main(String[] args) {
		User alice = new User("Alice", 100);
		User bob = new User("Bob", 50);
		User charlie = new User("Charlie", 200);

		try {
			Transaction t1 = new Transaction(alice, bob, -30, Transaction.TransferCategory.OUTGOING);
			Transaction t2 = new Transaction(bob, alice, 15, Transaction.TransferCategory.INCOMING);
			Transaction t3 = new Transaction(charlie, alice, -50, Transaction.TransferCategory.OUTGOING);

			alice.addTransaction(t1);
			bob.addTransaction(t2);
			charlie.addTransaction(t3);

			System.out.println(alice);
			System.out.println(bob);
			System.out.println(charlie);

			System.out.println("\nAlice's Transactions:");
			printTransactions(alice.getTransactions());

			String idToRemove = t1.getIdentifier();
			alice.getTransactions().RemoveTransactionById(idToRemove);
			System.out.println("\nAlice's Transactions after removal:");
			printTransactions(alice.getTransactions());

			try {
				alice.getTransactions().RemoveTransactionById("nonExistentId");
			} catch (TransactionNotFoundException e) {
				System.err.println(e.getMessage());
			}

		} catch (IllegalArgumentException e) {
			System.err.println("Transaction error: " + e.getMessage());
		}
	}
}