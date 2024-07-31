package medium;

import java.util.Arrays;

public class _2542_maximum_subsequence_score {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        var length = nums1.length;
        if (length < 2) {
            return (long) Arrays.stream(nums1).sum() * Arrays.stream(nums1).max().getAsInt();
        }
        var max = 0;
        var sum = 0;
        var min = Integer.MAX_VALUE;




        return max;
    }

    public static void main(String[] args) {
        var s = new _2542_maximum_subsequence_score();
        System.out.println(s.maxScore(new int[]{1,3,3,2}, new int[]{2,1,3,4}, 3));
    }
}
