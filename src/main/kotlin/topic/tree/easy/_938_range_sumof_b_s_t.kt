package topic.tree.easy

import common.TreeNode

class _938_range_sumof_b_s_t {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        root ?: return 0
        var res = 0
        val range = low..high
        fun walk(node: TreeNode?) {
            node ?: return
            if (node.`val` in range) {
                res += node.`val`
            }
            walk(node.left)
            walk(node.right)
        }
        walk(root)
        return res
    }
}

fun main() {
    with(_938_range_sumof_b_s_t()) {
        println(rangeSumBST(TreeNode.fromList(10,5,15,3,7,null,18), 7, 15))
        println(rangeSumBST(TreeNode.fromList(10,5,15,3,7,13,18,1,null,6), 6, 10))
    }
}
