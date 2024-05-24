package top_75;

public class _547_number_of_provinces {
    int n;
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        var provCnt = 0;
        var visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provCnt++;
            }
        }
        return provCnt;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int city) {
        for (int adjacentCity = 0; adjacentCity < n; adjacentCity++) {
            if (isConnected[city][adjacentCity] == 1 && !visited[adjacentCity]) {
                visited[adjacentCity] = true;
                dfs(isConnected, visited, adjacentCity);
            }
        }
    }

    public static void main(String[] args) {
        var s = new _547_number_of_provinces();
        System.out.println(s.findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        }));
        System.out.println(s.findCircleNum(new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        }));
        System.out.println(s.findCircleNum(new int[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 1}
        }));
        System.out.println(s.findCircleNum(new int[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        }));
    }
}
