package topic.tree.medium

import common.TreeNode

object _2265_count_nodes_equalto_averageof_subtree {
    var res = 0

    fun averageOfSubtree(root: TreeNode?): Int {
        res = 0
        root ?: return 0
        visitNode(root)
        return res
    }


    private fun visitNode(node: TreeNode?): IntArray {
        node ?: return IntArray(2) { 0 }

        val leftSubTrees = visitNode(node.left)
        val rightSubTrees = visitNode(node.right)

        val sum = leftSubTrees[0] + rightSubTrees[0] + node.`val`
        val num = leftSubTrees[1] + rightSubTrees[1] + 1

        if (sum / num == node.`val`) res++

        return IntArray(2).apply {
            this[0] = sum
            this[1] = num
        }
    }

}

fun main() {
    with(_2265_count_nodes_equalto_averageof_subtree) {
        println(averageOfSubtree(TreeNode.fromList(4,8,5,0,1,null,6)))
        println(averageOfSubtree(TreeNode.fromList(1)))
    }
}
