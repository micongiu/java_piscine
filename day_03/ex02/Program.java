package day_03.ex02;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

// This class is the main entry point of the program. It parses command-line arguments,
// generates a random array of integers, and manages the execution of summing tasks
// using a thread pool.
public class Program {

	public static void main(String[] args) {

		if (args.length == 0 || (args.length == 1 && args[0].equals("--help"))){
			System.out.println("Usage: java day_03.ex02.Program --count=<number> --threadsCount=<number>");
			System.out.println("  --count=<number>: Specifies the number of random integers to generate.");
			System.out.println("  --threadsCount=<number>: Specifies the number of threads to use.");
			System.exit(-1);
		}
	
		int[] allData = ReadFromArgs(args);
	
		if (allData[1] < 1 || allData[0] < 1) {
			System.err.println("Error: Both --count and --threadsCount must be positive integers.");
			System.exit(-1);
		}
		if (allData[1] > allData[0]) {
			System.err.println("Error: --threadsCount cannot be greater than --count.");
			System.exit(-1);
		}
	
		int[] summingArray = generateRandomArray(allData[0], 1000);
		AtomicInteger result = new AtomicInteger(0);
	
		ThreadPoolManager manager = new ThreadPoolManager();
		manager.executeSumTasks(allData[1], summingArray, result);
	}

	 // This method parses command-line arguments to extract count and threadsCount.
	public static int[] ReadFromArgs(String[] args) {
		int[] count = {0, 0};

		for (String arg : args) {
			if (arg.startsWith("--count=")) {
				try {
					String value = arg.substring("--count=".length());
					count[0] = Integer.parseInt(value);
				} catch (NumberFormatException e) {
					System.err.println("Invalid count value: " + arg);
					System.exit(-1);
				}
			}
			if (arg.startsWith("--threadsCount=")) {
				try {
					String value = arg.substring("--threadsCount=".length());
					count[1] = Integer.parseInt(value);
				} catch (NumberFormatException e) {
					System.err.println("Invalid threadsCount value: " + arg);
					System.exit(-1);
				}
			}
		}
		return count;
	}

	// This method generates a random array of integers.
	public static int[] generateRandomArray(int size, int max) {
		Random random = new Random();

		int[] randomArray = new int[size];

		for (int i = 0; i < size; i++) {
			randomArray[i] = random.nextInt(max);
		}
		return randomArray;
	}
}
