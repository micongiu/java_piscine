package day_03.ex00;

import java.util.concurrent.CountDownLatch;

// This is the main program class. It parses command-line arguments,
// creates the threads, and controls their execution.
public class Program {

	public static void main(String[] args) throws InterruptedException {
		int count = ReadFromArgs(args);
		CountDownLatch startLatch = new CountDownLatch(2);
		SharedData sharedData = new SharedData(count);
		MyThread egg = new MyThread(startLatch, sharedData, "Egg");
		MyThread hen = new MyThread(startLatch, sharedData, "Hen");

		egg.start();
		hen.start();

		startLatch.await();

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