package topic.tree.easy

import common.TreeNode

object _993_cousinsin_binary_tree {
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        root!!.printTree()
        var parent: TreeNode? = null
        var level: Int = Int.MIN_VALUE
        val queue = ArrayDeque<Pair<TreeNode, Int>>()
        queue.add(Pair(root, 0))
        while (queue.isNotEmpty()) {
            val q = queue.removeFirst()
            val node = q.first

            if (node.left?.`val` == x || node.right?.`val` == x) {
                parent = node
                level = q.second
                queue.clear()
                break
            }
            node.left?.let {
                queue.add(Pair(it, q.second + 1))
            }
            node.right?.let {
                queue.add(Pair(it, q.second + 1))
            }
        }

        if (parent == null) return false

        queue.clear()
        queue.add(Pair(root, 0))
        while (queue.isNotEmpty()) {
            val q = queue.removeFirst()
            val node = q.first

            if ((node.left?.`val` == y || node.right?.`val` == y) && parent != node && level == q.second) {
                return true
            }
            node.left?.let {
                queue.add(Pair(it, q.second + 1))
            }
            node.right?.let {
                queue.add(Pair(it, q.second + 1))
            }
        }

        return false
    }
}

fun main() {
    with(_993_cousinsin_binary_tree) {
//        println(isCousins(TreeNode.fromList(1,2,3,4),4,3))
//        println(isCousins(TreeNode.fromList(1,2,3,null,4,null,5),5,4))
//        println(isCousins(TreeNode.fromList(1,2,3,null,4),2,3))
//        println(isCousins(TreeNode.fromList(1,2,3,null,null,null,4,5),1,2))
        println(isCousins(TreeNode.fromList(1,2,3,4),4,3))
    }
}
