package topic.tree.easy

import common.TreeNode

class _2331_evaluate_boolean_binary_tree {
    fun evaluateTree(root: TreeNode?): Boolean {
        root ?: return false
        if (root.`val` == 0) return false
        if (root.`val` == 1) return true

        val l = evaluateTree(root.left)
        val r = evaluateTree(root.right)
        return if (root.`val` == 2) l or r else l and r
    }

}

fun main() {
    with(_2331_evaluate_boolean_binary_tree()) {
        println(evaluateTree(TreeNode.fromList(2, 1, 3, null, null, 0, 1)))
    }
}
