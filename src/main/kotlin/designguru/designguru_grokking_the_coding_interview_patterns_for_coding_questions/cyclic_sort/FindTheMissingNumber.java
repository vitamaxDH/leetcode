package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.cyclic_sort;

public class FindTheMissingNumber {
    public static int findMissingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int num = nums[i];
            if (num < nums.length && num != nums[num]) {
                int temp = nums[num];
                nums[num] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        System.out.println(FindTheMissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(FindTheMissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}
