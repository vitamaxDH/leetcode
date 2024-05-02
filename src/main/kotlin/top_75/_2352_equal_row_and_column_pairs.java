package top_75;

public class _2352_equal_row_and_column_pairs {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        if (n == 1) return 1;

        int res = 0;
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                int start = 0;
                int end = n - 1;
                boolean notMatching = false;
                while (start <= end) {
                    if (grid[row][start] != grid[start][col] || grid[row][end] != grid[end][col]) {
                        notMatching = true;
                        break;
                    }
                    start++;
                    end--;
                }
                if (notMatching) continue;
                if ((n & 1) == 1) {
                    if ((grid[row][n / 2] == grid[n / 2][col])) {
                        res++;
                    }
                } else {
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        var s = new _2352_equal_row_and_column_pairs();
        System.out.println(s.equalPairs(new int[][]{{3,2,1}, {1,7,6}, {2,7,7}}));
        System.out.println(s.equalPairs(new int[][]{{3,1,2,2}, {1,4,4,5}, {2,4,2,2}, {2,4,2,2}}));
    }
}
