package top_75;

import java.util.ArrayDeque;
import java.util.Queue;

public class _1161_maximum_level_sum_of_a_binary_tree {
    class Pair {
        int level;
        TreeNode node;

        public Pair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }
    public int maxLevelSum(TreeNode root) {
        // no check for root == null since it is guaranteed in the constraint
        // compare level by level, we need a queue

        int max = Integer.MIN_VALUE;
        int maxLevel = 1;
        int curLevel = 1;
        int sum = 0;

        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(1, root));

        while (!q.isEmpty()) {
            // Sum all the values on the same level and compare it.
            // How can I check if a group of elements is on the same level?
            Pair pair = q.poll();
            TreeNode node = pair.node;
            int level = pair.level;
            if (level > curLevel) {
                if (sum > max) {
                    max = sum;
                    maxLevel = curLevel;
                }
                sum = 0;
                curLevel = level;
            }
            sum += node.val;
            if (node.left != null) {
                q.offer(new Pair(level + 1, node.left));
            }
            if (node.right != null) {
                q.offer(new Pair(level + 1, node.right));
            }
        }

        if (sum > max) {
            maxLevel = curLevel;
        }

        return maxLevel;
    }

    public int maxLevelSum2(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        int max = root.val;
        int maxLevel = 1;
        int curLevel = 1;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if (sum > max) {
                maxLevel = curLevel;
                max = sum;
            }
            curLevel++;
        }

        return maxLevel;
    }

    public static void main(String[] args) {
        var s = new _1161_maximum_level_sum_of_a_binary_tree();
        TreeNode root = TreeNode.buildTree(1, 7, 0, 7, -8, null, null);
//        root.printTree();
        System.out.println(s.maxLevelSum2(root));

        TreeNode root1 = TreeNode.buildTree(989, 10250, 98693, -89388, -32127, null, null, null, -2);
//        root1.printTree();
        System.out.println(s.maxLevelSum2(root1));
        // give me an example for 1,2,3
        TreeNode root2 = TreeNode.buildTree(1, 2, 3);
        root2.printTree();
        System.out.println(s.maxLevelSum2(root2));
    }
}
