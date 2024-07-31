package common2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

    // Method to print the tree structure
    void printTree() {
        int depth = maxDepth(this);
        int maxWidth = (1 << depth) - 1;

        String[][] levels = new String[depth][maxWidth];
        for (String[] level : levels) {
            Arrays.fill(level, " ");
        }

        fillLevels(levels, this, 0, 0, maxWidth);

        for (String[] level : levels) {
            System.out.println(String.join("", level));
        }
    }

    // Helper method to calculate the maximum depth of the tree
    private int maxDepth(TreeNode node) {
        return node == null ? 0 : 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    // Recursive function to fill levels of the tree
    private void fillLevels(String[][] levels, TreeNode node, int depth, int left, int right) {
        if (node == null) return;
        int mid = left + (right - left) / 2;
        levels[depth][mid] = String.valueOf(node.val);

        fillLevels(levels, node.left, depth + 1, left, mid);
        fillLevels(levels, node.right, depth + 1, mid + 1, right);
    }

}
