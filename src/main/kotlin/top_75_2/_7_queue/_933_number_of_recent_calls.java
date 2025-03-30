package top_75_2._7_queue;

import java.util.ArrayDeque;

public class _933_number_of_recent_calls {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    public int ping(int t) {
        queue.offer(t);
        if (queue.isEmpty()) {
            return 1;
        }
        while (!queue.isEmpty() && t - queue.peekFirst() > 3000) {
            queue.removeFirst();
        }
        return queue.size();
    }

    public static void main(String[] args) {
        _933_number_of_recent_calls recentCounter = new _933_number_of_recent_calls();
        System.out.println(recentCounter.ping(1));     // requests = [1], range is [-2999,1], return 1
        System.out.println(recentCounter.ping(100));   // requests = [1, 100], range is [-2900,100], return 2
        System.out.println(recentCounter.ping(3001));  // requests = [1, 100, 3001], range is [1,3001], return 3
        System.out.println(recentCounter.ping(3002));  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
    }
}
