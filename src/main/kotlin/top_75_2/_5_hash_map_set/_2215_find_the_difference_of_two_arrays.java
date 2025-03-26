package top_75_2._5_hash_map_set;

import java.util.*;

public class _2215_find_the_difference_of_two_arrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num: nums1) {
            set1.add(num);
        }
        for (int num: nums2) {
            set2.add(num);
        }

        List<Integer> diff1 = new ArrayList<>();
        for (int num: set1) {
            if (!set2.contains(num)) {
                diff1.add(num);
            }
        }
        List<Integer> diff2 = new ArrayList<>();
        for (int num: set2) {
            if (!set1.contains(num)) {
                diff2.add(num);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(diff1);
        ans.add(diff2);
        return ans;
    }

    public static void main(String[] args) {
        var s = new _2215_find_the_difference_of_two_arrays();
        System.out.println(s.findDifference(new int[]{}, new int[]{}));
    }
}
