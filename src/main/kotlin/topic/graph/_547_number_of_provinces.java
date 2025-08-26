package topic.graph;

public class _547_number_of_provinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(i, isConnected, visited);
            }
        }
        return provinces;
    }

    private void dfs(int u, int[][] g, boolean[] visited) {
        visited[u] = true;
        for (int v = 0; v < g.length; v++) {
            if (g[u][v] == 1 && !visited[v]) {
                dfs(v, g, visited);
            }
        }
    }

    public static void main(String[] args) {
        var s = new _547_number_of_provinces();
        System.out.println(s.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(s.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }
}
