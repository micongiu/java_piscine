package day_01.ex03;

import day_01.ex03.Transaction;

interface TransactionsList {
	void AddTransaction(Transaction NewTransaction);

	void RemoveTransactionById(String identifier) throws TransactionNotFoundException;

	Transaction[] ToArry();
}
