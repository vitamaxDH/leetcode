package top_150;

import java.util.Arrays;

public class _238_product_of_array_except_self {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int length = nums.length;
        var res = new int[length];
        var zeroIdx = -1;
        for (int i = 0; i < length; i++) {
            var cur = nums[i];
            if (cur == 0) {
                if (zeroIdx != -1) {
                    return res;
                }
                zeroIdx = i;
            } else {
                product *= cur;
            }
        }
        if (zeroIdx == -1) {
            for (int i = 0; i < length; i++) {
                res[i] = product / nums[i];
            }
        } else  {
            for (int i = 0; i < length; i++) {
                if (i != zeroIdx) {
                    res[i] = 0;
                } else {
                    var cur = nums[i];
                    res[i] = product;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        var s = new _238_product_of_array_except_self();
        System.out.println(Arrays.toString(s.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(s.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}
