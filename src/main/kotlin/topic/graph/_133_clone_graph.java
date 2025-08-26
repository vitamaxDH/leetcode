package topic.graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class _133_clone_graph {

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // to store copied
        Map<Node, Node> memo = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();

        Node res = new Node(node.val);
        memo.put(node, res);
        q.offer(node);
        while (!q.isEmpty()) {
            var cur = q.poll();
            var curCopy = memo.get(cur);
            for (var neighbor : cur.neighbors) {
                if (!memo.containsKey(neighbor)) {
                    var neighborCoopy = new Node(neighbor.val);
                    memo.put(neighbor, neighborCoopy);
                    q.offer(neighbor);
                }
                curCopy.neighbors.add(memo.get(neighbor));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        var s = new _133_clone_graph();
        var node1 = new Node(1);
        node1.neighbors.add(new Node(2));
        node1.neighbors.add(new Node(3));
        var a = s.cloneGraph(node1);
    }
}
