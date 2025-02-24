# Module 03 - Piscine Java Threads - Exercise 02

This exercise focuses on using multithreading to distribute computations, specifically summing elements of a large array. The goal is to calculate the sum of array elements using multiple threads, each computing a segment of the array.

## Learning Objectives

This exercise helped me understand and practice the following concepts:

*   **Thread Pools (ExecutorService):** I learned how to use `ExecutorService` to create and manage a thread pool. This allows for efficient execution of multiple tasks concurrently.
*   **Runnable Interface:** I implemented the `Runnable` interface in the `SumTask` class to define tasks that can be executed by threads in the thread pool.
*   **Atomic Variables (AtomicInteger):** I used `AtomicInteger` to safely accumulate the sum of array elements across multiple threads. This avoids race conditions and ensures thread safety.
*   **Array Segmentation:** I learned how to divide a large array into smaller segments and assign each segment to a thread for parallel processing.
*   **Command-Line Arguments and Input Validation:** I practiced parsing command-line arguments and validating user inputs to ensure the program receives valid data.
*   **Thread Termination and Exception Handling:** I learned how to properly shut down the thread pool and handle potential `InterruptedException` during task execution.
*   **Random Array Generation:** I implemented a method to generate a random array of integers with specified size and maximum value.

## Code Explanation

### `Program` Class

The `Program` class is the main entry point. It parses command-line arguments, generates a random array, and manages the thread pool.

### `SumTask` Class

The `SumTask` class implements the `Runnable` interface. Each instance computes the sum of a segment of the array and updates the shared `AtomicInteger`.

### `ThreadPoolManager` Class

The `ThreadPoolManager` class creates and manages the thread pool. It divides the array into segments and submits `SumTask` instances to the pool.
