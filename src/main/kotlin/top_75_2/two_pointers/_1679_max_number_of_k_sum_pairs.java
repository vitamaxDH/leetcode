package top_75_2.two_pointers;

import java.util.Arrays;

public class _1679_max_number_of_k_sum_pairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int left = nums[l];
            int right = nums[r];
            int sum = left + right;
            if (sum == k) {
                res++;
                r--;
                l++;
            } else if (sum > k) {
                r--;
            } else {
                l++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _1679_max_number_of_k_sum_pairs test = new _1679_max_number_of_k_sum_pairs();
//        System.out.println(test.maxOperations(new int[]{1, 2, 3, 4}, 5));
        System.out.println(test.maxOperations(new int[]{3, 1, 3, 4, 3}, 6));
    }
}
