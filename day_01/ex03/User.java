package day_01.ex03;

// The User class represents a user in the system. It stores the user's unique
// identifier, name, and balance. The identifier is generated using the
// UserIdsGenerator to ensure uniqueness. It also holds a TransactionsList
// object to store the user's transactions.

public class User {
	private final int identifier;
	private int balance;
	private String name;
	private TransactionsList Transactions;

	// Constructs a new User object.
	// @param name    The user's name.
	// @param balance The user's initial balance.
	// @throws IllegalArgumentException If the initial balance is negative.
	public User(String name, int balance) {
		this.identifier = UserIdsGenerator.getInstance().generateId();
		this.name = name;
		if (balance < 0) {
			throw new IllegalArgumentException("Initial balance cannot be negative.");
		}
		this.balance = balance;
		this.Transactions = new TransactionsLinkedList();
	}

	// Methods getter

	public TransactionsList getTransactions() {
		return Transactions;
	}
	
	public int getIdentifier() {
		return identifier;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBalance() {
		return balance;
	}
	
	// Methods setter

	public void addTransaction(Transaction transaction) {  // Add this method!
		Transactions.AddTransaction(transaction);
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User{" +
				"identifier=" + identifier +
				", balance=" + balance +
				", name='" + name + '\'' +
				'}';
	}
}