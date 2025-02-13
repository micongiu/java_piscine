package day_01.ex03;

import java.util.LinkedList;

// The TransactionsLinkedList class implements the TransactionsList interface using a
// LinkedList to store transactions. It provides methods for adding, removing, and
// retrieving transactions.

public class TransactionsLinkedList implements TransactionsList {
	private LinkedList<Transaction> myList = new LinkedList<>();

	@Override
	public void AddTransaction(Transaction NewTransaction) {
		myList.add(NewTransaction);
	}

	@Override
	public void RemoveTransactionById(String identifier) throws TransactionNotFoundException {
		java.util.Iterator<Transaction> iterator = myList.iterator();
		while (iterator.hasNext()) {
			Transaction transaction = iterator.next();
			if (transaction.getIdentifier().equals(identifier)) {
				iterator.remove();
				return;
			}
		}
		throw new TransactionNotFoundException("Transaction with id: " + identifier + " not found.");
	}

	@Override
	public Transaction[] ToArry() {
		Transaction[] transactionArray = myList.toArray(Transaction[]::new);
		return transactionArray;
	}
}
