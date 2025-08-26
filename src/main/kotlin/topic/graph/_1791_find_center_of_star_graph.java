package topic.graph;

public class _1791_find_center_of_star_graph {
    public int findCenter(int[][] edges) {
        int[] edgeCnt = new int[edges.length + 1];
        for (var edge: edges) {
            edgeCnt[edge[0] - 1]++;
            if (edgeCnt[edge[0] - 1] > 1) return edge[0];
            edgeCnt[edge[1] - 1]++;
            if (edgeCnt[edge[1] - 1] > 1) return edge[1];
        }
        return -1;
    }

    public static void main(String[] args) {
        var s = new _1791_find_center_of_star_graph();
        System.out.println(s.findCenter(new int[][]{{1, 2}, {2, 3}, {4, 2}}));
        System.out.println(s.findCenter(new int[][]{{1, 2}, {5, 1}, {1, 3}, {1, 4}}));
    }
}
