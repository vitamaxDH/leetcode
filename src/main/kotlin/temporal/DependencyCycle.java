package temporal;

import java.util.*;

public class DependencyCycle {
    List<String> buildOrder(String[] packages, String[][] deps) throws Exception {
        // configure adjacent list
        Map<String, List<String>> adj = new HashMap<>();
        for (var pkg: packages) {
            adj.put(pkg, new ArrayList<>());
        }

        Map<String, Integer> inDegree = new HashMap<>();
        for (var pkg: packages) {
            inDegree.put(pkg, 0);
        }

        for (var dep: deps) {
            var pkg = dep[0];
            var prereq = dep[1];

            if (!adj.containsKey(pkg) || !adj.containsKey(prereq)) {
                throw new IllegalArgumentException(String.format("pkg %s or %s does not exist", pkg, prereq));
            }

            adj.get(prereq).add(pkg);
            inDegree.put(pkg, inDegree.get(pkg) + 1);
        }

        Deque<String> queue = new ArrayDeque<>();
        for (var entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            result.add(curr);

            for (String next : adj.get(curr)) {
                int updated = inDegree.get(next) - 1;
                inDegree.put(next, updated);

                if (updated == 0) {
                    queue.offer(next);
                }
            }
        }

        if (result.size() != packages.length) {
            System.out.println("cyclical dependency error");
            return List.of();
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        var dc = new DependencyCycle();

        {
            System.out.println("1");
            String[] packages = {"A","B","C","D"};
            String[][] deps = {
                    {"A","B"},
                    {"B","C"},
                    {"C","D"}
            };
            System.out.println(String.join(", ", dc.buildOrder(packages, deps)));
        }
        {
            System.out.println("2");
            String[] packages = {"A","B","C","D"};
            String[][] deps = {
                    {"A","B"},
                    {"B","C"},
                    {"C","D"},
                    {"D","A"}   // 사이클 추가
            };
            System.out.println(String.join(", ", dc.buildOrder(packages, deps)));
        }
        {
            System.out.println("3");
            String[] packages = {"A","B","C","D","E","F"};
            String[][] deps = {
                    {"A","B"},  // A → B
                    {"C","D"}   // C → D
            };
            System.out.println(String.join(", ", dc.buildOrder(packages, deps)));
        }
        {
            System.out.println("4");
            String[] packages = {"A","B","C","D"};
            String[][] deps = {
                    {"A","B"},
                    {"A","C"},
                    {"B","D"},
                    {"C","D"}
            };
            System.out.println(String.join(", ", dc.buildOrder(packages, deps)));
        }
        {
            System.out.println("5");
            String[] packages = {"A","B","C","D","E"};
            String[][] deps = {
                    {"D","B"},  // D → B
                    {"D","C"},  // D → C
                    {"E","C"}   // E → C
            };
            System.out.println(String.join(", ", dc.buildOrder(packages, deps)));
        }
        {
            System.out.println("6");
            String[] packages = {"X","Y","Z"};
            String[][] deps = {};
            System.out.println(String.join(", ", dc.buildOrder(packages, deps)));
        }
        {
            System.out.println("7");
            String[] packages = {"A","B","C","D","E"};
            String[][] deps = {
                    {"A","B"},
                    {"B","C"},
                    {"C","A"},   // 사이클 A-B-C
                    {"D","E"}
            };
            System.out.println(String.join(", ", dc.buildOrder(packages, deps)));
            // Output: Exception("Cyclical Dependency Error")
        }
    }
}
