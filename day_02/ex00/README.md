# Module 02 - Piscine Java IO, Files - Exercise 00

This exercise focuses on Java Input/Output (I/O) operations and file handling. The goal is to create a program that analyzes file signatures (magic numbers) to identify file types.

## Learning Objectives

This exercise helped me understand and practice the following concepts:

*   **Java I/O Streams:** Working with `FileInputStream`, `FileOutputStream`, `InputStreamReader`, `BufferedReader`, and `Scanner` for reading from and writing to files and standard input.  This includes understanding the difference between byte streams (`FileInputStream`, `FileOutputStream`) and character streams (`InputStreamReader`, `BufferedReader`).
*   **File Handling:** Reading file content, handling file paths (including absolute paths), and processing file signatures (magic numbers).
*   **Character Encoding:** The crucial importance of specifying character encoding (using `StandardCharsets.UTF_8`) when working with text files to avoid character encoding issues.  This ensures that characters are read and written correctly, especially when dealing with non-ASCII characters.
*   **Data Structures:** Using `HashMap` to store file type signatures efficiently, allowing for quick lookups.
*   **String Manipulation:** Converting byte arrays to hexadecimal strings, removing whitespace from strings, and using string methods for comparing file signatures.
*   **Error Handling:** Using `try-catch` blocks to handle potential `IOExceptions` (e.g., file not found, read/write errors).  Proper error handling is essential for creating robust applications.
*   **Control Flow:** Using loops (`while`) and conditional statements (`if`) to process input, compare signatures, and write results.
*   **Command-Line Input/Output:** Reading input from the command line using `Scanner` and writing output to the console and a file.
*   **File Appending:** Using `FileOutputStream` in append mode (with the `true` argument) to add file types to the `result.txt` file without overwriting previous results.
*   **Hexadecimal Conversion:** Understanding how to represent bytes in hexadecimal format and implementing a method to convert byte arrays to their hexadecimal string representation.
*   **Algorithm Design:** Developing a simple algorithm to compare file signatures with stored magic numbers.
*   **Testing:**  Running the program with different input files and signature definitions to verify its correctness.

## Code Explanation

### `ReadFile` Class

The `ReadFile` class handles the core logic of the file signature analysis application. It reads file type signatures from a "signatures.txt" file, accepts file paths from the user, compares the file signatures with the stored magic numbers, and writes the identified file types to the "result.txt" file.  It also handles potential I/O exceptions and outputs "UNDEFINED" if a file's signature is not recognized or if there's an error reading the file.
