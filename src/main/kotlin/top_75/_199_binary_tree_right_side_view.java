package top_75;

import java.util.ArrayList;
import java.util.List;

public class _199_binary_tree_right_side_view {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        walk(root, res, 0);
        return res;
    }

    private void walk(TreeNode node, List<Integer> res, int level) {
        if (node == null) return;
        // Right one is going to be executed first, so
        if (level == res.size()) {
            res.add(node.val);
        }
        walk(node.right, res, level + 1);
        walk(node.left, res, level + 1);
    }

    public static void main(String[] args) {
        var s = new _199_binary_tree_right_side_view();
        System.out.println(s.rightSideView(TreeNode.buildTree(1, 2, 3, null, 5, null, 4)));
        System.out.println(s.rightSideView(TreeNode.buildTree(1,null,3)));
    }
}
