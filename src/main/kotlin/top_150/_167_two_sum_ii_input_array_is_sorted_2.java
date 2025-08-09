package top_150;

import java.util.Arrays;

public class _167_two_sum_ii_input_array_is_sorted_2 {

    public int[] twoSum(int[] numbers, int target) {
        var l = 0;
        var r = numbers.length - 1;
        while (l < r) {
            var lv = numbers[l];
            var rv = numbers[r];
            int sum = lv + rv;
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                break;
            }
        }
        return new int[]{l + 1, r + 1};
    }

    public static void main(String[] args) {
        var s = new _167_two_sum_ii_input_array_is_sorted_2();
        System.out.println(Arrays.toString(s.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{-1, 0}, -1)));
    }

}
