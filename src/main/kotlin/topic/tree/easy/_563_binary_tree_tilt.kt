package topic.tree.easy

import common.TreeNode
import kotlin.math.abs

class _563_binary_tree_tilt {
    fun findTilt(root: TreeNode?): Int {
        root ?: return 0
        var res = 0
        fun walk(node: TreeNode?): Int {
            node ?: return 0

            val left = walk(node.left)
            val right = walk(node.right)

            res += abs(left - right)
            return node.`val` + left + right
        }
        walk(root)
        return res
    }
}

fun main() {
    with(_563_binary_tree_tilt()) {
        println(findTilt(TreeNode.fromList(1,2,3)))
        println(findTilt(TreeNode.fromList(4,2,9,3,5,null,7)))
        println(findTilt(TreeNode.fromList(21,7,14,1,1,2,2,3,3)))
    }
}
