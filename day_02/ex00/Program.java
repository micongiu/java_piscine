package day_02.ex00;

// The `Program` class is the entry point of the application.
// It creates a `ReadFile` object, passing the path to the signatures file,
// which initiates the file signature analysis process.
public class Program {

	public static void main(String[] args) {
		String signaturesFilePath = "/home/orobianco/Desktop/java_piscine/day_02/ex00/signatures.txt"; // Your path

		ReadFile signatures = new ReadFile(signaturesFilePath);
	}
}