package top_150;

import java.util.Arrays;

public class _105_construct_binary_treefrom_preorderand_inorder_traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;

        var root = new TreeNode(preorder[0]);
        var mid = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                mid = i;
            }
        }

        int[] leftPre = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] leftIn = Arrays.copyOfRange(inorder, 0, mid);
        int[] rightPre = Arrays.copyOfRange(preorder, mid + 1, preorder.length - 1);
        int[] rightIn = Arrays.copyOfRange(inorder, mid + 1, inorder.length - 1);
        root.left = buildTree(leftPre, leftIn);
        root.right = buildTree(rightPre, rightIn);
        return root;
    }

    public static void main(String[] args) {
        var s = new _105_construct_binary_treefrom_preorderand_inorder_traversal();
        s.buildTree(new int[] {3,9,20,15,7}, new int[]{9,3,15,20,7}).printTree();
        s.buildTree(new int[] {-1}, new int[]{-1}).printTree();
    }
}
