package top_75_2._5_hash_map_set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1207_unique_number_of_occurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: arr) {
            map.merge(num, 1, Integer::sum);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer value: map.values()) {
            if (set.contains(value)) {
                return false;
            }
            set.add(value);
        }
        return true;
    }

    public static void main(String[] args) {
        var s = new _1207_unique_number_of_occurrences();
        System.out.println(s.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println(s.uniqueOccurrences(new int[]{1,2}));
        System.out.println(s.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }
}
