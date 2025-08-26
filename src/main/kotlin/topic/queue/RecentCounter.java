package topic.queue;

import java.util.ArrayDeque;
import java.util.Queue;

class RecentCounter {

    Queue<Integer> pings;

    public RecentCounter() {
        pings = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        pings.offer(t);
        while (!pings.isEmpty() && t - pings.peek() > 3000) {
            pings.poll();
        }
        return pings.size();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));     // requests = [1], range is [-2999,1], return 1
        System.out.println(recentCounter.ping(100));   // requests = [1, 100], range is [-2900,100], return 2
        System.out.println(recentCounter.ping(3001));  // requests = [1, 100, 3001], range is [1,3001], return 3
        System.out.println(recentCounter.ping(3002));  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
    }
}
