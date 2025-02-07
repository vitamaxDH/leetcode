package top_75_2._1_array_string;

public class _334_increasing_triplet_subsequence {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num < secondMin) {
                secondMin = num;
            } else if (num > secondMin) {
                return true;
            }
        }
        return false;
    }

    public boolean bruteForce(int[] nums) {
        /// 1. brute force (n^3)
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int min = nums[i];
            for (int j = i + 1; j < n; j++) {
                int mid = nums[j];
                if (mid > min && j != n - 1) {
                    for (int k = j + 1; k < n; k++) {
                        int max = nums[k];
                        if (max > mid) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _334_increasing_triplet_subsequence test = new _334_increasing_triplet_subsequence();
        System.out.println(test.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(test.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(test.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
    }
}
