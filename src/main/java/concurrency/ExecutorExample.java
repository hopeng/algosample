package concurrency;

import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.out;

/**
 * Created by hopeng on 3/01/2016.
 */
public class ExecutorExample {

    private static AtomicInteger counter = new AtomicInteger();

    public static void main(String args[]) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Callable task = new CallableTask();
        Future future;

        future = executorService.submit(task);
        try {
            out.println("future return " + future.get());
        } catch (ExecutionException e) {
            out.println(e.getMessage());
        }

        future = executorService.submit(task);
        try {
            out.println("future return " + future.get());
        } catch (ExecutionException e) {
            out.println(e.getMessage());
        }

        future = executorService.submit(task);
        try {
            out.println("future return " + future.get());
        } catch (ExecutionException e) {
            out.println(e.getMessage());
        }

        future = executorService.submit(task);
        try {
            out.println("future return " + future.get());
        } catch (ExecutionException e) {
            out.println(e.getMessage());
        }

        executorService.shutdown();
        executorService.awaitTermination(100, TimeUnit.SECONDS);
    }

    static class CallableTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            if (counter.incrementAndGet() == 4) {
                throw new RuntimeException("failing at "+counter.get()+"th task intentionally");
            }
            out.printf("Running with count %s at %s\n", counter.get(), LocalDateTime.now());
            return String.valueOf(counter.get());
        }
    }
}
