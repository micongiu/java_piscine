# Learning Java Basics through Simple Programs

This repository contains two simple Java programs designed to illustrate fundamental concepts in programming, specifically within the Java language.  These examples are suitable for beginners learning the basics of Java syntax, data types, operators, control flow, and input/output.

## `day_00.ex00`: Summing Digits of a Number

This program demonstrates the following concepts:

* **Data Types:** Working with integers (`int`) and strings (`String`).
* **Type Conversion:** Converting an integer to a string using `String.valueOf()`.
* **String Manipulation:** Iterating over the characters of a string using `toCharArray()` and a for-each loop.
* **Character Handling:** Extracting the numeric value of a character using `Character.getNumericValue()`.
* **Basic Arithmetic:** Performing addition to calculate the sum of digits.
* **Output:** Printing the result to the console using `System.out.println()`.

By studying this example, you can learn how to manipulate numbers as strings, extract individual digits, and perform basic calculations.

## `day_00.ex01`: Primality Test

This program implements a primality test, illustrating these concepts:

* **Input:** Reading integer input from the user using `Scanner`.
* **Error Handling:** Using a `try-catch` block to handle potential exceptions during input (e.g., non-integer input).  Specifically, catching `InputMismatchException` for incorrect input types.
* **Conditional Statements:** Using `if` statements to check for invalid input (numbers less than or equal to 1).
* **Functions/Methods:** Defining and calling a function `its_prime()` to encapsulate the primality checking logic.
* **Loops:** Using a `for` loop to iterate and check for divisors.
* **Mathematical Functions:** Using `Math.sqrt()` to optimize the primality test (checking only up to the square root of the number).
* **Boolean Logic:** Implicitly using boolean logic within the `if` condition to determine if a number is prime.
* **Output:** Printing the result ("true" or "false") and the number of iterations to the console.
* **Return Values:** Returning a value (number of iterations) from a function.
* **System Exit:** Using `System.exit()` to terminate the program with an error code in case of invalid input.
* **Error Stream:** Using `System.err` to output error messages.

This example teaches how to write functions, handle user input, implement a basic algorithm, and optimize it using mathematical insights.  It also demonstrates good error-handling practices.

## How to Compile and Run

These programs can be compiled and run after cloning the repository to your local machine.

1. **Clone the Repository:**
   Open a terminal or command prompt and use the following command to clone the repository:

   ```bash
   git clone <repository_url>
   cd <repository_url>
2.  **Compile:** Open a terminal or command prompt, navigate to the directory containing the `.java` file, and compile using the Java compiler:
    ```bash
    javac day_00/ex00/Program.java  # For ex00
    javac day_00/ex01/Program.java  # For ex01
    ```
3.  **Run:** After successful compilation, run the program using the Java interpreter:
    ```bash
    java day_00.ex00.Program       # For ex00
    java day_00.ex01.Program       # For ex01
    ```
