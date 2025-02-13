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

The `UsersList` interface defines the methods for adding users (`addUser`), retrieving users by ID (`getUserById`), retrieving users by index (`getUserByIndex`), and getting the number of users (`getNumberOfUsers`).  It serves as a contract for any class that wants to implement a user list.

### UsersArrayList Class

The `UsersArrayList` class implements the `UsersList` interface and provides a concrete implementation for managing a list of `User` objects.  It uses an array (`users`) to store the user data.  A key feature of this class is that it dynamically resizes the array when it becomes full.  When a new user is added and the array is at capacity, the array's size is increased (by 50% in this implementation) to accommodate the new user.  This prevents a fixed limit on the number of users that can be stored.  The `getUserById` method searches the array for a user with the specified ID and throws a `UserNotFoundException` if the user is not found. The `getUserByIndex` method retrieves a user at a given index, returning null if the index is out of bounds.

### UserNotFoundException Class

The `UserNotFoundException` is a custom, unchecked exception (extends `RuntimeException`) that is thrown by the `UsersArrayList` class when a user with a specific ID is not found.  Using a custom exception makes error handling more specific and allows the calling code to handle this particular error condition appropriately.