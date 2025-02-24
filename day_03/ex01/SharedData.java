package day_03.ex01;

// This class holds the shared data, specifically the counter value.
// It's designed to be immutable after initialization.
class SharedData {
	public final int counter;

	public SharedData(int initialValue) {
		this.counter = initialValue;
	}
}
