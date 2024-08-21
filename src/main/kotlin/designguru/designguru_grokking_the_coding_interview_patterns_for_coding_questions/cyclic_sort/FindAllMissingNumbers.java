package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.cyclic_sort;

import java.util.ArrayList;
import java.util.List;

public class FindAllMissingNumbers {

    public List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int num = nums[i];
            if (num - 1 == i) {
                i++;
            } else {
                int temp = nums[num - 1];
                nums[num] = nums[i];
                nums[i] = temp;
            }
        }
        return missingNumbers;
    }
    public static void main(String[] args) {
        var s = new FindAllMissingNumbers();
        System.out.println(s.findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 }));
//        System.out.println(s.findNumbers(new int[] { 2, 4, 1, 2 }));
//        System.out.println(s.findNumbers(new int[] { 2, 3, 2, 1 }));
    }
}
