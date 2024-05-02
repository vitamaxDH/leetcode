package top_75;

import java.util.Arrays;

public class _1679_max_number_of_k_sum_pairs {
    public int maxOperations(int[] nums, int k) {
        // Approach 1. Native with time complexity O(n^2)
        // Approach 2. sort it and only find the combination of two
        Arrays.sort(nums);
        int res = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] < k) {
                l++;
            } else if (nums[l] + nums[r] > k) {
                r--;
            } else {
                l++;
                r--;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        var s = new _1679_max_number_of_k_sum_pairs();
        System.out.println(s.maxOperations(new int[]{1, 2, 3, 4}, 5));
        System.out.println(s.maxOperations(new int[]{3, 1, 3, 4, 3}, 6));
    }
}
