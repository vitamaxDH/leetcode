package common;


public class Solution3 {
    public static long solution(long[] arr) {
        long max = arr[0];

        for (long num: arr) {
            if (max < num) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("solution:" + solution(new long[]{1,2,3,4,5}));
    }
}

