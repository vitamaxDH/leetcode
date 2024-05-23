package top_75;

public class _236_lowest_common_ancestor_of_a_binary_tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if you found the target, return it.
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // Both means the root itself is the top
        if (left != null && right != null) {
            return root;
        }
        // just returning the result
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        var s = new _236_lowest_common_ancestor_of_a_binary_tree();
        var root = TreeNode.buildTree(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        s.lowestCommonAncestor(
                root,
                TreeNode.findByValue(root, 5),
                TreeNode.findByValue(root, 1)
        ).printTree();
    }
}
