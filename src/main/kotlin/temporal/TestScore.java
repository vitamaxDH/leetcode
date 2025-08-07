package temporal;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class TestScore {

    List<Integer> scores = Collections.synchronizedList(new ArrayList<>());

    private PriorityQueue<Integer> scoresSorted(boolean asc) {
        Comparator<Integer> comparator = asc ? Comparator.naturalOrder() : Comparator.reverseOrder();
        var pq = new PriorityQueue<>(comparator);
        pq.addAll(scores);
        return pq;
    }

    void recordTestScore(int score) throws Exception {
        if (score < 0 || score > 1600) {
            throw new Exception(String.format("Invalid value received: %d", score));
        }
        this.scores.add(score);
    }

    int getNumScoresBelowValue(int comparison) {
        var scores = scoresSorted(false);
        while (!scores.isEmpty() && scores.peek() >= comparison) {
            scores.poll();
        }
        return scores.size();
    }

    List<Integer> getScoreThatBeatsXScores(int x) {
        if (x < 0) return scores;
        if (x >= scores.size()) return List.of();

        var minHeap = scoresSorted(true);

        int min = 0;
        int beats = 0;
        while (!minHeap.isEmpty() && beats < x) {
            min = minHeap.poll();
            beats++;
        }
        while (!minHeap.isEmpty() && min >= minHeap.peek()) {
            minHeap.poll();
        }

        return minHeap.stream().toList();
    }

    public static void main(String[] args) throws Exception {
//        var hw = new HomeworkByPaul();
//        hw.recordTestScore(1);
//        hw.recordTestScore(1);
//        hw.recordTestScore(1);
//        hw.recordTestScore(1);
//        hw.recordTestScore(5);
//
//        System.out.println(hw.getNumScoresBelowValue(6));
//        System.out.println(hw.getNumScoresBelowValue(2));
//        System.out.println(hw.getScoreThatBeatsXScores(2));

        var tt = new ThreadTest();
        try {
            // 초기값 5개
            for (int i = 0; i < 5; i++) {
                tt.addValues(i * 10);
            }
        } catch (InterruptedException e) {
            System.out.println("failed");
        }

        Runnable write = () -> {
            try {
                tt.addValues((int) (Math.random() * 10));
            } catch (InterruptedException e) {
                System.out.println("Error 발생");
            }
        };
        Runnable read = tt::readValues;

        List<CompletableFuture<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tasks.add(CompletableFuture.runAsync(write));
            tasks.add(CompletableFuture.runAsync(read));
        }

        CompletableFuture.allOf();
    }

    static class ThreadTest {
        final List<Integer> values = new ArrayList<>();

        public void addValues(int value) throws InterruptedException {
            synchronized (values) {

                TimeUnit.MILLISECONDS.sleep(1000L);
                System.out.println(Thread.currentThread());
                System.out.printf("value: %d\n", value);
                values.add(value);
            }
        }

        public void readValues() {
            System.out.println(Thread.currentThread());
            System.out.println(String.join(":", this.values.stream().map(String::valueOf).toList()));
        }
    }
}
