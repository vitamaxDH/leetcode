package top_150;

import java.util.List;

public class _189_rotate_array {
    public void rotate(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length < 2) return;
        int length = nums.length;
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            int newIdx = i + k;
            if (newIdx >= length) {
                newIdx -= length;
            }
        }
    }

    public static void main(String[] args) {
        var s = new _189_rotate_array();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        s.rotate(nums, 3);
        List.of(nums).forEach(System.out::println);
    }
}
