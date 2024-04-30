package top_75;

import java.util.ArrayDeque;

public class _933_numberof_recent_calls {
    public static void main(String[] args) {
        var s = new RecentCounter();
        System.out.println(s.ping(1));
        System.out.println(s.ping(100));
        System.out.println(s.ping(3001));
        System.out.println(s.ping(3002));
    }
}

class RecentCounter {

    ArrayDeque<Integer> q;

    public RecentCounter() {
        q = new ArrayDeque<>();
    }

    public int ping(int t) {
        q.add(t);
        if (q.size() == 1) {
            return 1;
        }
        while (!q.isEmpty() && t - 3000 > q.peek()) {
            q.poll();
        }
        return q.size();
    }
}
