# Module 01 - Piscine Java OOP/Collections - Exercise 01

This exercise builds upon Exercise 00 by introducing the concept of a unique ID generator for the `User` class.  The goal is to ensure that each user has a unique identifier, even if they have the same name.

## Learning Objectives

This exercise reinforces and expands on the concepts from Exercise 00, adding the following:

* **Singleton Pattern:** Implementing the Singleton pattern with the `UserIdsGenerator` class. This ensures that only one instance of the ID generator exists, preventing the possibility of duplicate IDs.  This is a crucial design pattern when you need exactly one instance of a class.
* **Read-only Fields:** Using the `final` keyword to make the `identifier` field in the `User` class read-only after it's initialized. This enforces the requirement that a user's ID cannot be changed after creation.
* **ID Generation:** Implementing a simple ID generation mechanism within the `UserIdsGenerator` to provide sequential, unique IDs.
* **Dependency Injection (Simplified):** While not full dependency injection, the `User` class now depends on the `UserIdsGenerator` to get its ID, demonstrating a basic form of dependency management.

## Code Explanation

### UserIdsGenerator Class

The `UserIdsGenerator` class implements the Singleton pattern.  The private constructor prevents direct instantiation.  The `getInstance()` method provides access to the single instance of the class, creating it if it doesn't already exist. The `generateId()` method increments the `id_counter` and returns the new unique ID.

### User Class

The `User` class now uses the `UserIdsGenerator` to get its unique `identifier` in the constructor.  The `identifier` field is declared as `final`, making it read-only after initialization.  This ensures that the user's ID cannot be changed after the user object is created.

This exercise provides a practical example of how to generate unique IDs and how to use the Singleton pattern. It also demonstrates how to make fields read-only to protect data integrity.