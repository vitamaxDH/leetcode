package top_75;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _872_leaf_similar_trees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        extractLeaves(root1, leaves1);
        extractLeaves(root2, leaves2);

        if (leaves1.size() != leaves2.size()) return false;
        for (int i = 0; i < leaves1.size(); i++) {
            if (!Objects.equals(leaves1.get(i), leaves2.get(i))) return false;
        }
        return true;
    }

    private void extractLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) return;
        extractLeaves(root.left, leaves);
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }
        extractLeaves(root.right, leaves);
    }

    public static void main(String[] args) {
        var s = new _872_leaf_similar_trees();
        System.out.println(s.leafSimilar(TreeNode.buildTree(3,5,1,6,2,9,8,null,null,7,4), TreeNode.buildTree(3,5,1,6,7,4,2,null,null,null,null,null,null,9,8)));
        System.out.println(s.leafSimilar(TreeNode.buildTree(1,2,3), TreeNode.buildTree(1,3,2)));
    }
}
