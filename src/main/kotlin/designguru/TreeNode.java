package designguru;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

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

    public static TreeNode findByValue(TreeNode node, int value) {
        if (node == null) return null;
        if (node.val == value) return node;
        TreeNode left = findByValue(node.left, value);
        TreeNode right = findByValue(node.right, value);
        return left == null ? right : left;
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
