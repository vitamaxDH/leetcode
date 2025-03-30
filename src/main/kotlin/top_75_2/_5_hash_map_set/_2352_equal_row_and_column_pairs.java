package top_75_2._5_hash_map_set;

public class _2352_equal_row_and_column_pairs {
    // brain off method
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int ans = 0;

        for (int[] row : grid) {
            for (int cIdx = 0; cIdx < n; cIdx++) {
                int crIdx = 0;
                while (crIdx < n) {
                    if (row[crIdx] != grid[crIdx][cIdx]) {
                        break;
                    }
                    crIdx++;
                }
                if (crIdx == n) ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Example 1
        int[][] grid1 = {
                {3, 2, 1},
                {1, 7, 6},
                {2, 7, 7}
        };
        // Expected output: 1

        // Example 2
        int[][] grid2 = {
                {3, 1, 2, 2},
                {1, 4, 4, 5},
                {2, 4, 2, 2},
                {2, 4, 2, 2}
        };
        // Expected output: 3

        var s = new _2352_equal_row_and_column_pairs();
        System.out.println(s.equalPairs(grid1)); // should print 1
        System.out.println(s.equalPairs(grid2)); // should print 3
    }
}
