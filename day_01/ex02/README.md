# Module 01 - Piscine Java OOP/Collections - Exercise 02

This exercise focuses on creating a dynamic user list using an interface and an array-based implementation. The goal is to manage a collection of users with the ability to add, retrieve (by ID and index), and count users. It also introduces exception handling for cases where a user is not found.

## Learning Objectives

This exercise builds upon previous exercises and introduces the following:

* **Interfaces:** Defining the `UsersList` interface to specify the contract for user list implementations. This promotes loose coupling and allows for different storage implementations in the future.
* **Array-based Data Structure:** Implementing the `UsersArrayList` class using an array to store user data. This provides a basic understanding of how dynamic arrays work.
* **Dynamic Array Resizing:** Implementing the dynamic resizing of the array in `UsersArrayList`. When the array is full, its capacity is increased to accommodate more users.  This avoids a fixed limit on the number of users.
* **Custom Exceptions:** Creating a custom exception class, `UserNotFoundException`, to handle the specific case where a user with a given ID is not found.  This makes error handling more specific and informative.
* **Implementing an Interface:**  The `UsersArrayList` class implements the `UsersList` interface, demonstrating how to fulfill a contract defined by an interface.
* **Exception Handling:** Using `try-catch` blocks to handle potential `UserNotFoundException` and `IllegalArgumentException` (from user creation).  This is crucial for writing robust code.

## Code Explanation

### UsersList Interface

The `UsersList` interface defines the methods for adding users, retrieving users by ID and index, and getting the number of users.