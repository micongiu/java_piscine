package day_01.ex03;

import java.util.UUID;

// The Transaction class represents a money transfer between two users.
// It stores information about the transaction, including a unique identifier,
// the sender, the recipient, the transfer category (incoming or outgoing), and the
// transfer amount. It also handles the transfer of funds between users,
// ensuring that balances remain valid.

public class Transaction {
	public enum TransferCategory {
		OUTGOING,
		INCOMING
	}
	String identifier;
	User Recipient;
	User Sender;
	TransferCategory transferCategory;
	int transfer_amount;

	// Constructs a new Transaction object.
	// @param Sender         The user initiating the transaction.
	// @param Recipient      The user receiving the transaction.
	// @param transfer_amount The amount to transfer (negative for outgoing, positive for incoming).
	// @param type           The category of the transfer (OUTGOING or INCOMING).
	// @throws IllegalArgumentException If the transfer amount is invalid, or if the sender has insufficient funds.
	public Transaction(User Sender, User Recipient, int transfer_amount, TransferCategory type) {
		UUID uuid = UUID.randomUUID();
		this.identifier = uuid.toString();
		this.Recipient = Recipient;
		this.Sender = Sender;
		this.transfer_amount = transfer_amount;
		this.transferCategory = type;
	
		switch (transferCategory) {
			case OUTGOING:
				if (transfer_amount > 0) {
					throw new IllegalArgumentException("Outgoing transfer amount must be negative");
				}
				if (Recipient.getBalance() + transfer_amount < 0) {
					throw new IllegalArgumentException("Insufficient funds for outgoing transfer");
				}
				Sender.setBalance(Sender.getBalance() + transfer_amount);
				Recipient.setBalance(Recipient.getBalance() - transfer_amount);
				break;
			case INCOMING:
				if (transfer_amount < 0) {
					throw new IllegalArgumentException("Incoming transfer amount must be positive");
				}
				if (Sender.getBalance() + transfer_amount < 0) {
					throw new IllegalArgumentException("Insufficient funds for outgoing transfer");
				}
				Sender.setBalance(Sender.getBalance() - transfer_amount);
				Recipient.setBalance(Recipient.getBalance() + transfer_amount);
				break;
			default:
				throw new IllegalArgumentException("Only outgoing and incoming transfer are allowed");
		}
	}

	// Methods getter
	public String getIdentifier() {
		return identifier;
	}

	@Override
	public String toString() {
		return "Transaction{" +
				"identifier='" + identifier + '\'' +
				", Recipient=" + Recipient +
				", Sender=" + Sender +
				", Transfer_category=" + transferCategory +
				", transfer_amount=" + transfer_amount +
				'}';
	}
}
