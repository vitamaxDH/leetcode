package topic.tree.easy

import common.TreeNode

object _543_diameterof_binary_tree {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        root ?: return 0
        var max = 0
        fun walk(node: TreeNode?): Int {
            node ?: return -1

            val left = walk(node.left)
            val right = walk(node.right)

            max = maxOf(max, 2 + left + right)

            return 1 + maxOf(left, right)
        }
        walk(root)
        return max
    }
}

fun main() {
    with(_543_diameterof_binary_tree) {
//        println(diameterOfBinaryTree(TreeNode.fromList(1,2,3,4,5)))
//        println(diameterOfBinaryTree(TreeNode.fromList(1,2)))
        println(diameterOfBinaryTree(TreeNode.fromList(4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2)))
    }
}
