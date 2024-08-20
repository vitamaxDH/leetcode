package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.cyclic_sort;

public class FindTheMissingNumber {
    public static int findMissingNumber(int[] nums) {
        boolean[] checks = new boolean[nums.length + 1];
        for (int num: nums) {
            checks[num] = true;
        }
        for (int i = 0; i < checks.length; i++) {
            if (!checks[i]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FindTheMissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(FindTheMissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}
