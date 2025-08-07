package top_150;

import java.util.Arrays;

public class _189_rotate_array {
    public void rotate(int[] nums, int k) {
        if (k == 0) return;
        var length = nums.length;
        var res = new int[length];

        for (int i = 0; i < length; i++) {
            var value = nums[i];
            var rotatedIdx = i + k;
            var updatedIdx = rotatedIdx % length;
            res[updatedIdx] = value;
        }
        System.arraycopy(res, 0, nums, 0, length);
    }

    public void rotate2(int[] nums, int k) {
        var length = nums.length;
        var normalizedK = k % length;
        if (normalizedK == 0) return;

        reverse(nums, 0, length - 1);
        reverse(nums, 0, normalizedK - 1);
        reverse(nums, normalizedK, length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            var temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        var s = new _189_rotate_array();
        {
            int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7}; // [5,6,7,1,2,3,4]
            s.rotate2(nums, 3);
            System.out.println(Arrays.toString(nums));
        }
        {
            int[] nums = new int[]{-1, -100, 3, 99};
            s.rotate2(nums, 2);
            System.out.println(Arrays.toString(nums)); // [3,99,-1,-100]
        }
    }
}
