package top_150;

public class _101_symmetric_tree {
    public boolean isSymmetric(TreeNode root) {
        return root == null || walk(root.left, root.right);
    }

    private boolean walk(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && walk(left.left, right.right) && walk(left.right, right.left);
    }

    public static void main(String[] args) {
        var s = new _101_symmetric_tree();
        System.out.println(s.isSymmetric(TreeNode.buildTree(1,2,2,3,4,4,3)));
        System.out.println(s.isSymmetric(TreeNode.buildTree(1,2,2,null,3,null,3)));
    }
}
