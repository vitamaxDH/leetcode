package topic.tree.easy

import common.TreeNode
import java.util.Stack

class _965_univalued_binary_tree {
    fun isUnivalTree(root: TreeNode?): Boolean {
        root ?: return true
        val rootVal = root.`val`
        val stack = Stack<TreeNode?>()
        stack.push(root)

        while (stack.isNotEmpty()) {
            val node = stack.pop()
            node ?: continue

            if (node.`val` != rootVal) {
                return false
            }

            node.right?.let { stack.push(it) }
            node.left?.let { stack.push(it) }
        }

        return true
    }

}

fun main() {
    with(_965_univalued_binary_tree()) {
        println(isUnivalTree(TreeNode.fromList(1,1,1,1,1,null,1)))
    }
}
