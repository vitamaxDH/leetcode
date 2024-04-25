package top_75;

public class _162_find_peak_element {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        // Binary search? -> but the array is not sorted.
        // If I go through everything -> already O(N), I shouldn't
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int l, int r) {
        if (l > r) return -1;
        int m = (l + r) >>> 1;
        if (m - 1 < 0 && nums[m] > nums[m + 1]) {
            return m;
        } else if (m + 1 >= nums.length && nums[m - 1] < nums[m]) {
            return m;
        } else if (m - 1 >= 0 && m + 1 < nums.length && nums[m - 1] < nums[m] && nums[m] > nums[m + 1]) {
            return m;
        }

        int left = binarySearch(nums, l, m - 1);
        int right = binarySearch(nums, m + 1, r);
        if (left != -1) {
            return left;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        var s = new _162_find_peak_element();
        System.out.println(s.findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(s.findPeakElement(new int[]{1,2,1,3,5,6,4}));
        System.out.println(s.findPeakElement(new int[]{1,2}));
        System.out.println(s.findPeakElement(new int[]{6,5,4,3,2,3,2}));
    }
}
