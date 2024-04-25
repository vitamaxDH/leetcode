package top_75;

public class _643_maximum_average_subarray_i {
    public double findMaxAverage(int[] nums, int k) {
        double max;
        var sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = (double) sum / k;
        for (int i = 0; i < nums.length - k; i++) {
            sum = sum - nums[i] + nums[i + k];
            max = Math.max(max, (double) sum / k);
        }
        return max;
    }

    public static void main(String[] args) {
        var s = new _643_maximum_average_subarray_i();
//        System.out.println(s.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(s.findMaxAverage(new int[]{0,4,0,3,2}, 1));
    }
}
