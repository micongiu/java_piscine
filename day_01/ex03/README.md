# Module 01 - Piscine Java OOP/Collections - Exercise 03: Transactions Management

This exercise builds upon the concepts introduced in Exercises 00, 01, and 02, focusing on managing user accounts and transactions using a linked list implementation for transaction storage.

## Learning Objectives

This exercise reinforces and expands on previous concepts, focusing on:

*   **Transaction Management:** Implementing a system to track user transactions, including adding and removing transactions.
*   **Linked Lists:**  Practicing the implementation and use of a linked list (`TransactionsLinkedList`) to store transactions.  This exercise highlights the advantages of linked lists for frequent insertions and deletions.
*   **Interfaces:** Defining and implementing the `TransactionsList` interface to provide a contract for transaction list implementations.
*   **Exception Handling:**  Using a custom exception (`TransactionNotFoundException`) to handle cases where a transaction is not found.
*   **Object Relationships:**  Modeling the relationship between `User` objects and their associated `TransactionsList`.
*   **Data Integrity:** Ensuring data consistency by managing user balances during transactions and preventing invalid transactions

## Code Explanation

The project consists of the following classes and interface:

### TransactionsLinkedList Class

The `TransactionsLinkedList` class implements the `TransactionsList` interface, providing a concrete way to manage a collection of `Transaction` objects. It uses a `LinkedList` as its underlying data structure, which is particularly suitable for handling frequent insertions and deletions of transactions. This class handles the actual storage and manipulation of the transaction data.

### TransactionsList Interface

The `TransactionsList` interface defines the contract for any class that wants to manage a list of transactions. It specifies the methods that must be implemented, such as adding a transaction (`AddTransaction`), removing a transaction by its ID (`RemoveTransactionById`), and converting the list to an array (`ToArry`). This interface allows for different implementations of transaction lists (e.g., using an array, a different linked list implementation, etc.) while ensuring they all adhere to the same basic functionality.

### TransactionNotFoundException Class

The `TransactionNotFoundException` is a custom exception class used to signal that an attempt was made to access or remove a transaction with an ID that does not exist in the list. Using a specific exception type makes error handling more precise and informative.
