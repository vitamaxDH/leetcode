package top_75_2._4_prefix_sum;

public class _724_find_pivot_index {
    public int pivotIndex(int[] nums) {
        int rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        int leftSum = 0;
        for (int pivot = 0; pivot < nums.length; pivot++) {
            rightSum -= nums[pivot];
            if (leftSum == rightSum) return pivot;
            leftSum += nums[pivot];
        }
        return -1;
    }

    public static void main(String[] args) {
        var s = new _724_find_pivot_index();
        System.out.println(s.pivotIndex(new int[]{1,7,3,6,5,6}));
    }
}
