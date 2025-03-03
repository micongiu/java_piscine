package day_03.ex03;

// Class to manage a shared counter for thread synchronization.
public class SharedCounter {
	private int index = 1;

	// Method to get the next index.
	public int getNextIndex() {
		return index;
	}

	// Method to increment the index.
	public void increment() {
		index++;
	}
}