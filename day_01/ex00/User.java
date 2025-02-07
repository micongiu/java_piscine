package day_01.ex00;

/*
 * The User class represents a user in the system.
 * It stores the user's unique identifier, name, and balance.
 * It also provides methods for accessing and modifying the user's balance.
 */

public class User {
	private int identifier;
	private int balance;
	private String name;


	/*
	 * Constructs a new User object.
	 *
	 * @param identifier The user's unique identifier.
	 * @param name       The user's name.
	 * @param balance    The user's initial balance.
	 * @throws IllegalArgumentException If the initial balance is negative.
	 */

	public User(int identifier, String name, int balance) {
		this.identifier = identifier;
		this.name = name;
		if (balance < 0) {
			throw new IllegalArgumentException("Initial balance cannot be negative.");
		}
		this.balance = balance;
	}

	// Methods getter
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
