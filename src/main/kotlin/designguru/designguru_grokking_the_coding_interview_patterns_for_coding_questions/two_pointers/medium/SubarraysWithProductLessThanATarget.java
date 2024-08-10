package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.two_pointers.medium;

import java.util.ArrayList;
import java.util.List;

public class SubarraysWithProductLessThanATarget {
    public List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            recursive(arr, result, new ArrayList<>(), i, target, 1);
        }
        return result;
    }

    private boolean recursive(int[] arr, List<List<Integer>> result, List<Integer> curr, int i, int target, int curVal) {
        int product = curVal * arr[i];
        if (target <= product) {
            return false;
        }
        curr.add(arr[i]);
        result.add(curr);
        boolean keep = false;
        for (int j = i + 1; j < arr.length; j++) {
            keep = recursive(arr, result, new ArrayList<>(curr), j, target, product);
            if (!keep) break;
        }
        return keep;
    }

    public static void main(String[] args) {
        var s = new SubarraysWithProductLessThanATarget();
        System.out.println(s.findSubarrays(new int[]{2, 5, 3, 10}, 30));
        System.out.println(s.findSubarrays(new int[]{8, 2, 6, 5}, 50));
    }
}
