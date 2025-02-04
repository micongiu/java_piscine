package day_00.ex00;

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