package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Problem2 {
    public class Solution {
        public int findCircleNum(int[][] isConnected) {
            int provinces = 0;

            List<List<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < isConnected.length; i++) {
                edges.add(new ArrayList<>());
            }
            for (int vertex = 0; vertex < isConnected.length; vertex++) {
                int[] neighbors = isConnected[vertex];
                for (int neighborIdx = vertex + 1; neighborIdx < neighbors.length; neighborIdx++) {
                    if (neighbors[neighborIdx] == 1) {
                        edges.get(vertex).add(neighborIdx);
                        edges.get(neighborIdx).add(vertex);
                    }
                }
            }

            int numOfVisits = 0;
            Stack<Integer> s = new Stack<>();
            boolean[] visited = new boolean[isConnected.length];

            for (int i = 0; i < edges.size(); i++) {
                if (edges.get(i).isEmpty()) {
                    visited[i] = true;
                    provinces++;
                    numOfVisits++;
                } else if (s.isEmpty()) {
                    s.add(i);
                };
            }

            if (s.isEmpty()) return isConnected.length;

            // print visited with index;
            System.out.println(Arrays.toString(visited));
            int lastVertexOfProv = 0;
            while (numOfVisits < isConnected.length) {
                provinces++;
                if (s.isEmpty()) {
                    for (int i = lastVertexOfProv; i < visited.length; i++) {
                        lastVertexOfProv++;
                        if (!visited[i]) {
                            s.add(i);
                            break;
                        }
                    }
                }
                while (!s.isEmpty()) {
                    int vertex = s.pop();
                    numOfVisits++;
                    for (int neighbor : edges.get(vertex)) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            s.add(neighbor);
                        }
                    }
                }
            }

            return provinces;
        }

        public int findCircleNum2(int[][] isConnected) {
            int provinces = 0;
            boolean[] visited = new boolean[isConnected.length];
            for (int i = 0; i < isConnected.length; i++) {
                if (!visited[i]) {
                    dfs(isConnected, visited, i);
                    provinces++;
                }
            }
            return provinces;
        }

        private void dfs(int[][] isConnected, boolean[] visited, int i) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    dfs(isConnected, visited, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Problem2().new Solution();
        s.findCircleNum(new int[][]{
                new int[]{1, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 1}
        });
    }
}
