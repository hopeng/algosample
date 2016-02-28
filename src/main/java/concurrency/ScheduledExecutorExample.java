package concurrency;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.out;

/**
 * Created by hopeng on 3/01/2016.
 */
public class ScheduledExecutorExample {

    private static AtomicInteger counter = new AtomicInteger();

    public static void main(String args[]) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        ScheduledFuture<?> future = scheduledExecutorService.scheduleAtFixedRate(new Task(), 1, 2, TimeUnit.SECONDS);

        try {
            Object ret = future.get();
            out.println("future return " + ret);
        } catch (ExecutionException e) {
            out.println(e.getMessage());
            scheduledExecutorService.shutdown();
            scheduledExecutorService.awaitTermination(100, TimeUnit.SECONDS);
        }
    }


    static class Task implements Runnable {
        @Override
        public void run() {
            if (counter.incrementAndGet() == 10) {
                throw new RuntimeException("failing at 10th task intentionally");
            }
            out.printf("Running with count %s at %s\n", counter.get(), LocalDateTime.now());
        }
    }


}
