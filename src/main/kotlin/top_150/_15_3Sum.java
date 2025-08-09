package top_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            var l = i + 1;
            var r = nums.length - 1;
            while (l < r) {
                var sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    do {
                        l++;
                    } while (nums[l] == nums[l - 1] && l < r);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        var s = new _15_3Sum();
        List<List<Integer>> res1 = s.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (var res : res1) {
            System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        List<List<Integer>> res2 = s.threeSum(new int[]{0,1,1});
        for (var res: res2) {
            System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
