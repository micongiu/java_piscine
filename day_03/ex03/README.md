# Module 03 - Piscine Java Threads - Exercise 03

This exercise focuses on using multithreading to download files from a network efficiently. The goal is to create a thread pool that downloads a list of files concurrently, ensuring that threads are reused and the number of active threads is controlled.

## Learning Objectives

This exercise helped me understand and practice the following concepts:

* **File I/O:** I practiced reading URLs from a file and writing downloaded data to local files.
* **Networking (HttpURLConnection):** I learned how to use `HttpURLConnection` to download files from URLs.
* **Command-Line Arguments and Input Validation:** I practiced parsing command-line arguments and validating user inputs to ensure the program receives valid data.
* **Error Handling:** I implemented exception handling to gracefully manage potential issues such as malformed URLs and I/O exceptions.
* **File Extension Extraction:** I learned how to extract file extensions from URLs to properly name downloaded files.
* **Thread Safety:** I learned how to ensure thread safety when accessing shared resources by using synchronized blocks.

## Code Explanation

### `DownloadUrl` Class

The `DownloadUrl` class implements the `Runnable` interface. Each instance is responsible for downloading a file from a URL.

### `Program` Class

The `Program` class is the main entry point of the application.

### `ReadUrls` Class

The `ReadUrls` class is responsible for reading URLs from a file.

### `SharedCounter` Class

The `SharedCounter` class provides a thread-safe counter for managing the download queue.

### `ThreadPoolManager` Class

The `ThreadPoolManager` class manages the thread pool for downloading files.