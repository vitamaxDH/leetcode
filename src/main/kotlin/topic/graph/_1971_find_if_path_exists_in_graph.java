package topic.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1971_find_if_path_exists_in_graph {

    boolean found = false;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];
        for (var edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        dfs(visited, graph, source, destination);
        return found;
    }

    private void dfs(boolean[] visited, Map<Integer, List<Integer>> graph, int src, int dest) {
        if (visited[src] || found) return;
        visited[src] = true;
        for (var neighbor : graph.get(src)) {
            if (neighbor == dest) {
                found = true;
                break;
            }
            if (!visited[neighbor]) {
                dfs(visited, graph, neighbor, dest);
            }
        }
    }

    public static void main(String[] args) {
        var s = new _1971_find_if_path_exists_in_graph();
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 0}};
        var res1 = s.validPath(3, edges1, 0, 2);
        System.out.println(res1);

        int[][] edges2 = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        var res2 = s.validPath(6, edges2, 0, 5);
        System.out.println(res2);
    }
}
