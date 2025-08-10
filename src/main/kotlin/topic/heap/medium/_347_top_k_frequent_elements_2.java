package topic.heap.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _347_top_k_frequent_elements_2 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (var num : nums) {
            seen.merge(num, 1, Integer::sum);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(seen.entrySet());

        var res = new int[k];
        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) break;
            res[i] = pq.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        var s = new _347_top_k_frequent_elements_2();
        int[] res1 = s.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(res1));

        int[] res2 = s.topKFrequent(new int[]{1}, 1);
        System.out.println(Arrays.toString(res2));

        int[] res3 = s.topKFrequent(new int[]{1,2}, 2);
        System.out.println(Arrays.toString(res3));

        int[] res4 = s.topKFrequent(new int[]{5,2,5,3,5,3,1,1,3}, 2);
        System.out.println(Arrays.toString(res4));
    }
}
