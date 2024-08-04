package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.two_pointers.easy;

public class PairWithTargetSum {
    public static int[] search(int[] arr, int targetSum) {
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            int sum = arr[s] + arr[e];
            if (sum > targetSum) {
                e--;
            } else if (sum < targetSum) {
                s++;
            } else {
                return new int[] { s, e };
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
