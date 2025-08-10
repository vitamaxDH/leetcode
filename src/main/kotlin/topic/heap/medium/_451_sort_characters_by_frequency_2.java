package topic.heap.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _451_sort_characters_by_frequency_2 {
    public String frequencySort(String s) {
        Map<Character, Integer> countsByChar = new HashMap<>();
        for (var c: s.toCharArray()) {
            countsByChar.merge(c, 1, Integer::sum);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(countsByChar.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            var countByChar = pq.poll();
            sb.append(String.valueOf(countByChar.getKey()).repeat(countByChar.getValue()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var s = new _451_sort_characters_by_frequency_2();
        System.out.println(s.frequencySort("tree"));
        System.out.println(s.frequencySort("cccaaa"));
        System.out.println(s.frequencySort("Aabb"));
    }
}
