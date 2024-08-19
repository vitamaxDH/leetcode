package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.cyclic_sort;

import java.util.Arrays;

public class CyclicSort {
    public int[] sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int num = nums[i];
            if (num - 1 == i) {
                i++;
            } else {
                int temp = nums[num - 1];
                nums[i] = temp;
                nums[num - 1] = num;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        var s = new CyclicSort();
        System.out.println(Arrays.toString(s.sort(new int[] { 3, 1, 5, 4, 2 })));
        System.out.println(Arrays.toString(s.sort(new int[] { 2, 6, 4, 3, 1, 5 })));
        System.out.println(Arrays.toString(s.sort(new int[] { 1, 5, 6, 4, 3, 2 })));
    }
}
