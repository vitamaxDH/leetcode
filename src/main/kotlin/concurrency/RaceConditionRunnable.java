package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionRunnable {
    private static AtomicInteger counter = new AtomicInteger(); // 동기화 없음 → lost update 발생

    public static void main(String[] args) throws InterruptedException {
        final int totalOps = 1_000_000;
        final int threads = 4;
        final int perThread = totalOps / threads;

        Runnable task = () -> {
            System.out.println(Thread.currentThread() + " is executed");
            for (int i = 0; i < perThread; i++) {
                counter.incrementAndGet(); // non-atomic
            }
            System.out.println(Thread.currentThread() + " is done");
        };

        Thread[] ts = new Thread[threads];
        for (int i = 0; i < threads; i++) {
            ts[i] = new Thread(task, "t-" + i);
            ts[i].start();
        }
        for (Thread t : ts) t.join();

        System.out.println("Expected: " + totalOps);
        System.out.println("Actual  : " + counter); // 종종 1,000,000보다 작게 출력됨
    }
}
