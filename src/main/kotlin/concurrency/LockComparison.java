package concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class LockComparison {

    // 테스트 설정
    private static final int INITIAL_STOCK = 100_000_000;  // 초기 재고 100만개
    private static final int THREAD_COUNT = 200;        // 20개 스레드
    private static final int OPERATIONS_PER_THREAD = 10000; // 스레드당 1000번 작업
    private static final int AMOUNT_PER_ORDER = 10;    // 주문당 10개

    // 0. Lock 없는 버전 (동시성 문제 발생!)
    static class NoLockCounter {
        private final Map<String, Integer> data = new HashMap<>();
        private int sharedResource = INITIAL_STOCK;
        private final AtomicInteger successCount = new AtomicInteger(0);
        private final AtomicInteger failCount = new AtomicInteger(0);

        public void processOrder(String key, int amount) {
            // Race condition 발생!
            if (sharedResource >= amount) {
                sharedResource -= amount;
                data.put(key, data.getOrDefault(key, 0) + amount);
                successCount.incrementAndGet();
            } else {
                failCount.incrementAndGet();
            }
        }

        public void printStats() {
            int totalSold = data.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("최종 재고: " + sharedResource);
            System.out.println("총 판매량: " + totalSold);
            System.out.println("성공 거래: " + successCount.get() + ", 실패 거래: " + failCount.get());
            if (sharedResource < 0 || totalSold > INITIAL_STOCK) {
                System.out.println("❌ 동시성 문제 발생! 데이터 불일치!");
            }
        }
    }

    // 1. Sequential Lock (전역 lock 하나)
    static class SequentialCounter {
        private final Map<String, Integer> data = new HashMap<>();
        private final ReentrantLock lock = new ReentrantLock();
        private int sharedResource = INITIAL_STOCK;
        private final AtomicInteger successCount = new AtomicInteger(0);
        private final AtomicInteger failCount = new AtomicInteger(0);

        public void processOrder(String key, int amount) {
            lock.lock();
            try {
                if (sharedResource >= amount) {
                    sharedResource -= amount;
                    data.put(key, data.getOrDefault(key, 0) + amount);
                    successCount.incrementAndGet();
                } else {
                    failCount.incrementAndGet();
                }
            } finally {
                lock.unlock();
            }
        }

        public void printStats() {
            int totalSold = data.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("최종 재고: " + sharedResource);
            System.out.println("총 판매량: " + totalSold);
            System.out.println("성공 거래: " + successCount.get() + ", 실패 거래: " + failCount.get());
            if (totalSold + sharedResource == INITIAL_STOCK) {
                System.out.println("✅ 정상 동작! 데이터 일치!");
            }
        }
    }

    // 2. Key-based Lock (key별 lock) - 공유 자원용 별도 lock 추가
    static class KeyBasedCounter {
        private final Map<String, Integer> data = new ConcurrentHashMap<>();
        private final Map<String, ReentrantLock> locks = new ConcurrentHashMap<>();
        private final ReentrantLock stockLock = new ReentrantLock(); // 재고용 lock 추가!
        private int sharedResource = INITIAL_STOCK;
        private final AtomicInteger successCount = new AtomicInteger(0);
        private final AtomicInteger failCount = new AtomicInteger(0);

        public void processOrder(String key, int amount) {
            ReentrantLock keyLock = locks.computeIfAbsent(key, k -> new ReentrantLock());

            // 재고 확인과 차감은 stockLock으로 보호
            boolean canProcess = false;
            stockLock.lock();
            try {
                if (sharedResource >= amount) {
                    sharedResource -= amount;
                    canProcess = true;
                    successCount.incrementAndGet();
                } else {
                    failCount.incrementAndGet();
                }
            } finally {
                stockLock.unlock();
            }

            // key별 데이터 업데이트는 keyLock으로 보호
            if (canProcess) {
                keyLock.lock();
                try {
                    data.put(key, data.getOrDefault(key, 0) + amount);
                } finally {
                    keyLock.unlock();
                }
            }
        }

        public void printStats() {
            int totalSold = data.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("최종 재고: " + sharedResource);
            System.out.println("총 판매량: " + totalSold);
            System.out.println("성공 거래: " + successCount.get() + ", 실패 거래: " + failCount.get());
            if (totalSold + sharedResource == INITIAL_STOCK) {
                System.out.println("✅ 정상 동작! 데이터 일치!");
            }
        }
    }

    // 3. 진짜 Key-based 시나리오 (key별 독립 재고)
    static class TrueKeyBasedCounter {
        private final Map<String, Integer> stockPerKey = new ConcurrentHashMap<>();
        private final Map<String, Integer> salesPerKey = new ConcurrentHashMap<>();
        private final Map<String, ReentrantLock> locks = new ConcurrentHashMap<>();
        private final AtomicInteger successCount = new AtomicInteger(0);
        private final AtomicInteger failCount = new AtomicInteger(0);

        public TrueKeyBasedCounter() {
            // 각 key별로 독립적인 재고 할당
            for (int i = 0; i < THREAD_COUNT; i++) {
                stockPerKey.put("Customer" + i, INITIAL_STOCK / THREAD_COUNT);
            }
        }

        public void processOrder(String key, int amount) {
            ReentrantLock keyLock = locks.computeIfAbsent(key, k -> new ReentrantLock());

            keyLock.lock();
            try {
                int currentStock = stockPerKey.getOrDefault(key, 0);
                if (currentStock >= amount) {
                    stockPerKey.put(key, currentStock - amount);
                    salesPerKey.put(key, salesPerKey.getOrDefault(key, 0) + amount);
                    successCount.incrementAndGet();
                } else {
                    failCount.incrementAndGet();
                }
            } finally {
                keyLock.unlock();
            }
        }

        public void printStats() {
            int totalStock = stockPerKey.values().stream().mapToInt(Integer::intValue).sum();
            int totalSold = salesPerKey.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("총 남은 재고: " + totalStock);
            System.out.println("총 판매량: " + totalSold);
            System.out.println("성공 거래: " + successCount.get() + ", 실패 거래: " + failCount.get());
            if (totalStock + totalSold == INITIAL_STOCK) {
                System.out.println("✅ 정상 동작! 데이터 일치!");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 대규모 성능 테스트 ===");
        System.out.println("설정: " + THREAD_COUNT + "개 스레드, 각 " + OPERATIONS_PER_THREAD + "번 작업");
        System.out.println("총 작업 수: " + (THREAD_COUNT * OPERATIONS_PER_THREAD) + "번");
        System.out.println("초기 재고: " + INITIAL_STOCK + "개\n");

        // 1. No Lock 테스트
        System.out.println("1️⃣ No Lock Test (빠르지만 데이터 오류)");
        System.out.println("----------------------------------------");
        long noLockTime = testNoLock();
        System.out.println("실행 시간: " + noLockTime + "ms\n");

        Thread.sleep(500);

        // 2. Sequential Lock 테스트
        System.out.println("2️⃣ Sequential Lock Test (느리지만 안전)");
        System.out.println("----------------------------------------");
        long seqTime = testSequential();
        System.out.println("실행 시간: " + seqTime + "ms\n");

        Thread.sleep(500);

        // 3. Key-based Lock with Stock Lock 테스트
        System.out.println("3️⃣ Key-based Lock + Stock Lock (중간 성능, 안전)");
        System.out.println("----------------------------------------");
        long keyBasedTime = testKeyBased();
        System.out.println("실행 시간: " + keyBasedTime + "ms\n");

        Thread.sleep(500);

        // 4. True Key-based (독립 재고) 테스트
        System.out.println("4️⃣ True Key-based Lock (key별 독립 재고, 최고 성능)");
        System.out.println("----------------------------------------");
        long trueKeyBasedTime = testTrueKeyBased();
        System.out.println("실행 시간: " + trueKeyBasedTime + "ms\n");

        // 성능 비교 요약
        System.out.println("\n=== 🏁 성능 비교 요약 ===");
        System.out.println("No Lock:                " + noLockTime + "ms (기준)");
        System.out.println("Sequential Lock:        " + seqTime + "ms (x" + String.format("%.1f", (double) seqTime / noLockTime) + " 느림)");
        System.out.println("Key-based + Stock Lock: " + keyBasedTime + "ms (x" + String.format("%.1f", (double) keyBasedTime / noLockTime) + " 느림)");
        System.out.println("True Key-based:         " + trueKeyBasedTime + "ms (x" + String.format("%.1f", (double) trueKeyBasedTime / noLockTime) + " 느림)");

        System.out.println("\n💡 결론:");
        System.out.println("- Sequential Lock은 가장 느리지만 공유 자원을 안전하게 보호");
        System.out.println("- Key-based Lock은 독립적인 작업에서 " + String.format("%.1f", (double) seqTime / trueKeyBasedTime) + "배 빠름!");
    }

    private static long testNoLock() throws InterruptedException {
        NoLockCounter counter = new NoLockCounter();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            final String customer = "Customer" + i;
            executor.submit(() -> {
                try {
                    startLatch.await();
                    for (int j = 0; j < OPERATIONS_PER_THREAD; j++) {
                        counter.processOrder(customer, AMOUNT_PER_ORDER);
                    }
                    endLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        long startTime = System.currentTimeMillis();
        startLatch.countDown();
        endLatch.await();
        long endTime = System.currentTimeMillis();

        executor.shutdown();
        counter.printStats();

        return endTime - startTime;
    }

    private static long testSequential() throws InterruptedException {
        SequentialCounter counter = new SequentialCounter();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            final String customer = "Customer" + i;
            executor.submit(() -> {
                try {
                    startLatch.await();
                    for (int j = 0; j < OPERATIONS_PER_THREAD; j++) {
                        counter.processOrder(customer, AMOUNT_PER_ORDER);
                    }
                    endLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        long startTime = System.currentTimeMillis();
        startLatch.countDown();
        endLatch.await();
        long endTime = System.currentTimeMillis();

        executor.shutdown();
        counter.printStats();

        return endTime - startTime;
    }

    private static long testKeyBased() throws InterruptedException {
        KeyBasedCounter counter = new KeyBasedCounter();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            final String customer = "Customer" + i;
            executor.submit(() -> {
                try {
                    startLatch.await();
                    for (int j = 0; j < OPERATIONS_PER_THREAD; j++) {
                        counter.processOrder(customer, AMOUNT_PER_ORDER);
                    }
                    endLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        long startTime = System.currentTimeMillis();
        startLatch.countDown();
        endLatch.await();
        long endTime = System.currentTimeMillis();

        executor.shutdown();
        counter.printStats();

        return endTime - startTime;
    }

    private static long testTrueKeyBased() throws InterruptedException {
        TrueKeyBasedCounter counter = new TrueKeyBasedCounter();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            final String customer = "Customer" + i;
            executor.submit(() -> {
                try {
                    startLatch.await();
                    for (int j = 0; j < OPERATIONS_PER_THREAD; j++) {
                        counter.processOrder(customer, AMOUNT_PER_ORDER);
                    }
                    endLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        long startTime = System.currentTimeMillis();
        startLatch.countDown();
        endLatch.await();
        long endTime = System.currentTimeMillis();

        executor.shutdown();
        counter.printStats();

        return endTime - startTime;
    }
}
