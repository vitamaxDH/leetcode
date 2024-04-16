package top_150;

public class _226_invert_binary_tree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        var temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        var s = new _226_invert_binary_tree();
        s.invertTree(TreeNode.buildTree(4,2,7,1,3,6,9)).printTree();
        s.invertTree(TreeNode.buildTree(2,1,3)).printTree();
        s.invertTree(TreeNode.buildTree(1,2)).printTree();
        TreeNode.buildTree(1,2).printTree();
    }
}
