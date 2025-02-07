package top_75_2._3_sliding_window;

public class _643_maximum_average_subarray_i {
    public double findMaxAverage(int[] nums, int k) {
        int currSum = 0;
        for (int i = 0; i < k; i++) {
            currSum += nums[i];
        }
        int maxSum = currSum;

        for (int i = k; i < nums.length; i++) {
            currSum = currSum - nums[i - k] + nums[i];
            maxSum = Math.max(currSum, maxSum);
        }
        return (double) maxSum / k;
    }


    public static void main(String[] args) {
        _643_maximum_average_subarray_i test = new _643_maximum_average_subarray_i();
//        System.out.println(test.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
//        System.out.println(test.findMaxAverage(new int[]{5}, 1));
        System.out.println(test.findMaxAverage(new int[]{0,4,0,3,2}, 1));
    }
}
