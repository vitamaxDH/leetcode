package top_75;

public class _334_increasing_triplet_subsequence {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) min = num;
            else if (num < secondMin) secondMin = num;
            else if (num > secondMin) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        var s = new _334_increasing_triplet_subsequence();
        System.out.println(s.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(s.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(s.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
        System.out.println(s.increasingTriplet(new int[]{20, 100, 10, 12, 5, 13}));
    }
}
