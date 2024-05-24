package easy;

import java.util.Arrays;

public class _733_flood_fill {
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, 1, 0, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        flood(image, sr, sc, color);
        return image;
    }

    void flood(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return;
        int origin = image[sr][sc];
        image[sr][sc] = color;
        for (int i = 0; i < dr.length; i++) {
            int newR = sr + dr[i];
            int newC = sc + dc[i];
            if (0 <= newR && newR < image.length && 0 <= newC && newC < image[0].length && image[newR][newC] == origin) {
                flood(image, newR, newC, color);
            }
        }
    }

    public static void main(String[] args) {
        var s = new _733_flood_fill();
        int[][] result = s.floodFill(new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        }, 1, 1, 2);
        Arrays.stream(result).forEach(row -> System.out.println(Arrays.toString(row)));
        int[][] result2 = s.floodFill(new int[][]{
                {0, 0, 0},
                {0, 0, 0}
        }, 0, 0, 0);
        Arrays.stream(result2).forEach(row -> System.out.println(Arrays.toString(row)));
    }
}
