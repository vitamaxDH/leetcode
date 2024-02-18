package topic.tree.easy

import common.TreeNode

class _1022_sumof_root_to_leaf_binary_numbers {
    fun sumRootToLeaf(root: TreeNode?): Int {
        var res = 0
        fun walk(node: TreeNode?, acc: Int) {
            node ?: return
            if (node.left == null && node.right == null) {
                res += (acc shl 1) + node.`val`
            } else {
                walk(node.left, (acc shl 1) + node.`val`)
                walk(node.right, (acc shl 1) + node.`val`)
            }
        }
        walk(root, 0)
        return res
    }
}

fun main() {
    with(_1022_sumof_root_to_leaf_binary_numbers()) {
        println(sumRootToLeaf(TreeNode.fromList(1,0,1,0,1,0,1)))
    }
}
