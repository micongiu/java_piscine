package day_00.ex01;

import java.util.Scanner;

/*
* This program determines if a given integer is a prime number.
* It takes an integer as input from the user, checks for invalid input (numbers <= 1),
* and then uses an optimized primality test (checking divisibility up to the square root
* of the number) to determine if the number is prime. It prints "true" or "false"
* along with the number of iterations required for the check.
*/

public class Program {

	/**
	 * This function checks if a number is prime and returns the number of iterations.
	 * @param number The number to check for primality.
	 * @return The number of iterations performed during the primality test.
	 */

	public static int its_prime(int number) {
		int iterations = 0;
		int limit = (int) Math.sqrt(number);

		for (int i = 2; i <= limit; i++) {
			iterations++;
			if (number % i == 0){
				System.out.print("false ");
				return (iterations);
			}
		}
		System.out.print("true ");
		return (iterations);
	}
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			int number = input.nextInt();
			if (number <= 1) {
				System.err.println("theIllegalArgument");
				System.exit(-1);
			}
			System.out.println(its_prime(number));
			input.close();
		} catch(Exception e) {
			System.err.println("Error in the reading " + e);
			System.exit(-1);
		}
	}
}