package top_75;

import java.util.Arrays;

public class _338_counting_bits {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            res[i] = res[i >>> 1] + (i & 1);
        }
        return res;
    }

    public static void main(String[] args) {
        var s = new _338_counting_bits();
        System.out.println(Arrays.toString(s.countBits(2)));
        System.out.println(Arrays.toString(s.countBits(5)));
    }
}
