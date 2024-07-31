package common;

public class Solution4 {
    public static long solution(long n) {
        if (n == 0) return 0;

        int[] dp = new int[(int) n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i >= 1) {
                dp[i] += dp[i - 1];
            }
            if (i >= 2) {
                dp[i] += dp[i - 2];
            }
            if (i >= 3) {
                dp[i] += dp[i - 3];
            }
        }

        return dp[(int) n];
    }

    public static void main(String[] args) {
        System.out.println("solution:" + solution(3));
    }
}
