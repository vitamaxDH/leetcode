package top_75;

public class _72_edit_distance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (word1.isEmpty() || word2.isEmpty()) {
            return Math.max(m, n);
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m; ++i) {
            dp[i][0] = i;
        }
        for (int j = 1; j < n; ++j) {
            dp[0][j] = j;
        }


        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        var s = new _72_edit_distance();
        System.out.println(s.minDistance("horse", "ros"));
        System.out.println(s.minDistance("intention", "execution"));
        System.out.println(s.minDistance("abc", "defd"));
        System.out.println(s.minDistance("arrow", "blow"));
        System.out.println(s.minDistance("hand", "right"));
    }
}
