package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.graph;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] hasIncomingEdge = new boolean[n];

        // Determine nodes with incoming edges
        for (List<Integer> edge : edges) {
            hasIncomingEdge[edge.get(1)] = true;
        }

        List<Integer> result = new ArrayList<>();
        // Gather nodes without incoming edges
        for (int i = 0; i < n; i++) {
            if (!hasIncomingEdge[i]) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        var s = new Problem3();
        // create a sample execution with these params and formatting
        // n = 6
        //edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
        // expected output = [0,3]
//        System.out.println(s.findSmallestSetOfVertices(
//                6,
//                List.of(
//                        List.of(0, 1),
//                        List.of(0, 2),
//                        List.of(2, 5),
//                        List.of(3, 4),
//                        List.of(4, 2)
//                )
//        ));
        // create a sample execution with [[1,0],[2,1],[3,2],[4,3]]
        System.out.println(s.findSmallestSetOfVertices(
                5,
                List.of(
                        List.of(1, 0),
                        List.of(2, 1),
                        List.of(3, 2),
                        List.of(4, 3)
                )
        ));
    }
}
