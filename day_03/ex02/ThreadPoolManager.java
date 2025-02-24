package day_03.ex02;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// This class manages a thread pool to execute summing tasks.
// It divides the array into segments and assigns each segment to a thread.
public class ThreadPoolManager {

    public void executeSumTasks(int numberOfTasks, int[] summingArray, AtomicInteger result) {
        ExecutorService executor = Executors.newFixedThreadPool(numberOfTasks);

        int arraySize = summingArray.length / numberOfTasks;
        int lastSize = summingArray.length % numberOfTasks;
        int start = 0;
        int end = arraySize;

        for (int threadId = 0; threadId < numberOfTasks; threadId++) {
            if (threadId == numberOfTasks - 1 && lastSize != 0) {
                executor.submit(new SumTask(threadId, start, summingArray.length, Arrays.copyOfRange(summingArray, start, summingArray.length), result));
            } else {
                executor.submit(new SumTask(threadId, start, end, Arrays.copyOfRange(summingArray, start, end), result));
                start += arraySize;
                end += arraySize;
            }
        }
        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.err.println("Tasks interrupted!");
            Thread.currentThread().interrupt();
			System.exit(-1);
        }
        System.out.println("Sum by threads: " + result);
    }
}