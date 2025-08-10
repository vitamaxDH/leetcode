package top_150;

import java.util.Arrays;
import java.util.Comparator;

// greedy. 처음 문제 해결 조건을 잘 따져볼 것.
public class _452_minimum_number_of_arrows_to_burst_balloons {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) return 1;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        var arrows = 1;
        var arrowPos= points[0][1];
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] <= arrowPos) continue;

            arrowPos = points[i][1];
            arrows++;
        }
        return arrows;
    }

    public static void main(String[] args) {
        var s = new _452_minimum_number_of_arrows_to_burst_balloons();

        int[][] points1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(s.findMinArrowShots(points1));

        int[][] points2 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println(s.findMinArrowShots(points2));

        int[][] points3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println(s.findMinArrowShots(points3));

        int[][] points4 = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(s.findMinArrowShots(points4));
    }
}
