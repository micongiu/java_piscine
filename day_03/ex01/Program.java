package day_03.ex01;

import java.util.concurrent.SynchronousQueue;

// This is the main program class. It parses command-line arguments,
// creates the threads, and controls their execution.
public class Program {

	public static void main(String[] args) throws InterruptedException {
		int count = ReadFromArgs(args);
		SynchronousQueue<String> queue = new SynchronousQueue<>();
		SharedData sharedData = new SharedData(count);
		
		MyThread_Egg egg = new MyThread_Egg(sharedData, "Egg", queue);
		MyThread_Hen hen = new MyThread_Hen(sharedData, "Hen", queue);


		egg.start();
		hen.start();

		egg.join();
		hen.join();

		for (int i = 0; i < count; i++) {
			System.out.println("Human");
		}
	}
	
	// This method reads the "--count" argument from the command line.
	public static int ReadFromArgs(String[] args) {
		int count = 0;

		for (String arg : args) {
			if (arg.startsWith("--count=")) {
				try {
					String value = arg.substring("--count=".length());
					count = Integer.parseInt(value);
				} catch (NumberFormatException e) {
					System.err.println("Invalid count value: " + arg);
					System.exit(1);
				}
				break;
			}
		}
		return count;
	}
}