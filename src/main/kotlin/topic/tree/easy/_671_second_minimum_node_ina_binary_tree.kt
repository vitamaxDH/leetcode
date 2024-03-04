package topic.tree.easy

import common.TreeNode

object _671_second_minimum_node_ina_binary_tree {
    fun findSecondMinimumValue(root: TreeNode?): Int {
        var first = Int.MAX_VALUE
        var second = -1
        fun walk(node: TreeNode?) {
            node ?: return

            when  {
                node.`val` == first || node.`val` == second -> Unit
                node.`val` < first -> {
                    if (second != -1) {
                        second = first
                    }
                    first = node.`val`
                }
                second == -1 || node.`val` < second -> second = node.`val`
            }
            walk(node.left)
            walk(node.right)
        }
        walk(root)
        return second
    }
}

fun main() {
    with(_671_second_minimum_node_ina_binary_tree) {
        println(findSecondMinimumValue(TreeNode.fromList(2,2,5,null,null,5,7)))
        println(findSecondMinimumValue(TreeNode.fromList(2,2,2)))
    }
}
