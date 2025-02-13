# Module 01 - Piscine Java OOP/Collections - Exercise 00

This exercise introduces basic Object-Oriented Programming (OOP) concepts in Java by implementing two core classes: `User` and `Transaction`.  The goal is to model a simple system for managing user accounts and money transfers between them.

## Learning Objectives

This exercise helped me understand and practice the following concepts:

* **Class and Object Creation:** Defining classes (`User`, `Transaction`) with appropriate fields (attributes) and creating instances (objects) of these classes.
* **Encapsulation:**  Using access modifiers (e.g., `private`) to control the visibility of class members (fields and methods).  Getters and setters (though not strictly necessary for this exercise per the prompt, using them is good practice for encapsulation) provide controlled access to the user's balance.
* **Constructors:** Implementing constructors to initialize objects with specific values upon creation.  The `User` constructor enforces a rule that the initial balance cannot be negative. The `Transaction` constructor initializes the transaction with provided details and performs the fund transfer.
* **Object State:**  Understanding how the state of an object (the values of its fields) can change over time (e.g., a user's balance after a transaction).
* **Method Implementation:** Defining and implementing methods (e.g., `setBalance`, `toString`) to perform actions on objects and represent their state.
* **Error Handling:** Using exceptions (`IllegalArgumentException`) to handle invalid input or operations (e.g., negative initial balance, insufficient funds, incorrect transfer amount sign). This is crucial for robust code.
* **Enums:** Using enums (`Transaction.TransferCategory`) to represent a fixed set of possible values (INCOMING, OUTGOING), making the code more readable and less prone to errors.
* **UUID:** Using `UUID` to generate universally unique identifiers for transactions, which is essential for tracking and managing transactions in a real-world system.
* **Overriding `toString()`:** Overriding the `toString()` method to provide a meaningful string representation of objects, which is helpful for debugging and printing object information.
* **Basic Testing:** The `Program` class serves as a basic test case, demonstrating how to create users, perform transactions, and handle potential errors.

## Code Explanation

### User Class

The `User` class represents a user with an `identifier`, `name`, and `balance`. The constructor ensures that the initial balance is not negative. Getters provide access to the user's information.

### Transaction Class

The `Transaction` class represents a money transfer between two users. It stores information about the transaction, including a unique identifier (`identifier`) generated using `UUID.randomUUID()`, the sender (`Sender`), the recipient (`Recipient`), the transfer category (`transferCategory`), and the transfer amount (`transfer_amount`). The `transferCategory` is an enum with values `OUTGOING` and `INCOMING`.  The constructor enforces rules regarding transfer amounts (positive for incoming, negative for outgoing) and sufficient funds for outgoing transfers. If any of these rules are violated, an `IllegalArgumentException` is thrown.
