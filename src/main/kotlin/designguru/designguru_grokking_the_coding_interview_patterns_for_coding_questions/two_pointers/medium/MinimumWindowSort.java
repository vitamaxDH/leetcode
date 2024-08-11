package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.two_pointers.medium;

public class MinimumWindowSort {
    public static int sort(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < arr.length - 1 && arr[low] <= arr[low + 1]) {
            low++;
        }

        if (low == arr.length - 1) return 0;

        while (high > 0 && arr[high] >= arr[high - 1]) {
            high--;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int k = low; k <= high; k++) {
            min = Math.min(min, arr[k]);
            max = Math.max(max, arr[k]);
        }
        while (low > 0 && arr[low - 1] > min) {
            low--;
        }
        while (high < arr.length - 1 && arr[high + 1] < max) {
            high++;
        }
        return high - low + 1;
    }

    public static void main(String[] args) {
//        System.out.println(MinimumWindowSort.sort(new int[]{1, 2, 5, 3, 7, 10, 9, 12}));
//        System.out.println(MinimumWindowSort.sort(new int[]{1, 3, 2, 0, -1, 7, 10}));
//        System.out.println(MinimumWindowSort.sort(new int[]{1, 2, 3}));
//        System.out.println(MinimumWindowSort.sort(new int[]{3, 2, 1}));
        System.out.println(MinimumWindowSort.sort(new int[]{1, 3, 2, 4}));
    }
}
