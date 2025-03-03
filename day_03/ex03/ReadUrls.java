package day_03.ex03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

// Class to read URLs from a file and store them in a map.
public class ReadUrls {

	public ReadUrls() {

	}

	// Method to read URLs from a file and return a map of index to URL.
	public Map<Integer, String> ReadFile(String urlsFilePath) throws FileNotFoundException, IOException {

		try (FileInputStream fis = new FileInputStream(urlsFilePath);
			InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			BufferedReader br = new BufferedReader(isr)) {

			Map<Integer, String> urls = new HashMap<>();
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(" ");
				if (parts.length == 2) {
					Integer index = Integer.valueOf(parts[0].trim());
					String url = parts[1].trim().replaceAll("\\s", "");
					urls.put(index, url);
				} else {
					System.err.println("Invalid line format: " + line);
				}
			}
			return urls;
		}
	}
}
