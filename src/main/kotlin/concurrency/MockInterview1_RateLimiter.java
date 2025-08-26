package concurrency;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class MockInterview1_RateLimiter {

    private ConcurrentHashMap<String, Queue<Instant>> limits;
    private ConcurrentHashMap<String, ReentrantLock> keyLocks;
    private int maxRequests;
    private long windowSizeInSeconds;

    // Constructor
    public MockInterview1_RateLimiter(int maxRequests, long windowSizeInSeconds) {
        if (maxRequests < 1) {
            System.err.println("max request should be positive");
        }
        limits = new ConcurrentHashMap<>();
        keyLocks = new ConcurrentHashMap<>();
        this.maxRequests = maxRequests;
        this.windowSizeInSeconds = windowSizeInSeconds;
    }

    // 요청이 허용되면 true, 제한에 걸리면 false 반환
    public boolean allowRequest(String userId, Instant now) {
        Queue<Instant> reqs;
        ReentrantLock keyLock = keyLocks.computeIfAbsent(userId, k -> new ReentrantLock());
        keyLock.lock();
        try {
            if (!limits.containsKey(userId)) {
                reqs = new ArrayDeque<>();
                reqs.add(now);
                limits.put(userId, reqs);
                return true;
            }

            reqs = limits.get(userId);
            var allowSince = now.minusSeconds(windowSizeInSeconds);
            // guaranteed that it is not empty but to make sure,
            while (!reqs.isEmpty() && reqs.peek().isBefore(allowSince)) {
                reqs.poll();
            }
            if (reqs.size() >= maxRequests) {
                return false;
            }
            reqs.add(Instant.now());
        } finally {
            keyLock.unlock();
        }
        return true;
    }

    public static void main(String[] args) throws Throwable {
        var maxRequest = 3;
        var windowSizeInSeconds = 10;
        var s = new MockInterview1_RateLimiter(maxRequest, windowSizeInSeconds);
//        var userId = UUID.randomUUID().toString();
//        for (int i = 0; i < maxRequest; i++) {
//            var allowed = s.allowRequest(userId);
//            if (allowed) {
//                System.out.println("request allowed");
//            }
//        }
//        var shouldNotAllowed = s.allowRequest(userId);
//        System.out.println("Result for " + userId + " after " + maxRequest + " number of times: " + shouldNotAllowed);
        main2();
    }

    public static void main2() throws Throwable {
        var maxRequest = 3;
        var windowSizeInSeconds = 10;
        var s = new MockInterview1_RateLimiter(maxRequest, windowSizeInSeconds);

        var threads = 150;
        var executor = Executors.newFixedThreadPool(threads);
        var counter = new AtomicInteger();
        var userIds = IntStream.range(0, 10).mapToObj(i -> UUID.randomUUID().toString()).toList();

        var now = Instant.now();
        for (int i = 0; i < maxRequest * threads * userIds.size(); i++) {
            int finalI = i;
            executor.submit(() -> {
                if (s.allowRequest(userIds.get(finalI % userIds.size()), now)) {
                    counter.incrementAndGet();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);

        System.out.println("Allowed requests: " + counter + " (expected: " + maxRequest * userIds.size() + ")");
    }
}
