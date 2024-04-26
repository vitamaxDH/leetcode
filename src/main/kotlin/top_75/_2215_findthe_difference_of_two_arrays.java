package top_75;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _2215_findthe_difference_of_two_arrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> nums2Set = new HashSet<>();
        for (var num : nums1) {
            nums1Set.add(num);
        }
        for (var num : nums2) {
            nums2Set.add(num);
        }

        return List.of(
                nums1Set.stream().filter(n -> !nums2Set.contains(n)).toList(),
                nums2Set.stream().filter(n -> !nums1Set.contains(n)).toList()
        );
    }

    public static void main(String[] args) {
        var s = new _2215_findthe_difference_of_two_arrays();
        System.out.println(s.findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}));
        System.out.println(s.findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2}));
    }
}
