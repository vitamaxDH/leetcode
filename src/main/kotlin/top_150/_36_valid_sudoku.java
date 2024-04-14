package top_150;

public class _36_valid_sudoku {
    public boolean isValidSudoku(char[][] board) {
        // try to come up with an idea that I check all the groups or sections
        // by 9 times
        // sum from 1 through 9 is 45
        for (int i = 0; i < board.length; i++) {
            boolean[] found = new boolean[27];

            for (int j = 0; j < 9; j++) {
                // 1. horizontal (column by column) check
                char hNum = board[j][i];
                if ('1' <= hNum && hNum <= '9') {
                    int idx = hNum - '1';
                    if (found[idx]) {
                        return false;
                    } else {
                        found[idx] = true;
                    }
                }
                // 2. vertical (row by row) check
                char vNum = board[i][j];
                if ('1' <= vNum && vNum <= '9') {
                    int idx = vNum - '1' + 9;
                    if (found[idx]) {
                        return false;
                    } else {
                        found[idx] = true;
                    }
                }

                var r = j / 3 + (i / 3) * 3;
                var c = j % 3 + (i % 3) * 3;

                var num = board[r][c];
                if ('1' <= num && num <= '9') {
                    int idx = num - '1' + 18;
                    if (found[idx]) {
                        return false;
                    } else {
                        found[idx] = true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var s = new _36_valid_sudoku();
        System.out.println(s.isValidSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},
        }));
        System.out.println(s.isValidSudoku(new char[][]{
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},
        }));
        System.out.println(s.isValidSudoku(new char[][]{
                {'7','.','.','.','4','.','.','.','.'},
                {'.','.','.','8','6','5','.','.','.'},
                {'.','1','.','2','.','.','.','.','.'},
                {'.','.','.','.','.','9','.','.','.'},
                {'.','.','.','.','5','.','5','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
        }));
    }
}
