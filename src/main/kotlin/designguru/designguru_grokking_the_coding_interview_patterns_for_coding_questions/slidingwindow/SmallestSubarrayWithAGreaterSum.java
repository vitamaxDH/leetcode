package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.slidingwindow;

public class SmallestSubarrayWithAGreaterSum {
    public int findMinSubArray(int S, int[] arr) {
        for (int i = 1; i < arr.length + 1; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += arr[j];
            }
            if (sum >= S) return i;
            for (int j = 0; j < arr.length - i; j++) {
                sum = sum - arr[j] + arr[j + i];
                if (sum >= S) return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        var s = new SmallestSubarrayWithAGreaterSum();
//        System.out.println(s.findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));
//        System.out.println(s.findMinSubArray(7, new int[]{2, 1, 5, 2, 8}));
//        System.out.println(s.findMinSubArray(8, new int[]{3, 4, 1, 1, 6}));
        System.out.println(s.findMinSubArray(5, new int[]{1,1,1,1,1}));
    }
}
