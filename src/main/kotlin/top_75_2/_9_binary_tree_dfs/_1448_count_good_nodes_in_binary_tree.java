package top_75_2._9_binary_tree_dfs;

import designguru.TreeNode;

public class _1448_count_good_nodes_in_binary_tree {
    public int goodNodes(TreeNode root) {
        int[] numOfGoodNodes = new int[1];
        incrementGoodNodes(root, root.val, numOfGoodNodes);
        return numOfGoodNodes[0];
    }

    private void incrementGoodNodes(TreeNode x, int max, int[] numOfGoodNodes) {
        if (x == null) return;
        if (max <= x.val) numOfGoodNodes[0]++;
        incrementGoodNodes(x.left, Math.max(max, x.val), numOfGoodNodes);
        incrementGoodNodes(x.right, Math.max(max, x.val), numOfGoodNodes);
    }

    public static void main(String[] args) {
        var s = new _1448_count_good_nodes_in_binary_tree();
        System.out.println(s.goodNodes(TreeNode.buildTree(3, 1, 4, 3, null, 1, 5)));
        System.out.println(s.goodNodes(TreeNode.buildTree(3, 3, null, 4, 2)));
        System.out.println(s.goodNodes(TreeNode.buildTree(1)));
    }
}
