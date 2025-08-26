package topic.graph;

import java.util.HashMap;
import java.util.Map;

public class _997_find_the_town_judge {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> outDegree = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            outDegree.put(i, 0);
            inDegree.put(i, 0);
        }

        for (var t : trust) {
            outDegree.merge(t[0], 1, Integer::sum);
            inDegree.merge(t[1], 1, Integer::sum);
        }

        for (var out : outDegree.entrySet()) {
            if (out.getValue() == 0 && inDegree.getOrDefault(out.getKey(), 0) == n - 1) {
                return out.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        var s = new _997_find_the_town_judge();
        System.out.println(s.findJudge(2, new int[][]{{1, 2}}));
        System.out.println(s.findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        System.out.println(s.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
        System.out.println(s.findJudge(3, new int[][]{{1, 2}, {2, 3}}));
    }
}
