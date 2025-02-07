package top_75_2._1_array_string;

import java.util.Arrays;

public class _238_product_of_array_except_self {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = 1;
        suffix[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        int curr = 1;
        for (int i = 0; i < n; i++) {
            res[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= curr;
            curr *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        _238_product_of_array_except_self test = new _238_product_of_array_except_self();
        System.out.println(Arrays.toString(test.productExceptSelf2(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(test.productExceptSelf2(new int[]{-1, 1, 0, -3, 3})));
    }
}
