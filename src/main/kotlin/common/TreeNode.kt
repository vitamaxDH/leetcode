package common

import java.util.LinkedList
import java.util.Queue

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    companion object {
        fun fromList(vararg levelOrder: Int?): TreeNode? {
            if (levelOrder.isEmpty() || levelOrder[0] == null) return null

            val root = TreeNode(levelOrder[0]!!)
            val queue: Queue<TreeNode> = LinkedList()
            queue.add(root)

            var i = 1
            while (i < levelOrder.size) {
                val current = queue.poll()

                if (i < levelOrder.size && levelOrder[i] != null) {
                    current.left = TreeNode(levelOrder[i]!!)
                    queue.add(current.left)
                }
                i++

                if (i < levelOrder.size && levelOrder[i] != null) {
                    current.right = TreeNode(levelOrder[i]!!)
                    queue.add(current.right)
                }
                i++
            }

            return root
        }
    }

    fun printTree() {
        fun maxDepth(node: TreeNode?): Int = node?.let { 1 + maxOf(maxDepth(it.left), maxDepth(it.right)) } ?: 0

        val depth = maxDepth(this)
        val maxWidth = (1 shl depth) - 1

        val levels = Array(depth) { arrayOfNulls<String>(maxWidth) }
        fillLevels(levels, this, 0, 0, maxWidth)

        for (level in levels) {
            println(level.joinToString("") { it ?: " ".repeat(maxWidth / level.size) })
        }
    }

    fun fillLevels(levels: Array<Array<String?>>, node: TreeNode?, depth: Int, left: Int, right: Int) {
        if (node == null) return
        val mid = left + (right - left) / 2
        levels[depth][mid] = node.`val`.toString()

        fillLevels(levels, node.left, depth + 1, left, mid)
        fillLevels(levels, node.right, depth + 1, mid + 1, right)
    }
}
