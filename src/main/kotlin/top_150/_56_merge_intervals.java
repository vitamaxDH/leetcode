package top_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _56_merge_intervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> res = new ArrayList<>();
        int[] newInterval = intervals[0];
        res.add(newInterval);
        for (var interval: intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                newInterval = interval;
                res.add(newInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        var s = new _56_merge_intervals();
        System.out.println(Arrays.deepToString(s.merge(new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18},
        })));
        System.out.println(Arrays.deepToString(s.merge(new int[][] {
                {1,4},
                {4,5}
        })));
        System.out.println(Arrays.deepToString(s.merge(new int[][] {
                {1,4},
                {0,4},
        })));
        System.out.println(Arrays.deepToString(s.merge(new int[][] {
                {1,4},
                {0,0},
        })));
    }
}
