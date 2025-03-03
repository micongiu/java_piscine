package day_03.ex03;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Class to manage a thread pool for downloading URLs.
public class ThreadPoolManager {

	// Method to execute download tasks using a thread pool.
	public void executeDownloadTasks(int threadsCount, Map<Integer, String> urls) {
		ExecutorService executor = Executors.newFixedThreadPool(threadsCount);
		SharedCounter counter = new SharedCounter();

		for (int threadId = 0; threadId < threadsCount; threadId++) {
			executor.submit(new DownloadUrl(threadId, urls, counter));
		}
	}
}