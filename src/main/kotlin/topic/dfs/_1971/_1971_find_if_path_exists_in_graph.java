package topic.dfs._1971;

import java.util.HashSet;
import java.util.Set;

public class _1971_find_if_path_exists_in_graph {
    Set<Integer>[] joinings;
    boolean valid = false;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        joinings = new HashSet[n];
        for (int i = 0; i < n; i++) {
            joinings[i] = new HashSet<>();
        }
        for (int[] edge: edges) {
            joinings[edge[0]].add(edge[1]);
            joinings[edge[1]].add(edge[0]);
        }
        dfs(visited, source, destination);
        return valid;
    }

    void dfs(boolean[] visited, int source, int destination) {
        visited[source] = true;
        Set<Integer> joining = joinings[source];
        if (joining.contains(destination)) {
            valid = true;
        }
        for (int next: joining) {
            if (!visited[next]) {
                dfs(visited, next, destination);
            }
        }
    }

    public static void main(String[] args) {
        var s = new _1971_find_if_path_exists_in_graph();
//        System.out.println(s.validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
        System.out.println(s.validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5));
    }
}
