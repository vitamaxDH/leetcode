package topic.tree.easy

import common.TreeNode
import kotlin.math.abs

object _530_minimum_absolute_difference_in_bst {
    fun getMinimumDifference(root: TreeNode?): Int {
        var prev: TreeNode? = null
        var min = Int.MAX_VALUE
        fun walk(node: TreeNode?) {
            node ?: return
            walk(node.left)

            prev?.let {
                min = minOf(min, abs(it.`val` - node.`val`))
            }

            prev = node
            walk(node.right)
        }
        walk(root)
        return min
    }
}

fun main() {
    with(_530_minimum_absolute_difference_in_bst) {
        println(getMinimumDifference(TreeNode.fromList(4,2,6,1,3)))
        println(getMinimumDifference(TreeNode.fromList(1,0,48,null,null,12,49)))
    }
}
