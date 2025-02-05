package top_75_2.two_pointers;

import java.util.Arrays;

public class _283_move_zeroes {
    public void moveZeroes(int[] nums) {
        int pos = 0;
        for (var num : nums) {
            if (num != 0) {
                nums[pos++] = num;
            }
        }
        while (pos < nums.length) {
            nums[pos++] = 0;
        }
    }

    public static void main(String[] args) {
        _283_move_zeroes test = new _283_move_zeroes();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        test.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
