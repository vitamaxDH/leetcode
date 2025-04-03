package designguru;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
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
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();
            if (i < values.length && values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }
            i++;
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
        int rows = depth * 2 - 1;
        int width = (1 << depth) - 1;
        String[][] res = new String[rows][width];
        for (String[] row : res) {
            Arrays.fill(row, " ");
        }
        fill(res, this, 0, 0, width - 1, 0);
        for (String[] line : res) {
            System.out.println(String.join("", line));
        }
    }

    private void fill(String[][] res, TreeNode node, int level, int left, int right, int row) {
        if (node == null || left > right || row >= res.length)
            return;
        int mid = left + (right - left) / 2;
        res[row][mid] = Integer.toString(node.val);
        if (row + 1 < res.length) {
            if (node.left != null) {
                int branchCol = left + (mid - left) / 2;
                res[row + 1][branchCol] = "/";
            }
            if (node.right != null) {
                int branchCol = mid + 1 + (right - mid - 1) / 2;
                res[row + 1][branchCol] = "\\";
            }
        }
        fill(res, node.left, level + 1, left, mid - 1, row + 2);
        fill(res, node.right, level + 1, mid + 1, right, row + 2);
    }

    private int maxDepth(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
}
