package day_03.ex01;

// This class represents the "Egg" thread. It produces "Egg" messages and
// places them in a SynchronousQueue for the "Hen" thread to consume.
import java.util.concurrent.SynchronousQueue;

class MyThread_Egg extends Thread {
    private final SharedData sharedData;
    private final String message;
    private final SynchronousQueue<String> queue;

    public MyThread_Egg(SharedData sharedData, String message, SynchronousQueue<String> queue) {
        this.sharedData = sharedData;
        this.message = message;
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < sharedData.counter; i++) {
            try {
                queue.put(message);
                String response = queue.take();
                System.out.println(response);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

