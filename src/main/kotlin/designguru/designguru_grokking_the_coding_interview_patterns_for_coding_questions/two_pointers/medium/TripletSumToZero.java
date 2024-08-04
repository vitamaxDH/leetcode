package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.two_pointers.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i + 1]) {
                continue;
            }
            find(arr, -arr[i], i + 1, triplets);
        }
        return triplets;
    }

    private static void find(int[] arr, int target, int l, List<List<Integer>> triplets) {
        int r = arr.length - 1;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (target == sum) {
                triplets.add(Arrays.asList(-target, arr[l], arr[r]));
                l++;
                r--;
                while (l < r && arr[l] == arr[l + 1]) {
                    l++;
                }
                while (l < r && arr[r] == arr[r + 1]) {
                    r--;
                }
            } else if (target < sum) {
                r--;
            } else {
                l++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[]{-5, 2, -1, -2, 3}));
        System.out.println(TripletSumToZero.searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
    }
}
