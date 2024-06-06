package topic.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1791_find_center_of_star_graph {
    public int findCenter(int[][] edges) {
        int[] first = new int[]{edges[0][0], 1};
        int[] second = new int[]{edges[0][1], 1};
        int length = Math.min(edges.length, 3);
        for (int i = 1; i < length; i++) {
            int i1 = edges[i][0];
            int i2 = edges[i][1];
            if (first[0] == i1) {
                first[1]++;
            }
            if (first[0] == i2) {
                first[1]++;
            }
            if (second[0] == i1) {
                second[1]++;
            }
            if (second[0] == i2) {
                second[1]++;
            }
        }
        return first[1] == length ? first[0] : second[0];
    }

    public int graph(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        for (int i = 0; i <= n + 1; i++) {
            adj.add(new ArrayList<>());
        }
        Set<Integer> hs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
            hs.add(u);
            hs.add(v);
        }
        int len = hs.size();

        for (int i = 0; i <= n + 1; i++) {
            List<Integer> list = adj.get(i);
            if (list.size() == len - 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var s = new _1791_find_center_of_star_graph();
        System.out.println(s.findCenter(new int[][]{{1, 2}, {2, 3}, {4, 2}}));
        System.out.println(s.findCenter(new int[][]{{1, 2}, {5, 1}, {1, 3}, {1, 4}}));
    }
}
