package day_02.ex00;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// The `ReadFile` class handles the core logic of reading the signatures file,
// accepting file paths from the user, comparing file signatures, and writing
// the results to the "result.txt" file.
public class ReadFile {
	private static final char[] HEX = "0123456789ABCDEF".toCharArray();

	// Converts a byte array to its hexadecimal string representation.
	// @param bytes The byte array to convert.
	// @return The hexadecimal string representation of the byte array.
	private static String bytesToHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];

		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = HEX[v >>> 4];
			hexChars[j * 2 + 1] = HEX[v & 0x0F];
		}
		return new String(hexChars);
	}

	// Constructor for the `ReadFile` class.
	// Reads the signatures from the specified file and processes user input.
	// @param signaturesFilePath The path to the signatures file.
	public ReadFile(String signaturesFilePath) {

		try (FileInputStream fis = new FileInputStream(signaturesFilePath);
			InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			BufferedReader br = new BufferedReader(isr)) {

			Map<String, String> signatures = new HashMap<>();
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 2) {
					String fileType = parts[0].trim();
					String magicNumber = parts[1].trim().replaceAll("\\s", "");
					signatures.put(fileType, magicNumber);
				} else {
					System.err.println("Invalid line format: " + line);
				}
			}

			try (Scanner scanner = new Scanner(System.in)) {
				String fileHeader;
				while (true) {
					fileHeader = scanner.nextLine().trim();
					if (fileHeader.equals("42")) {
						break;
					}

					try (FileInputStream inputFile = new FileInputStream(fileHeader)) {
						byte[] bytes = new byte[8];
						int bytesRead = inputFile.read(bytes, 0, 8);

						if (bytesRead != 8) {
							System.out.println("UNDEFINED");
							continue;
						}

						String fileSignature = bytesToHex(bytes);
						boolean found = false;

						for (Map.Entry<String, String> entry : signatures.entrySet()) {
							String fileType = entry.getKey();
							String magicNumber = entry.getValue();

							if (fileSignature.startsWith(magicNumber)) {
								System.out.println("PROCESSED");
								try (FileOutputStream fos = new FileOutputStream("result.txt", true)) {
									fos.write(fileType.getBytes(StandardCharsets.UTF_8));
									fos.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
								} catch (IOException e) {
									System.err.println("Error appending to the file: " + e.getMessage());
								}
								found = true;
								break;
							}
						}
						if (!found) {
							System.out.println("UNDEFINED");
						}

					} catch (IOException error) {
						System.err.println("File not found: " + fileHeader);
						System.out.println("UNDEFINED");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}