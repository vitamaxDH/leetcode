package top_75;

public class _1372_longest_zig_zag_path_in_a_binary_tree {
    public int longestZigZag(TreeNode root) {
        if (root.left == null && root.right == null) return 0;
        // go deep and deeper.
        // how? in every function, they will have a bigger one
        int left = traverse(root.left, 1, true);
        int right = traverse(root.right, 1, false);
        return Math.max(left, right);
    }

    public int traverse(TreeNode node, int zigZag, boolean wasLeft) {
        if (node == null) return zigZag;
        if (node.left == null && node.right == null) return zigZag;

        int max = 0;
        if (wasLeft) {
            int left = traverse(node.left, 1, true);
            int right = node.right == null ? traverse(null, zigZag, false) : traverse(node.right, zigZag + 1, false);
            max = Math.max(max, right);
            max = Math.max(max, left);
        } else {
            int right = traverse(node.right, 1, false);
            int left = node.left == null ? traverse(null, zigZag, true) : traverse(node.left, zigZag + 1, true);
            max = Math.max(max, right);
            max = Math.max(max, left);
        }
        return max;
    }

    public static void main(String[] args) {
        var s = new _1372_longest_zig_zag_path_in_a_binary_tree();
        TreeNode root = TreeNode.buildTree(1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1);
//        root.printTree();
        System.out.println(s.longestZigZag(root));

        TreeNode root1 = TreeNode.buildTree(1, 1, 1, null, 1, null, null, 1, 1, null, 1);
//        root1.printTree();
        System.out.println(s.longestZigZag(root1));
    }
}
