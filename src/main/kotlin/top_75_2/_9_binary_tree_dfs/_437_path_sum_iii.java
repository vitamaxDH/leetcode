package top_75_2._9_binary_tree_dfs;

import designguru.TreeNode;

public class _437_path_sum_iii {
    public int pathSum(TreeNode root, int targetSum) {
        // targetSum을 long으로 변환해 오버플로우 문제를 방지합니다.
        return pathSumHelper(root, targetSum);
    }

    private int pathSumHelper(TreeNode node, long target) {
        if (node == null) return 0;
        // 현재 노드를 시작점으로 하는 경로 + 좌우 서브트리에서 시작하는 경로를 합산
        return helper(node, target)
                + pathSumHelper(node.left, target)
                + pathSumHelper(node.right, target);
    }

    // 현재 노드에서 시작하는 경로 중 target을 만족하는 경우의 수를 반환합니다.
    private int helper(TreeNode node, long target) {
        if (node == null) return 0;
        int count = 0;
        if (node.val == target) count++;
        count += helper(node.left, target - node.val);
        count += helper(node.right, target - node.val);
        return count;
    }

    public static void main(String[] args) {
        var s = new _437_path_sum_iii();
        System.out.println(s.pathSum(TreeNode.buildTree(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1), 8));
        System.out.println(s.pathSum(TreeNode.buildTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22));
        System.out.println(s.pathSum(TreeNode.buildTree(1, null, 2, null, 3, null, 4, null, 5), 3));
    }
}
