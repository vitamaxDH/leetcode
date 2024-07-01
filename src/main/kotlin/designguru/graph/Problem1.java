package designguru.graph;

import java.util.*;

public class Problem1 {

    public class Solution {
        private boolean[] visited; // To keep track of visited nodes

        class Graph {
            private int vertices;
            private List<List<Integer>> edges;

            public Graph(int v) {
                vertices = v;
                edges = new ArrayList<>();
                for (int i = 0; i < vertices; i++) {
                    edges.add(new ArrayList<>());
                }
            }

            public void addVertices(int u, int v) {
                edges.get(u).add(v);
                edges.get(v).add(u);
            }

            public List<Integer> getAdjacents(int vertex) {
                return new ArrayList<>(edges.get(vertex));
            }
        }

        public boolean validPath(int n, int[][] edges, int start, int end) {
            visited = new boolean[n];
            Graph g = new Graph(n);
            for (int[] edge : edges) {
                g.addVertices(edge[0], edge[1]);
            }

            Stack<Integer> s = new Stack<>();

            s.add(start);

            while (!s.isEmpty()) {
                int vertex = s.pop();
                visited[vertex] = true;
                for (int adj : g.getAdjacents(vertex)) {
                    if (adj == end) return true;
                    if (!visited[adj]) {
                        s.add(adj);
                    }
                }
            }

            return false;
        }

    }

}
