package day_01.ex03;

// The TransactionsList interface defines the contract for classes that manage a list
// of transactions. It specifies methods for adding, removing, and converting the
// transaction list to an array.
public interface TransactionsList {
	void AddTransaction(Transaction NewTransaction);

	void RemoveTransactionById(String identifier) throws TransactionNotFoundException;

	Transaction[] ToArry();
}