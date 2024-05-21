package top_75;

public class _437_path_sum_iii {
    int cnt = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return cnt;
        walk(root, 0, targetSum);
        return cnt;
    }

    public void walk(TreeNode node, int cur, int targetSum) {
        if (node == null) return;

        int newCur = cur + node.val;
        if (newCur == targetSum) {
            cnt++;
        }
        walk(node.left, newCur, targetSum);
        walk(node.right, newCur, targetSum);
    }

    public static void main(String[] args) {
        var s = new _437_path_sum_iii();
        TreeNode root = TreeNode.buildTree(1,null,2,null,3,null,4,null,5);
        root.printTree();
        System.out.println(s.pathSum(root, 3));

//        TreeNode root1 = TreeNode.buildTree(5,4,8,11,null,13,4,7,2,null,null,5,1);
//        root1.printTree();
//        System.out.println(s.pathSum(root1, 22));
    }
}
