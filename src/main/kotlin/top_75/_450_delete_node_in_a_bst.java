package top_75;

public class _450_delete_node_in_a_bst {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                TreeNode rightMin = findRightMin(root.right);
                root.val = rightMin.val;
                root.right = deleteNode(root.right, rightMin.val);
            }
        }
        return root;
    }

    public TreeNode findRightMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        var s = new _450_delete_node_in_a_bst();
        var root = TreeNode.buildTree(5, 3, 6, 2, 4, null, 7);
        var root2 = TreeNode.buildTree(5, 3, 6, 2, 4, null, 7);
        s.deleteNode(root, 3).printTree();
        s.deleteNode(root2, 0).printTree();

//        TreeNode.buildTree(5, 4, 6, 2, null, null, 7).printTree();
//        TreeNode.buildTree(5, 2, 6, null, 4, null, 7).printTree();
    }
}
