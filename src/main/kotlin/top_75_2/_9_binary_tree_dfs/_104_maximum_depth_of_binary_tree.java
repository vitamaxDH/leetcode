package top_75_2._9_binary_tree_dfs;

import designguru.TreeNode;

public class _104_maximum_depth_of_binary_tree {
    public int maxDepth(TreeNode root) {
        return depthByDfs(root, 0);
    }

    private int depthByDfs(TreeNode node, int depth) {
        if (node == null) return depth;
        int leftDepth = depthByDfs(node.left, depth + 1);
        int rightDepth = depthByDfs(node.right, depth + 1);
        return Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        var s = new _104_maximum_depth_of_binary_tree();
        System.out.println(s.maxDepth(TreeNode.buildTree(3, 9, 20, null, null, 15, 7)));
        System.out.println(s.maxDepth(TreeNode.buildTree(1, null, 2)));
    }
}
