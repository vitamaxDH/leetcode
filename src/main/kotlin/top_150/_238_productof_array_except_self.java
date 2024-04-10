package top_150;

import java.util.ArrayList;
import java.util.Arrays;

public class _238_productof_array_except_self {
    public int[] productExceptSelf(int[] nums) {
        var size = nums.length;
        int[] ans = new int[size];

        var zeros = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            var num = nums[i];
            if (num != 0) {
                continue;
            }
            zeros.add(i);
        }
        if (zeros.size() > 1) {
            return ans;
        }
        if (zeros.size() == 1) {
            var product = 1;
            var zeroIdx = zeros.get(0);
            for (int i = 0; i < size; i++) {
                if (i != zeroIdx) product *= nums[i];
            }
            ans[zeroIdx] = product;
            return ans;
        }

        var product = 1;
        for (int num : nums) {
            product *= num;
        }
        for (int i = 0; i < size; i++) {
            ans[i] = product / nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        var ans = new _238_productof_array_except_self();
        System.out.println(Arrays.toString(ans.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(ans.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}

