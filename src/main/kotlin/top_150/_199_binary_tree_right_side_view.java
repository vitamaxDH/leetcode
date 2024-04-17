package top_150;

import java.util.ArrayList;
import java.util.List;

public class _199_binary_tree_right_side_view {
    public List<Integer> rightSideView(TreeNode root) {
        var res = new ArrayList<Integer>();
        rightView(root, res, 0);
        return res;
    }

    private void rightView(TreeNode node, List<Integer> res, int depth) {
        if (node == null) return;
        if (res.size() == depth) res.add(node.val);
        rightView(node.right, res, depth + 1);
        rightView(node.left, res, depth + 1);
    }

    public static void main(String[] args) {
        var s = new _199_binary_tree_right_side_view();
        System.out.println(s.rightSideView(TreeNode.buildTree(1,2,3,null,5,null,4)));
        System.out.println(s.rightSideView(TreeNode.buildTree(1,null,3)));
        System.out.println(s.rightSideView(null));
    }
}
