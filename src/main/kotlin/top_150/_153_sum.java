package top_150;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class _153_sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        var res = new HashSet<List<Integer>>();
        var l = 0;
        var r = nums.length - 1;
        var m = (l + r) >>> 1;
        while (l != m && m != r && l != r) {
            var sum = nums[l] + nums[m] + nums[r];
//            if (sum)
        }
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        var s = new _153_sum();
        System.out.println(s.threeSum(new int[] { -1,0,1,2,-1,-4 }));
        System.out.println(s.threeSum(new int[] { 0,1,1 }));
    }
}
