package top_75;

import java.util.ArrayList;
import java.util.List;

public class _1466_reorder_routes_to_make_all_paths_lead_to_the_city_zero {
    List<Integer>[] incoming, outgoing;
    int ans;

    public int minReorder(int n, int[][] connections) {
        ans = 0;
        incoming = new ArrayList[n];
        outgoing = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            incoming[i] = new ArrayList();
            outgoing[i] = new ArrayList();
        }
        for (int edge[] : connections) {
            incoming[edge[1]].add(edge[0]);
            outgoing[edge[0]].add(edge[1]);
        }
        dfs(0, new boolean[n]);
        return ans;
    }

    void dfs(int v, boolean[] visited) {
        visited[v] = true;
        for (int i : outgoing[v])
            if (!visited[i]) {
                ans++;
                dfs(i, visited);
            }
        for (int i : incoming[v])
            if (!visited[i])
                dfs(i, visited);
    }

    public static void main(String[] args) {
        var s = new _1466_reorder_routes_to_make_all_paths_lead_to_the_city_zero();
        System.out.println(s.minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}));
//        System.out.println(s.minReorder(5, new int[][]{{1, 0}, {1, 2}, {3, 2}, {3, 4}}));
//        System.out.println(s.minReorder(3, new int[][]{{1, 0}, {2, 0}}));
    }
}
