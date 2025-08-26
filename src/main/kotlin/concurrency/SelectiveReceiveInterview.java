package concurrency;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Interview approach: Start simple, then add concurrency
 */
public class SelectiveReceiveInterview {

    // =========================
    // STEP 1: Non-concurrent version (interview starting point)
    // =========================
    public static class SimpleSelectiveReceive {
        private final Map<String, Queue<String>> tagQueues;

        public SimpleSelectiveReceive() {
            this.tagQueues = new HashMap<>();
        }

        public void send(String tag, String msg) {
            // Get existing queue or create new one
            tagQueues.computeIfAbsent(tag, k -> new LinkedList<>()).offer(msg);
        }

        public String receive(String[] tags) {
            if (tags.length == 0) {
                return null;
            }

            // Check each requested tag in order
            for (String tag : tags) {
                Queue<String> queue = tagQueues.get(tag);
                if (!queue.isEmpty()) {
                    return queue.poll();
                }
            }
            return null;
        }
    }

    // =========================
    // STEP 2: Thread-safe version (after discussing concurrency issues)
    // =========================
    public static class ConcurrentSelectiveReceive {
        private final Map<String, Queue<String>> tagQueues;
        private final ReentrantLock lock;

        public ConcurrentSelectiveReceive() {
            this.tagQueues = new HashMap<>();
            this.lock = new ReentrantLock();
        }

        public void send(String tag, String msg) {
            lock.lock();
            try {
                tagQueues.computeIfAbsent(tag, k -> new LinkedList<>()).offer(msg);
            } finally {
                lock.unlock();
            }
        }

        public String receive(String[] tags) {
            if (tags.length == 0) {
                return null;
            }

            lock.lock();
            try {
                for (String tag : tags) {
                    Queue<String> queue = tagQueues.get(tag);
                    if (queue != null && !queue.isEmpty()) {
                        return queue.poll();
                    }
                }
                return null;
            } finally {
                lock.unlock();
            }
        }
    }

    // =========================
    // STEP 3: Optimized version (if interviewer asks for improvements)
    // =========================
    public static class OptimizedSelectiveReceive {
        private final Map<String, ConcurrentLinkedQueue<String>> tagQueues;
        private final ReentrantLock lock;

        public OptimizedSelectiveReceive() {
            this.tagQueues = new HashMap<>();
            this.lock = new ReentrantLock();
        }

        public void send(String tag, String msg) {
            lock.lock();
            try {
                tagQueues.computeIfAbsent(tag, k -> new ConcurrentLinkedQueue<>()).offer(msg);
            } finally {
                lock.unlock();
            }
        }

        public String receive(String[] tags) {
            if (tags.length == 0) {
                return null;
            }

            lock.lock();
            try {
                for (String tag : tags) {
                    ConcurrentLinkedQueue<String> queue = tagQueues.get(tag);
                    if (!queue.isEmpty()) {
                        return queue.poll();
                    }
                }
                return null;
            } finally {
                lock.unlock();
            }
        }
    }

    // =========================
    // Test all versions
    // =========================
    public static void main(String[] args) {
        System.out.println("=== Testing Simple Version ===");
        testImplementation(new SimpleSelectiveReceive());

        System.out.println("\n=== Testing Concurrent Version ===");
        testImplementation(new ConcurrentSelectiveReceive());

        System.out.println("\n=== Testing Optimized Version ===");
        testImplementation(new OptimizedSelectiveReceive());
    }

    private static void testImplementation(Object impl) {
        // 0) 기존 데모 (순차 실행)
//        try {
//            var sendMethod = impl.getClass().getMethod("send", String.class, String.class);
//            var receiveMethod = impl.getClass().getMethod("receive", String[].class);
//
//            sendMethod.invoke(impl, "blue", "one");
//            sendMethod.invoke(impl, "white", "two");
//            sendMethod.invoke(impl, "red", "three");
//
//            System.out.println("receive([\"green\", \"black\"]): " +
//                    receiveMethod.invoke(impl, new Object[]{new String[]{"green", "black"}}));
//
//            sendMethod.invoke(impl, "blue", "four");
//
//            System.out.println("receive([\"white\", \"blue\"]): " +
//                    receiveMethod.invoke(impl, new Object[]{new String[]{"white", "blue"}}));
//            System.out.println("receive([\"white\", \"blue\"]): " +
//                    receiveMethod.invoke(impl, new Object[]{new String[]{"white", "blue"}}));
//            System.out.println("receive([\"white\", \"blue\"]): " +
//                    receiveMethod.invoke(impl, new Object[]{new String[]{"white", "blue"}}));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // 1) 동시성 스트레스 테스트 (락 없는 구현에서 불일치 유발)
        final String implName = impl.getClass().getSimpleName();
        System.out.println("\n[Race Test] " + implName);

        final String[] tags = {"blue", "white", "red", "black"};
        final int producers = 8;
        final int consumers = 8;
        final int messagesPerProducer = 50_000;
        final int expectedTotal = producers * messagesPerProducer;

        var sent = new AtomicInteger(0);
        var received = new AtomicInteger(0);

        var startGate = new CountDownLatch(1);
        var done = new CountDownLatch(producers + consumers);
        var pool = Executors.newFixedThreadPool(producers + consumers);

        try {
            var sendMethod = impl.getClass().getMethod("send", String.class, String.class);
            var receiveMethod = impl.getClass().getMethod("receive", String[].class);

            for (int p = 0; p < producers; p++) {
                final int id = p;
                pool.submit(() -> {
                    try {
                        startGate.await();
                        for (int i = 0; i < messagesPerProducer; i++) {
                            String tag = tags[(id + i) % tags.length];
                            String msg = "P" + id + "-" + i;
                            sendMethod.invoke(impl, tag, msg);
                            sent.incrementAndGet();
                        }
                    } catch (Exception ignored) {
                    } finally {
                        done.countDown();
                    }
                });
            }

            final long endAt = System.nanoTime() + TimeUnit.SECONDS.toNanos(10);
            for (int c = 0; c < consumers; c++) {
                pool.submit(() -> {
                    try {
                        startGate.await();
                        while (System.nanoTime() < endAt && received.get() < expectedTotal) {
                            Object res = receiveMethod.invoke(impl, new Object[]{tags});
                            if (res != null) received.incrementAndGet();
                            else Thread.onSpinWait();
                        }
                    } catch (Exception ignored) {
                    } finally {
                        done.countDown();
                    }
                });
            }

            startGate.countDown();
            boolean finished = done.await(12, TimeUnit.SECONDS);
            pool.shutdownNow();

            System.out.println("finished: " + finished);
            System.out.println("sent     = " + sent.get());
            System.out.println("received = " + received.get());
            System.out.println((sent.get() == received.get())
                    ? "==> OK (일치)"
                    : "==> MISMATCH (불일치)");
        } catch (Exception e) {
            e.printStackTrace();
            pool.shutdownNow();
        }

        // 2) Starvation Test — 2단계(전역락)에서도 불일치 유발 (우선순위 기아 + 타임박스)
        // receive는 ["white","blue","red"] 순으로만 본다.
        // 프로듀서는 white/blue를 압도적으로 많이 보내고 red도 조금 섞는다.
        // 전역락 구현에서는 소비 처리율이 낮아 뒤쪽(red) 메시지가 남고, 타임박스 종료로 불일치 발생.
        System.out.println("\n[Starvation Test] " + implName);

        final String[] prefTags = {"white", "blue", "red"};
        final int P = 6;       // producers
        final int C = 6;       // consumers
        final int HEAVY = 80_000; // heavy load for high-priority tags
        final int LIGHT = 5_000;  // small load for low-priority tag
        final int expectedWhiteBlue = P * HEAVY * 2 / 3; // 대략적 분배 설명용(정확 비교는 아래 카운트로)
        final int expectedRed = P * LIGHT;

        var sentWB = new AtomicInteger(0);
        var sentR  = new AtomicInteger(0);
        var recvWB = new AtomicInteger(0);
        var recvR  = new AtomicInteger(0);

        var start = new CountDownLatch(1);
        var done2 = new CountDownLatch(P + C);
        var pool2 = Executors.newFixedThreadPool(P + C);

        try {
            var sendMethod = impl.getClass().getMethod("send", String.class, String.class);
            var receiveMethod = impl.getClass().getMethod("receive", String[].class);

            // Producers: white/blue 폭주 + red 소량
            for (int i = 0; i < P; i++) {
                final int id = i;
                pool2.submit(() -> {
                    try {
                        start.await();
                        for (int k = 0; k < HEAVY; k++) {
                            String tag = (k % 2 == 0) ? "white" : "blue";
                            sendMethod.invoke(impl, tag, "WorB-" + id + "-" + k);
                            sentWB.incrementAndGet();
                            if (k % (HEAVY / LIGHT) == 0) {
                                sendMethod.invoke(impl, "red", "R-" + id + "-" + k);
                                sentR.incrementAndGet();
                            }
                        }
                    } catch (Exception ignored) {
                    } finally {
                        done2.countDown();
                    }
                });
            }

            // Consumers: 타임박스 소비 (우선순위는 white > blue > red)
            final long until = System.nanoTime() + TimeUnit.SECONDS.toNanos(5);
            for (int i = 0; i < C; i++) {
                pool2.submit(() -> {
                    try {
                        start.await();
                        while (System.nanoTime() < until) {
                            Object res = receiveMethod.invoke(impl, new Object[]{prefTags});
                            if (res == null) { Thread.onSpinWait(); continue; }
                            String s = res.toString();
                            if (s.startsWith("WorB-")) recvWB.incrementAndGet();
                            else if (s.startsWith("R-"))  recvR.incrementAndGet();
                        }
                    } catch (Exception ignored) {
                    } finally {
                        done2.countDown();
                    }
                });
            }

            start.countDown();
            done2.await(7, TimeUnit.SECONDS);
            pool2.shutdownNow();

            int totalSent = sentWB.get() + sentR.get();
            int totalRecv = recvWB.get() + recvR.get();

            System.out.println("sent(white+blue) = " + sentWB.get() + ", sent(red) = " + sentR.get());
            System.out.println("recv(white+blue) = " + recvWB.get() + ", recv(red) = " + recvR.get());
            System.out.println("TOTAL sent = " + totalSent + ", TOTAL recv = " + totalRecv);
            if (totalSent != totalRecv) {
                System.out.println("==> MISMATCH (우선순위 기아 + 전역락으로 소비 지연 → 남은 메시지 존재)");
            } else {
                System.out.println("==> 일치 (이 구현/환경에서는 기아가 재현되지 않음)");
            }
        } catch (Exception e) {
            e.printStackTrace();
            pool2.shutdownNow();
        }
    }

}
