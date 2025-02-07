package day_00.ex00;

/*
* This program calculates the sum of the digits of a given integer.
* It converts the integer to a string, iterates through the characters
* representing the digits, and adds their numeric values to compute the sum.
*/

public class Program {

	public static void main(String[] args) {
		int number = 479598;
		int sum = 0;

		String numStr = String.valueOf(number);
		for (char digit : numStr.toCharArray()) {
			sum += Character.getNumericValue(digit);
		}
		System.out.println("Sum of digits: " + sum);
	}
}