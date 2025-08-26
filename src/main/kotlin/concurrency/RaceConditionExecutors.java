package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionExecutors {
    private static final AtomicInteger counter = new AtomicInteger(); // 동기화 없음 → lost update 발생

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final int totalOps = 1_000_000;
        final int threads = 4;
        final int perTask = totalOps / threads;

        ExecutorService pool = Executors.newFixedThreadPool(threads);
        List<Callable<Void>> tasks = new ArrayList<>();

        for (int i = 0; i < threads; i++) {
            tasks.add(() -> {
                for (int k = 0; k < perTask; k++) {
                    counter.getAndAdd(1); // non-atomic
                }
                return null;
            });
        }

        List<Future<Void>> futures = pool.invokeAll(tasks);
        for (Future<Void> f : futures) f.get(); // 완료 대기
        pool.shutdown();

        System.out.println("Expected: " + totalOps);
        System.out.println("Actual  : " + counter); // 종종 1,000,000보다 작게 출력됨
    }
}
