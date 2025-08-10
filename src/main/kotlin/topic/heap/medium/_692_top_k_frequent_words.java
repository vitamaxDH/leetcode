package topic.heap.medium;

import java.util.*;

public class _692_top_k_frequent_words {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> seen = new HashMap<>();
        for (var word: words) {
            seen.merge(word, 1, Integer::sum);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue();
            } else {
                return a.getKey().compareTo(b.getKey());
            }
        });
        pq.addAll(seen.entrySet());
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty() && k-- > 0) {
            res.add(pq.poll().getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        var s = new _692_top_k_frequent_words();
        String[] words1 = {"i","love","leetcode","i","love","coding"};
        System.out.println(String.join(", ", s.topKFrequent(words1, 2)));

        String[] words2 = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        System.out.println(String.join(", ", s.topKFrequent(words2, 4)));
    }
}
