package day_03.ex03;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

// DownloadUrl class implements Runnable to download files from URLs.
public class DownloadUrl implements Runnable {

	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	private final int threadId;
	private final Map<Integer, String> urls;
	private final SharedCounter counter;

	// Constructor to initialize DownloadUrl with threadId, urls, and counter.
	public DownloadUrl(int threadId, Map<Integer, String> urls, SharedCounter counter) {
		this.threadId = threadId;
		this.urls = urls;
		this.counter = counter;
	}

	// run method to execute the download task.
	@Override
	public void run() {
		while (true) {
			int index;
			String url_s;

			synchronized (counter) {
				index = counter.getNextIndex();
				url_s = urls.get(index);
				if (url_s == null) {
					return;
				}
				counter.increment();
			}

			System.out.println(ANSI_YELLOW + "Thread-" + threadId + " start download file number " + index);
			URL url;
			try {
				url = new URL(url_s);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");

				if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
					String fileExtension = getFileExtension(url_s);
					String fileName = index + "." + fileExtension;

					try (BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
						FileOutputStream out = new FileOutputStream(fileName)) {

						byte[] buffer = new byte[1024];
						int bytesRead;
						while ((bytesRead = in.read(buffer)) != -1) {
							out.write(buffer, 0, bytesRead);
						}
						System.out.println(ANSI_GREEN + "Thread-" + threadId + " finish download file number " + index + " to " + fileName);
					}
				} else {
					System.err.println("Thread-" + threadId + " download failed for " + url_s + ": " + connection.getResponseCode());
				}
				connection.disconnect();

			} catch (MalformedURLException e) {
				System.err.println("Thread-" + threadId + " Malformed URL: " + url_s);
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("Thread-" + threadId + " IO Exception for " + url_s);
				e.printStackTrace();
			}
		}
	}

	// getFileExtension method to extract the file extension from the URL.
	private String getFileExtension(String url) {
		int lastDotIndex = url.lastIndexOf('.');
		if (lastDotIndex != -1 && lastDotIndex < url.length() - 1) {
			return url.substring(lastDotIndex + 1);
		}

		return "bin";
	}
}