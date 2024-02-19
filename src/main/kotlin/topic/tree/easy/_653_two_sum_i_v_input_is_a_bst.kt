package topic.tree.easy

import common.TreeNode

class _653_two_sum_i_v_input_is_a_bst {
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        val values = mutableListOf<Int>()

        fun walk(node: TreeNode?) {
            node ?: return
            values.add(node.`val`)
            walk(node.left)
            walk(node.right)
        }
        walk(root)
        if (values.isEmpty()) return false

        values.sort()
        var s = 0
        var e = values.lastIndex

        while (s < e) {
            val sum = values[s] + values[e]
            if (sum == k) {
                return true
            } else if (sum < k) {
                s++
            } else {
                e--
            }
        }
        return false
    }
}

fun main() {
    with(_653_two_sum_i_v_input_is_a_bst()) {
//        println(findTarget(TreeNode.fromList(5,3,6,2,4,null,7), k = 9))
//        println(findTarget(TreeNode.fromList(5,3,6,2,4,null,7), k = 28))
        println(findTarget(TreeNode.fromList(0,-1,2,-3,null,null,4), k = -4))
    }
}
