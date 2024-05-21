package top_75;

public class _700_searchina_binary_search_tree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        var left = searchBST(root.left, val);
        var right = searchBST(root.right, val);
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        var s = new _700_searchina_binary_search_tree();
        s.searchBST(TreeNode.buildTree(4, 2, 7, 1, 3), 2).printTree();
    }
}
