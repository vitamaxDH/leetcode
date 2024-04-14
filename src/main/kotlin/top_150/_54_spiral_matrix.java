package top_150;

import java.util.ArrayList;
import java.util.List;

public class _54_spiral_matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        var res = new ArrayList<Integer>();
        var size = matrix.length * matrix[0].length;
        var i = 0;
        var r = 0;
        var c = 0;
        var d = 'R';
        while (i < size) {
            if (matrix[r][c] != -101) {
                res.add(matrix[r][c]);
                i++;
            }
            // mark as visit
            matrix[r][c] = -101;
            // set the condition to change the direction
            // 1. the end
            // 2. marked as visit
            switch (d) {
                case 'R':
                    if (c + 1 == matrix[0].length || matrix[r][c + 1] == -101) {
                        d = 'D';
                    } else {
                        c++;
                    }
                    break;
                case 'D':
                    if (r + 1 == matrix.length || matrix[r + 1][c] == -101) {
                        d = 'L';
                    } else {
                        r++;
                    }
                    break;
                case 'L':
                    if (c - 1 == -1 || matrix[r][c - 1] == -101) {
                        d = 'U';
                    } else {
                        c--;
                    }
                    break;
                case 'U':
                    if (r - 1 == -1 || matrix[r - 1][c] == -101) {
                        d = 'R';
                    } else {
                        r--;
                    }
                    break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        var s = new _54_spiral_matrix();
//        System.out.println(s.spiralOrder(new int[][] {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9},
//        }));
        System.out.println(s.spiralOrder(new int[][] {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
        }));
    }
}
