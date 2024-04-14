package top_150;

import java.util.Arrays;

public class _48_rotate_image {
    public void rotate(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = row; col < matrix[0].length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length / 2; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][matrix.length - col - 1];
                matrix[row][matrix.length - col - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        var s = new _48_rotate_image();
        s.rotate(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        });
    }
}
