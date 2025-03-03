package day_03.ex03;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

// Main program class to handle command-line arguments and start the download process.
public class Program {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		if (args.length == 0 || (args.length == 1 && args[0].equals("--help"))){
			System.out.println("Usage: java day_03.ex03.Program --threadsCount=<number>");
			System.out.println("  --threadsCount=<number>: Specifies the number of threads to use.");
			System.exit(-1);
		}

		int threadsCount = ReadFromArgs(args);

		if (threadsCount < 1) {
			System.err.println("Error: Both --count and --threadsCount must be positive integers.");
			System.exit(-1);
		}

		ReadUrls test = new ReadUrls();
		Map<Integer, String> urlsMap = test.ReadFile("/home/orobianco/Desktop/java_piscine/day_03/ex03/files_urls.txt");
		ThreadPoolManager manager = new ThreadPoolManager();
		manager.executeDownloadTasks(threadsCount, urlsMap);
	}

	// This method parses command-line arguments to extract threadsCount.
	public static int ReadFromArgs(String[] args) {
		int count = 0;

		for (String arg : args) {
			if (arg.startsWith("--threadsCount=")) {
				try {
					String value = arg.substring("--threadsCount=".length());
					count = Integer.parseInt(value);
				} catch (NumberFormatException e) {
					System.err.println("Invalid threadsCount value: " + arg);
					System.exit(-1);
				}
			}
		}
		return count;
	}
}