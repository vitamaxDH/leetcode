package top_150;

import java.util.ArrayList;
import java.util.Arrays;

public class _73_set_matrix_zeroes {
    class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public void setZeroes(int[][] matrix) {
        var zeros = new ArrayList<Point>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    zeros.add(new Point(row, col));
                }
            }
        }

        zeros.forEach(p -> {
            // row
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[p.row][i] = 0;
            }
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][p.col] = 0;
            }
        });
    }

    public static void main(String[] args) {
        var s = new _73_set_matrix_zeroes();
        s.setZeroes(new int[][] {
                {1,1,1},
                {1,0,1},
                {1,1,1},
        });
        s.setZeroes(new int[][] {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5},
        });
    }
}
