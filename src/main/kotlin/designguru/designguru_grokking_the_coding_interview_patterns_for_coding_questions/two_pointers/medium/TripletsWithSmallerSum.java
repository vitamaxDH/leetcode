package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.two_pointers.medium;

import java.util.Arrays;

public class TripletsWithSmallerSum {
    public int searchTriplets(int[] arr, int target) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int first = arr[i];
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int sum = first + arr[left] + arr[right];
                if (sum < target) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TripletsWithSmallerSum s = new TripletsWithSmallerSum();
        System.out.println(s.searchTriplets(new int[]{-1, 0, 2, 3}, 3));
        System.out.println(s.searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5));
    }
}
