package day_03.ex02;

import java.util.concurrent.atomic.AtomicInteger;

// This class represents a task that calculates the sum of a portion of an integer array.
// It implements the Runnable interface to be executed by a thread pool.
public class SumTask implements Runnable {

    private final int[] summingArray;
    private final AtomicInteger result;
    private final int start;
    private final int end;
    private final int threadId;

    public SumTask(int threadId, int start, int end, int[] summingArray, AtomicInteger result) { // Add threadId to constructor
        this.summingArray = summingArray;
        this.result = result;
        this.start = start;
        this.end = end;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int value : summingArray) {
            sum += value;
        }
        System.out.println("Thread " + threadId + ": from " + start + " to " + end + " is " + sum); // Use threadId
        result.addAndGet(sum);
    }
}