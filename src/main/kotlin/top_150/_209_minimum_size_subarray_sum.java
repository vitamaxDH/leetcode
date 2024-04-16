package top_150;

public class _209_minimum_size_subarray_sum {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, total = 0, res = Integer.MAX_VALUE;

        for (int r = 0; r < nums.length; r++) {
            total += nums[r];
            while (total >= target) {
                res = Math.min(res, r - l + 1);
                total -= nums[l++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        var s = new _209_minimum_size_subarray_sum();
        System.out.println(s.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
        System.out.println(s.minSubArrayLen(4, new int[] {1,4,4}));
        System.out.println(s.minSubArrayLen(11, new int[] {1,1,1,1,1,1,1,1}));
        System.out.println(s.minSubArrayLen(11, new int[] {1,2,3,4,5}));
        System.out.println(s.minSubArrayLen(6, new int[] {10,2,3}));
    }
}
