package day_03.ex00;

// This class represents a thread that prints a specific message ("Egg" or "Hen")
// a certain number of times, as specified in the SharedData.
import java.util.concurrent.CountDownLatch;

class MyThread extends Thread {
	private final SharedData sharedData;
	private final CountDownLatch latch;
	private final String message;

	public MyThread(CountDownLatch latch, SharedData sharedData, String message) {
		this.sharedData = sharedData;
		this.latch = latch;
		this.message = message;
	}

	@Override
	public void run() {
		latch.countDown();
		try {
			latch.await();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		for (int i = 0; i < sharedData.counter; i++) {
			System.out.println(message);
		}
	}
}

