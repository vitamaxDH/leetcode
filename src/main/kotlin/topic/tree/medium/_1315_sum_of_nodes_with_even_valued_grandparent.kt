package topic.tree.medium

import common.TreeNode

object _1315_sum_of_nodes_with_even_valued_grandparent {
    fun sumEvenGrandparent(root: TreeNode?): Int {
        root ?: return 0
        var res = 0
        fun walk(node: TreeNode?, grandParent: TreeNode?, parent: TreeNode?) {
            node ?: return
            grandParent?.let {
                if (it.`val` % 2 == 0) {
                    res += node.`val`
                }
            }
            if (node.`val` % 2 == 0) {
                walk(node.left, parent, node)
                walk(node.right, parent, node)
            } else {
                walk(node.left, parent, null)
                walk(node.right, parent, null)
            }
        }
        walk(root, null, null)
        return res
    }
}

fun main() {
    with(_1315_sum_of_nodes_with_even_valued_grandparent) {
        println(sumEvenGrandparent(TreeNode.fromList(6,7,8,2,7,1,3,9,null,1,4,null,null,null,5)))
        println(sumEvenGrandparent(TreeNode.fromList(1)))
    }
}
