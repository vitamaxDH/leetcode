package top_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _57_insert_interval {
    // 1. 왼쪽 쫙~ 2. 겹치는애들 쫙~ 3. 오른쪽 쫙~
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0, n = intervals.length;

        // 1) newInterval보다 완전히 왼쪽(끝 < newStart)인 구간들 그대로 추가
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }

        // 2) 겹치는 구간들 병합 (start는 최소, end는 최대)
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval); // 병합 결과 추가

        // 3) 나머지(완전히 오른쪽) 구간들 추가
        while (i < n) res.add(intervals[i++]);

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        var s = new _57_insert_interval();
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        var res1 = s.insert(intervals1, newInterval1);
        for (var r : res1) {
            System.out.println(Arrays.toString(r));
        }
        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        var res2 = s.insert(intervals2, newInterval2);
        for (var r : res2) {
            System.out.println(Arrays.toString(r));
        }
        int[][] intervals3 = {{1, 2}, {3, 4}};
        int[] newInterval3 = {5, 6};
        var res3 = s.insert(intervals3, newInterval3);
        for (var r : res3) {
            System.out.println(Arrays.toString(r));
        }
    }
}
