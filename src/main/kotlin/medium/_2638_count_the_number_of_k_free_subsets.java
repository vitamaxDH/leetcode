package medium;

import java.util.*;

public class _2638_count_the_number_of_k_free_subsets {
    public int kFreeSubsets(int[] nums, int k) {
        if (nums.length == 0) return 1;
        Arrays.sort(nums);
        Map<Integer, Integer> kdiffs = new HashMap();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == k) {
                kdiffs.put(nums[i - 1], nums[i]);
            }
        }
        if (kdiffs.isEmpty()) {
            return 1 << nums.length;
        }
        int res = 1;
        int subsetSize = 0;

        return res;
    }

    public List<List<Integer>> getSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>()); // start with an empty subset

        for (int num : nums) {
            int size = subsets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = subsets.get(i);
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(num);
                subsets.add(newSubset);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        var s = new _2638_count_the_number_of_k_free_subsets();
        List<List<Integer>> subsets = s.getSubsets(new int[]{1, 2, 3, 4});
        subsets.forEach(System.out::println);
//        System.out.println(s.kFreeSubsets(new int[]{5, 4, 6}, 1));
//        System.out.println(s.kFreeSubsets(new int[]{2, 3, 5, 8}, 5));
//        System.out.println(s.kFreeSubsets(new int[]{10, 5, 9, 11}, 20));
    }
}
