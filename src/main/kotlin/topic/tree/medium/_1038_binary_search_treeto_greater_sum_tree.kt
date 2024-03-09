package topic.tree.medium

import common.TreeNode

object _1038_binary_search_treeto_greater_sum_tree {
    fun bstToGst(root: TreeNode?): TreeNode? {
        root ?: return null
        var sum = 0
        fun sumTrees(node: TreeNode?) {
            node ?: return
            sumTrees(node.left)
            sum += node.`val`
            sumTrees(node.right)
        }
        sumTrees(root)

        fun walk(node: TreeNode?) {
            node ?: return

            walk(node.left)
            val nodeVal = node.`val`
            node.`val` = sum
            sum -= nodeVal
            walk(node.right)
        }

        walk(root)
        return root
    }

}

fun main() {
    with(_1038_binary_search_treeto_greater_sum_tree) {
        bstToGst(TreeNode.fromList(4,1,6,0,2,5,7,null,null,null,3,null,null,null,8))!!.printTree()
        bstToGst(TreeNode.fromList(0,null,1))!!.printTree()
    }
}
