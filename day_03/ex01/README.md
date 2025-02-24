# Module 03 - Piscine Java Threads - Exercise 01

This exercise focuses on thread synchronization and communication using a `SynchronousQueue`. The goal is to create a program that uses two threads ("Egg" and "Hen") to print messages in an alternating pattern, ensuring that one thread can only print its message after the other thread has printed its message.

## Learning Objectives

This exercise helped me understand and practice the following concepts:

* **Thread Communication:** I learned how to use a `SynchronousQueue` to facilitate communication between threads. A `SynchronousQueue` is a blocking queue where each insert operation must wait for a corresponding remove operation by another thread, and vice versa. This enforces a strict handoff between threads.

* **Producer-Consumer Pattern:** This exercise demonstrates a simple Producer-Consumer pattern. The "Egg" thread acts as a producer, placing "Egg" messages into the queue. The "Hen" thread acts as a consumer, taking "Egg" messages from the queue and producing "Hen" messages, which are then placed back into the queue.

* **Thread Synchronization (SynchronousQueue):** The `SynchronousQueue` inherently provides thread synchronization. It ensures that the "Egg" and "Hen" threads take turns, effectively orchestrating the order of message printing.

* **Command-Line Arguments and Error Handling:** The program continues to use command-line arguments and includes error handling for invalid input.

## Code Explanation


### `MyThread_Egg` Class

The `MyThread_Egg` class represents the "Egg" thread. It produces "Egg" messages and puts them into the `SynchronousQueue`.

### `MyThread_Hen` Class

The `MyThread_Hen` class represents the "Hen" thread. It takes "Egg" messages from the `SynchronousQueue`, prints "Hen", and then puts "Hen" messages back into the queue.

### `Program` Class

The `Program` class is the main entry point. It parses command-line arguments, creates the `SynchronousQueue` and `SharedData` object, starts the "Egg" and "Hen" threads, waits for them to finish, and then prints "Human" messages.