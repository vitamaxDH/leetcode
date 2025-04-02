package top_75_2._9_binary_tree_dfs;

import designguru.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _872_leaf_similar_trees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        findLeaves(root1, leaves1);
        findLeaves(root2, leaves2);

        if (leaves1.size() != leaves2.size()) return false;

        for (int i = 0; i < leaves1.size(); i++) {
            if (!Objects.equals(leaves1.get(i), leaves2.get(i))) return false;
        }
        return true;
    }

    private void findLeaves(TreeNode tree, List<Integer> leaves) {
        if (tree == null) return;
        if (tree.left == null && tree.right == null) {
            leaves.add(tree.val);
        }
        findLeaves(tree.left, leaves);
        findLeaves(tree.right, leaves);
    }

    public static void main(String[] args) {
        var s = new _872_leaf_similar_trees();
        System.out.println(s.leafSimilar(TreeNode.buildTree(3,5,1,6,2,9,8,null,null,7,4), TreeNode.buildTree(3,5,1,6,7,4,2,null,null,null,null,null,null,9,8)));
        System.out.println(s.leafSimilar(TreeNode.buildTree(1,2,3), TreeNode.buildTree(1,3,2)));
    }
}
