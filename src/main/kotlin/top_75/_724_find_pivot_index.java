package top_75;

public class _724_find_pivot_index {
    public int pivotIndex(int[] nums) {
        if (nums.length == 1) return 0;
        int lSum = 0;
        int rSum = 0;
        for (int i = 1; i < nums.length; i++) {
            rSum += nums[i];
        }
        if (rSum == 0) return 0;
        for (int i = 1; i < nums.length; i++) {
            lSum += nums[i - 1];
            rSum -= nums[i];
            if (lSum == rSum) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        var s = new _724_find_pivot_index();
        System.out.println(s.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(s.pivotIndex(new int[]{1,2,3}));
        System.out.println(s.pivotIndex(new int[]{2,1,-1}));
    }
}
