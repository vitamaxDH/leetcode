package top_75;

public class _1004_max_consecutive_ones_iii {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int max = 0;
        int zeroCnt = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                zeroCnt++;
            }
            if (zeroCnt > k) {
                if (nums[l] == 0) zeroCnt--;
                l++;
            }
            if (zeroCnt <= k) {
                max = Math.max(max, r - l + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        var s = new _1004_max_consecutive_ones_iii();
        System.out.println(s.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 2));
        System.out.println(s.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}
