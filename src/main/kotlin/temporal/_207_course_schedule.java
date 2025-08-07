package temporal;

import java.util.*;

public class _207_course_schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];

        for (int[] classes: prerequisites) {
            var clz = classes[0];
            var prereq = classes[1];

            adj.get(prereq).add(clz);
            inDegree[clz]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        // Main logic for Kahn's algorithm
        int res = 0;
        while (!q.isEmpty()) {
            var curr = q.poll();
            res++;
            for (var next: adj.get(curr)) {
                inDegree[next]--;

                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return res == numCourses;
    }

    public static void main(String[] args) {
        var s = new _207_course_schedule();
        System.out.println(s.canFinish(
                2,
                new int[][] {
                        {1, 0}
                }
        ));
//        System.out.println(s.canFinish(
//                2,
//                new int[][] {
//                        {1, 0},
//                        {0, 1},
//                }
//        ));
    }
}
