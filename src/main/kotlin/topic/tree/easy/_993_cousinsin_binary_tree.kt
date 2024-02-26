package topic.tree.easy

import common.TreeNode

object _993_cousinsin_binary_tree {
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        root!!.printTree()
        var parent: TreeNode? = null
        var level = 0
        val queue = ArrayDeque<Pair<TreeNode, Int>>()
        queue.add(Pair(root, 0))
        while (queue.isNotEmpty()) {
            val e = queue.removeFirst()

            if (e.first.left?.`val` == x || e.first.right?.`val` == x) {
                parent = e.first
                level = e.second
                queue.clear()
                break
            }
            e.first.left?.let {
                queue.add(Pair(it, e.second + 1))
            }
            e.first.right?.let {
                queue.add(Pair(it, e.second + 1))
            }
        }

        if (parent == null) return false

        queue.clear()
        queue.add(Pair(root, 0))
        while (queue.isNotEmpty()) {
            val e = queue.removeFirst()

            if ((e.first.left?.`val` == y || e.first.right?.`val` == y) && parent != e.first && level == e.second) {
                return true
            }
            e.first.left?.let {
                queue.add(Pair(it, e.second + 1))
            }
            e.first.right?.let {
                queue.add(Pair(it, e.second + 1))
            }
        }

        return false;
    }
}

fun main() {
    with(_993_cousinsin_binary_tree) {
        println(isCousins(TreeNode.fromList(1,2,3,4),4,3))
        println(isCousins(TreeNode.fromList(1,2,3,null,4,null,5),5,4))
        println(isCousins(TreeNode.fromList(1,2,3,null,4),2,3))
        println(isCousins(TreeNode.fromList(1,2,3,null,null,null,4,5),1,2))
    }
}
