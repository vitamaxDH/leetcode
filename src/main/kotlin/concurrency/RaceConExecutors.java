package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceConExecutors {

    static AtomicInteger counter = new AtomicInteger();

    public static void main(String[] args) throws Throwable {
        int TOTAL_OPS = 1_000_000;
        int threads = 4;
        int perTasks = TOTAL_OPS / threads;

        List<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < threads; i++) {
            tasks.add(() -> {
                for (int j = 0; j < perTasks; j++) {
                    counter.incrementAndGet();
                }
                return null;
            });
        }
        ExecutorService pool = Executors.newFixedThreadPool(threads);
        pool.invokeAll(tasks);
        pool.shutdown();
        System.out.println("expected: " + TOTAL_OPS);
        System.out.println("actual: " + counter);
    }
}
