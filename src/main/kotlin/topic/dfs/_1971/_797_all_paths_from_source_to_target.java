package topic.dfs._1971;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _797_all_paths_from_source_to_target {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph.length == 0) return Collections.emptyList();
        dfs(graph, new ArrayList<>(), 0);
        return answer;
    }

    void dfs(int[][] graph, List<Integer> route, int node) {
        int[] edges = graph[node];
        route.add(node);
        if (node == graph.length - 1) {
            answer.add(route);
            return;
        }
        for (int nextNode: edges) {
            List<Integer> newRoute = new ArrayList<>(route);
            dfs(graph, newRoute, nextNode);
        }
    }

    public static void main(String[] args) {
        var s = new _797_all_paths_from_source_to_target();
        System.out.println(s.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
        s.answer.clear();
        System.out.println(s.allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}}));
        s.answer.clear();
        System.out.println(s.allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {}, {4}, {}}));
        s.answer.clear();
        System.out.println(s.allPathsSourceTarget(new int[][]{{2}, {}, {1}}));
    }
}
