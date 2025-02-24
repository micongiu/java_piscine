package day_03.ex01;

// This class represents the "Hen" thread. It consumes "Egg" messages from
// the SynchronousQueue and produces "Hen" messages, placing them back
// into the queue for the "Egg" thread to consume.
import java.util.concurrent.SynchronousQueue;

class MyThread_Hen extends Thread {
    private final SharedData sharedData;
    private final String message;
    private final SynchronousQueue<String> queue;

    public MyThread_Hen(SharedData sharedData, String message, SynchronousQueue<String> queue) {
        this.sharedData = sharedData;
        this.message = message;
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < sharedData.counter; i++) {
            try {
				String response = queue.take();
                System.out.println(response);
                queue.put(message);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

