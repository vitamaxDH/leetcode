package topic.tree.medium

import common.TreeNode

object _1302_deepest_leaves_sum {
    fun deepestLeavesSum(root: TreeNode?): Int {
        root ?: return 0
        var maxDepth = 1
        var res = 0

        fun walk(node: TreeNode?, depth: Int) {
            node ?: return
            when {
                depth == maxDepth -> res += node.`val`
                depth > maxDepth -> {
                    maxDepth = depth;
                    res = node.`val`
                }
            }
            walk(node.left, depth + 1)
            walk(node.right, depth + 1)
        }

        walk(root, 1)
        return res
    }
}

fun main() {
    with(_1302_deepest_leaves_sum) {
        println(deepestLeavesSum(TreeNode.fromList(1,2,3,4,5,null,6,7,null,null,null,null,8)))
        println(deepestLeavesSum(TreeNode.fromList(6,7,8,2,7,1,3,9,null,1,4,null,null,null,5)))
    }
}
