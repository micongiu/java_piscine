# Module 03 - Piscine Java Threads - Exercise 00

This exercise explores the basics of multithreading in Java. The goal is to create a program that uses multiple threads to print messages concurrently ("Egg" and "Hen"), ensuring that the main thread's output ("Human") is printed only *after* the other threads have finished their execution.

## Learning Objectives

This exercise helped me understand and practice the following concepts:

*   **Thread Creation:**  I learned how to create and start threads in Java by extending the `Thread` class.  This involved defining the `run()` method, which contains the code that each thread will execute.
*   **Shared Data and Immutability:** I used a `SharedData` class to hold the number of iterations for the threads.  Crucially, I made the `counter` variable `final`. This ensures that it's immutable (cannot be changed) after initialization, which is essential for thread safety in this read-only scenario.  Immutable data doesn't require synchronization.
*   **Thread Synchronization (CountDownLatch):** I used a `CountDownLatch` to synchronize the *start* of the "Egg" and "Hen" threads.  The latch is initialized with a count of 2. Each thread counts down the latch when it's ready to run. The main thread waits on the latch to reach zero, ensuring that both threads have started their execution before the main thread proceeds. This latch also used to wait the end of the threads.
*   **Thread Joining (`join()`):** I learned how to use the `join()` method to make the main thread wait for the "Egg" and "Hen" threads to *complete* their execution before the main thread proceeds.  This is absolutely vital to ensure that the "Human" messages are printed only *after* the other threads have finished.
*   **Command-Line Arguments:** I practiced reading command-line arguments using the `args` array in the `main` method. This allows the user to specify the number of iterations for the threads using the `--count` flag.
*   **Error Handling:** I included error handling for invalid command-line arguments (non-integer values for `--count`) using a `try-catch` block and `System.exit()`.
*   **Concurrency and Interleaving:** By running the program multiple times, I observed how the output of the "Egg" and "Hen" threads is interleaved, demonstrating the concurrent nature of multithreading. The specific order of "Egg" and "Hen" messages will vary on each run due to the non-deterministic nature of thread scheduling.

## Code Explanation

### `SharedData` Class

The `SharedData` class is a simple container for the shared data, which, in this case, is the number of iterations (`counter`).  The `counter` is declared as `final` to make it immutable, ensuring thread safety since it is only read by the threads.

### `MyThread` Class

The `MyThread` class represents a thread that prints a specific message ("Egg" or "Hen") a certain number of times. It receives the `SharedData` object and the message to print in its constructor.  It uses the `CountDownLatch` to signal its readiness to start and to wait all thread start, and then iterates `sharedData.counter` times, printing the assigned message to the console.

### `Program` Class

The `Program` class is the main entry point of the application.  It parses the command-line arguments, creates the `SharedData` object, and instantiates the "Egg" and "Hen" threads. It starts the threads and waits for them to be ready using the latch. Then, it uses the `join()` method to wait for both threads to finish their execution. Finally, it prints the "Human" message the specified number of times. The `ReadFromArgs` method handles the parsing of the `--count` command-line argument.