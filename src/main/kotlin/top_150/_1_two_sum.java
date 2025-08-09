package top_150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1_two_sum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idxByValue = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            var value = nums[i];
            int need = target - value;
            if (idxByValue.containsKey(need)) {
                return new int[] { idxByValue.get(need), i };
            }

            idxByValue.put(value, i);
        }
        return new int[]{};
    }

    public static void main(String[] args) throws Exception {
        var s = new _1_two_sum();
        System.out.println(Arrays.toString(s.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{3, 3}, 6)));
    }
}
