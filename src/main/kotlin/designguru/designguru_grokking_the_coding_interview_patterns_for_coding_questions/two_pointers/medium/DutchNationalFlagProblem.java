package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.two_pointers.medium;

import java.util.Arrays;

public class DutchNationalFlagProblem {
    public int[] sort(int[] arr) {
        int low = 0, high = arr.length - 1;
        for (int i = 0; i <= high; ) {
            if (arr[i] == 0) {
                swap(arr, i++, low++);
            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, i, high--);
            }
        }
        return arr;
    }

    private void swap(int[] arr, int from, int to) {
        int t = arr[from];
        arr[from] = arr[to];
        arr[to] = t;
    }

    public static void main(String[] args) {
        var s = new DutchNationalFlagProblem();
        System.out.println(Arrays.toString(s.sort(new int[]{1, 0, 2, 1, 0})));
        System.out.println("=======");
        System.out.println(Arrays.toString(s.sort(new int[]{2, 2, 0, 1, 2, 0})));
    }
}
