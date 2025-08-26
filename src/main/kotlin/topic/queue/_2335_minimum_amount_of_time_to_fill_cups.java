package topic.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _2335_minimum_amount_of_time_to_fill_cups {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(amount[0]);
        pq.add(amount[1]);
        pq.add(amount[2]);

        var count = 0;
        while (!pq.isEmpty()) {
            var first = pq.poll();
            var second = pq.isEmpty() ? 0 : pq.poll();
            if (first == 0 && second == 0) {
                return count;
            }
            if (--first > 0) {
                pq.add(first);
            }
            if (--second > 0) {
                pq.add(second);
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        var s = new _2335_minimum_amount_of_time_to_fill_cups();
        System.out.println(s.fillCups(new int[] {1,4,2}));
        System.out.println(s.fillCups(new int[] {5,4,4}));
    }
}
