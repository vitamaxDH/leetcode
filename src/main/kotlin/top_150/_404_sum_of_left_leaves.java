package top_150;

public class _404_sum_of_left_leaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return walk(root.left, true) + walk(root.right, false);
    }

    private int walk(TreeNode node, boolean isLeft) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            return isLeft ? node.val : 0;
        }

        var left = walk(node.left, true);
        var right = walk(node.right, false);
        return left + right;
    }


    public static void main(String[] args) {
        var s = new _404_sum_of_left_leaves();
        System.out.println(s.sumOfLeftLeaves(TreeNode.buildTree(3,9,20,null,null,15,7)));
    }
}
