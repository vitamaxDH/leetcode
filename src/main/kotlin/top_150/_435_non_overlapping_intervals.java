package top_150;

import java.util.Arrays;
import java.util.Comparator;

public class _435_non_overlapping_intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int prev = intervals[0][1], count = 0;
        for(int i = 1; i < intervals.length; i++)
            if(intervals[i][0] < prev)
                count++;
            else
                prev = intervals[i][1];
        return count;
    }

    public static void main(String[] args) {
        var s = new _435_non_overlapping_intervals();
        System.out.println(s.eraseOverlapIntervals(new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3},
        }));
        System.out.println(s.eraseOverlapIntervals(new int[][]{
                {1, 2},
                {1, 2},
                {1, 2},
        }));
        System.out.println(s.eraseOverlapIntervals(new int[][]{
                {1, 2},
                {2, 3},
        }));
        System.out.println(s.eraseOverlapIntervals(new int[][]{
                {1, 2},
                {3, 4},
        }));
        System.out.println(s.eraseOverlapIntervals(new int[][]{
                {1, 100},
                {11, 22},
                {1, 11},
                {2, 12},
        }));
    }
}
