package top_150;

import java.util.HashSet;
import java.util.Set;

public class _219_contains_duplicate_ii {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        var s = new _219_contains_duplicate_ii();
        System.out.println(s.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
//        System.out.println(s.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
//        System.out.println(s.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
//        System.out.println(s.containsNearbyDuplicate(new int[]{99, 99}, 2));
//        System.out.println(s.containsNearbyDuplicate(new int[]{1, 4, 2, 3, 1, 2}, 3));
//        System.out.println(s.containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
    }
}
