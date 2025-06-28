package top_75_2._9_binary_tree_dfs;

import designguru.TreeNode;

public class _236_lowest_common_ancestor_of_a_binary_tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        return helper(root, p.val, q.val);
    }

    private TreeNode helper(TreeNode node, int p, int q) {
        if (node == null) return null;
        if (node.val == p || node.val == q) {
            return node;
        }
        boolean leftFound = find(node.left, p);
        boolean rightFound = find(node.right, q);
        if (leftFound && rightFound) {
            return node;
        } else if (leftFound) {
            return helper(node.left, p, q);
        } else if (rightFound){
            return helper(node.right, p, q);
        } else {
            return helper(node, q, p);
        }
    }

    private boolean find(TreeNode node, int target) {
        if (node == null) return false;
        if (node.val == target) return true;
        return find(node.left, target) || find(node.right, target);
    }

    public static void main(String[] args) {
        {
            System.out.println("CASE: 1\n=========================");
            var root = TreeNode.buildTree(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
            test(root, 5, 1);
        }
        {
            System.out.println("CASE: 2\n=========================");
            var root = TreeNode.buildTree(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
            test(root, 5, 4);
        }
        {
            System.out.println("CASE: 3\n=========================");
            var root = TreeNode.buildTree(1, 2);
            test(root, 1, 2);
        }
        {
            System.out.println("CASE: 4\n=========================");
            var root = TreeNode.buildTree(1, 2, 3);
            test(root, 3, 2);
        }
    }

    public static void test(TreeNode root, int p, int q) {
        var s = new _236_lowest_common_ancestor_of_a_binary_tree();
        System.out.println(s.lowestCommonAncestor(root, root.findByValue(p), root.findByValue(q)).val);
    }
}
