package top_150;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _104_maximum_depthof_binary_tree {
    public int maxDepth(TreeNode root) {
//        int[] res = new int[] {0};
//        walk(root, 0, res);
//        return res[0];
        if (root == null) return 0;
        var left = maxDepth(root.left);
        var right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    private void walk(TreeNode node, int depth, int[] max) {
        if (node == null) return;
        max[0] = Math.max(max[0], depth + 1);
        walk(node.left, depth + 1, max);
        walk(node.right, depth + 1, max);
    }

    public static void main(String[] args) {
        var s = new _104_maximum_depthof_binary_tree();
        System.out.println(s.maxDepth(TreeNode.buildTree(3,9,20,null,null,15,7)));
        System.out.println(s.maxDepth(TreeNode.buildTree(1,null,2)));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTree(Integer... values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null; // return empty tree if no values or first value is null
        }

        TreeNode root = new TreeNode(values[0]); // first value is the root
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            // Assign left child if present
            if (i < values.length && values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }
            i++;

            // Assign right child if present
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public void printTree() {
        int depth = maxDepth(this);
        int maxWidth = (1 << depth) - 1;

        String[][] levels = new String[depth][maxWidth];
        for (String[] row : levels) {
            Arrays.fill(row, " ");
        }

        fillLevels(levels, this, 0, 0, maxWidth - 1);

        for (String[] level : levels) {
            System.out.println(String.join("", level));
        }
    }

    private void fillLevels(String[][] levels, TreeNode node, int depth, int left, int right) {
        if (node == null) return;
        int mid = left + (right - left) / 2;
        levels[depth][mid] = Integer.toString(node.val);

        fillLevels(levels, node.left, depth + 1, left, mid - 1);
        fillLevels(levels, node.right, depth + 1, mid + 1, right);
    }

    private int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
}
