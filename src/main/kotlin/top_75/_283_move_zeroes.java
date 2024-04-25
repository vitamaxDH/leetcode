package top_75;

import java.util.Arrays;

public class _283_move_zeroes {
    public void moveZeroes(int[] nums) {
        var insertPos = 0;
        for (var num: nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
            System.out.println(Arrays.toString(nums));
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void main(String[] args) {
        var s = new _283_move_zeroes();
        s.moveZeroes(new int[]{0, 1, 0, 3, 12});
        s.moveZeroes(new int[]{0});
        s.moveZeroes(new int[]{1});
        s.moveZeroes(new int[]{45192,0,-659,-52359,-99225,-75991,0,-15155,27382,59818,0,-30645,-17025,81209,887,64648});
    }
}
