package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.two_pointers.medium;

import java.util.Arrays;

public class TripletSumCloseToTarget {
    public int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int closestSum = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int first = arr[i];
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int sum = first + arr[left] + arr[right];
                int diff = targetSum - sum;
                int absDiff = Math.abs(diff);
                if (absDiff == 0) {
                    return sum;
                } else if (absDiff < minDiff) {
                    closestSum = sum;
                    minDiff = absDiff;
                } else if (absDiff == minDiff && sum < closestSum) {
                    closestSum = sum;
                }
                if (sum < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        var s = new TripletSumCloseToTarget();
        System.out.println(s.searchTriplet(new int[]{-1, 0, 2, 3}, 3));
        System.out.println(s.searchTriplet(new int[]{-3, -1, 1, 2}, 1));
        System.out.println(s.searchTriplet(new int[]{1, 0, 1, 1}, 100));
        System.out.println(s.searchTriplet(new int[]{0, 0, 1, 1, 2, 6}, 5));
    }
}
