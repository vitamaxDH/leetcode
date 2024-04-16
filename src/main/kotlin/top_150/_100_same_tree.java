package top_150;

public class _100_same_tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        var s = new _100_same_tree();
        System.out.println(s.isSameTree(
                        TreeNode.buildTree(1, 2, 3),
                        TreeNode.buildTree(1, 2, 3)
                )
        );
        System.out.println(s.isSameTree(
                        TreeNode.buildTree(1, 2),
                        TreeNode.buildTree(1, null, 2)
                )
        );
        System.out.println(s.isSameTree(
                        TreeNode.buildTree(1, 2, 1),
                        TreeNode.buildTree(1, 1, 2)
                )
        );
    }
}
