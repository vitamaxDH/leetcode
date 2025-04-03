package top_75_2._9_binary_tree_dfs;

import designguru.TreeNode;

public class _1372_longest_zig_zag_path_in_a_binary_tree {
    public int longestZigZag(TreeNode root) {
        if (root.left == null && root.right == null) return 0;
        int[] maxZigZag = {1};
        root.printTree();
        traverse(root.left, true, 1, maxZigZag);
        traverse(root.right, false, 1, maxZigZag);
        return maxZigZag[0];
    }

    private void traverse(TreeNode node, boolean isLeft, int curZigZg, int[] maxZigZag) {
        if (node == null) return;
        if (node.left != null) {
            int leftZigZag = curZigZg;
            if (!isLeft) {
                leftZigZag++;
                if (maxZigZag[0] < leftZigZag) maxZigZag[0] = leftZigZag;
            } else if (leftZigZag > 1) {
                leftZigZag = 1; // reset
            }
            traverse(node.left, true, leftZigZag, maxZigZag);
        }
        if (node.right != null) {
            int rightZigZag = curZigZg;
            if (isLeft) {
                rightZigZag++;
                if (maxZigZag[0] < rightZigZag) maxZigZag[0] = rightZigZag;
            } else if (rightZigZag > 1) {
                rightZigZag = 1; // reset
            }
            traverse(node.right, false, rightZigZag, maxZigZag);
        }
    }

    public static void main(String[] args) {
        var s = new _1372_longest_zig_zag_path_in_a_binary_tree();
        System.out.println(s.longestZigZag(TreeNode.buildTree(1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1)));
        System.out.println(s.longestZigZag(TreeNode.buildTree(1, 1, 1, null, 1, null, null, 1, 1, null, 1)));
        System.out.println(s.longestZigZag(TreeNode.buildTree(1)));
        System.out.println(s.longestZigZag(TreeNode.buildTree(1, null, 1, 1, null, 1, 1, null, 1, null, 1)));
    }
}
