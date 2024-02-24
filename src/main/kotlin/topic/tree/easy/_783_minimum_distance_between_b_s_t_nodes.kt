package topic.tree.easy

import common.TreeNode
import kotlin.math.abs

object _783_minimum_distance_between_b_s_t_nodes {
    fun minDiffInBST(root: TreeNode?): Int {
        var prev: TreeNode? = null
        var min = Int.MAX_VALUE
        fun walk(node: TreeNode?) {
            node ?: return
            walk(node.left)
            prev?.let {
                min = minOf(min, abs(node.`val` - it.`val`))
            }
            prev = node
            walk(node.right)
        }
        walk(root)
        return min
    }
}

fun main() {
    with(_783_minimum_distance_between_b_s_t_nodes) {
        println(minDiffInBST(TreeNode.fromList(4,2,6,1,3)))
        println(minDiffInBST(TreeNode.fromList(1,0,48,null,null,12,49)))
    }
}
