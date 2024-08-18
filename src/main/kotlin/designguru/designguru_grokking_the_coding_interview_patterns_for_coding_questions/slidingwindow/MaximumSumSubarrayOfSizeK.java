package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.slidingwindow;

public class MaximumSumSubarrayOfSizeK {
    public int findMaxSumSubArray(int k, int[] arr) {
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += arr[i];
        }
        int sum = max;
        for (int i = 0; i < arr.length - k; i++) {
            sum = sum - arr[i] + arr[i + k];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        var s = new MaximumSumSubarrayOfSizeK();
        System.out.println(s.findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
        System.out.println(s.findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5}));
    }
}
