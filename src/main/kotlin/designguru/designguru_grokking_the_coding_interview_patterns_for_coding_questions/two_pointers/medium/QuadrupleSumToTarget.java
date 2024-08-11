package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.two_pointers.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupleSumToTarget {
    public List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = i + 1; j < arr.length - 2; j++) {
                int first = arr[i];
                int second = arr[j];
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }
                find(arr, quadruplets, first, second, target, j + 1);
            }
        }
        return quadruplets;
    }

    private static void find(int[] arr, List<List<Integer>> quadruplets, int first, int second, int target, int left) {
        int right = arr.length - 1;
        target = -(first + second - target);
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (target == sum) {
                quadruplets.add(Arrays.asList(first, second, arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1]) {
                    left++;
                }
                while (left < right && arr[right] == arr[right + 1]) {
                    right--;
                }
            } else if (target < sum) {
                right--;
            } else {
                left++;
            }
        }
    }

    public static void main(String[] args) {
        var s = new QuadrupleSumToTarget();
        System.out.println(s.searchQuadruplets(new int[]{4, 1, 2, -1, 1, -3}, 1));
        System.out.println(s.searchQuadruplets(new int[]{2, 0, -1, 1, -2, 2}, 2));
        System.out.println(s.searchQuadruplets(new int[]{0, 0, 0, 0, 0, 0}, 0));
        System.out.println(s.searchQuadruplets(new int[]{-2, -2, -1, 0, 1, 1, 2, 2}, -2));
    }
}
