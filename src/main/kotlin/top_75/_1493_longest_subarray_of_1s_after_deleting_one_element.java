package top_75;

public class _1493_longest_subarray_of_1s_after_deleting_one_element {
    public int longestSubarray(int[] nums) {
        int l = 0;
        int zeroCnt = 0;
        int ans = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                zeroCnt++;
            }
            if (zeroCnt > 1) {
                if (nums[l] == 0) zeroCnt--;
                l++;
            }
            if (zeroCnt <= 1) {
                ans = Math.max(ans, r - l);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        var s = new _1493_longest_subarray_of_1s_after_deleting_one_element();
        System.out.println(s.longestSubarray(new int[]{1, 1, 0, 1}));
        System.out.println(s.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        System.out.println(s.longestSubarray(new int[]{1, 1, 1}));
    }
}
