package top_75;

public class _1448_count_good_nodes_in_binary_tree {
    public int goodNodes(TreeNode root) {
        // I need a sentinel, the max value
        // I'm going to use a recursive - creating a new function with it
        int[] res = new int[]{0};
        findGoodNode(root, root.val, res);
        return res[0];
    }

    private void findGoodNode(TreeNode node, int max, int[] res) {
        if (node == null) return;
        if (max <= node.val) {
            res[0]++;
        }
        findGoodNode(node.left, Math.max(max, node.val), res);
        findGoodNode(node.right, Math.max(max, node.val), res);
    }

    public static void main(String[] args) {
        var s = new _1448_count_good_nodes_in_binary_tree();
        System.out.println(s.goodNodes(TreeNode.buildTree(3, 1, 4, 3, null, 1, 5)));
        System.out.println(s.goodNodes(TreeNode.buildTree(3, 3, null, 4, 2)));
        System.out.println(s.goodNodes(TreeNode.buildTree(1)));
    }
}
