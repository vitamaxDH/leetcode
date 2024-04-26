package top_75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1207_unique_numberof_occurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> visited = new HashSet<>();
        for (var e : map.entrySet()) {
            if (visited.contains(e.getValue())) return false;
            visited.add(e.getValue());
        }
        return true;
    }

    public static void main(String[] args) {
        var s = new _1207_unique_numberof_occurrences();
        System.out.println(s.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(s.uniqueOccurrences(new int[]{1,2}));
        System.out.println(s.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }
}
