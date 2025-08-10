package top_150;

import java.util.Arrays;

public class _128_longest_consecutive_sequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) return nums.length;
        Arrays.sort(nums);
        int max = 1;
        int curCons = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                continue;
            }
            if (nums[i - 1] + 1 == nums[i]) {
                curCons++;
            } else {
                max = Math.max(max, curCons);
                curCons = 1;
            }
        }
        return Math.max(max, curCons);
    }

    public static void main(String[] args) {
        var s = new _128_longest_consecutive_sequence();
        System.out.println(s.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(s.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(s.longestConsecutive(new int[]{1, 0, 1, 2}));
    }
}
