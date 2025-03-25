package top_75_2._3_sliding_window;

public class _1493_longest_subarray_of_1s_after_deleting_one_element {

    public int longestSubarray(int[] nums) {
        int l = 0;
        int max = 0;
        int zc = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                zc++;
            }
            if (zc > 1) {
                if (nums[l] == 0) {
                    zc--;
                }
                l++;
            }
            max = Math.max(max, r - l);
        }
        return max;
    }

    public static void main(String[] args) {
        var s = new _1493_longest_subarray_of_1s_after_deleting_one_element();
        System.out.println(s.longestSubarray(new int[]{1, 1, 0, 1}));
        System.out.println(s.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        System.out.println(s.longestSubarray(new int[]{1, 1, 1,}));
        System.out.println(s.longestSubarray(new int[]{0, 0}));
    }





















//    public int longestSubarray(int[] nums) {
//        int left = 0, zeroCount = 0, maxWindow = 0;
//        for (int right = 0; right < nums.length; right++) {
//            if (nums[right] == 0) {
//                zeroCount++;
//            }
//            // Shrink the window until it contains at most one 0.
//            while (zeroCount > 1) {
//                if (nums[left] == 0) {
//                    zeroCount--;
//                }
//                left++;
//            }
//            maxWindow = Math.max(maxWindow, right - left + 1);
//        }
//        // We must delete one element, so even if the window contains one 0 (or none),
//        // the maximum count of consecutive 1's becomes (window size - 1).
//        return maxWindow - 1;
//    }

}
