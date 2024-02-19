package topic.tree.easy

import common.TreeNode

class _637_averageof_levelsin_binary_tree {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val map = mutableMapOf<Int, MutableList<Int>>()

        fun walk(node: TreeNode?, level: Int) {
            node ?: return
            val nums = map[level] ?: mutableListOf()
            nums.add(node.`val`)
            map[level] = nums
            walk(node.left, level + 1)
            walk(node.right, level + 1)
        }
        walk(root, 0)
        val res = DoubleArray(map.size)
        for (i in res.indices) {
            res[i] = map[i]!!.average()
        }
        return res
    }
}

fun main() {
    with(_637_averageof_levelsin_binary_tree()) {
        println(averageOfLevels(TreeNode.fromList(3,9,20,null,null,15,7)).toList())
        println(averageOfLevels(TreeNode.fromList(3,9,20,15,7)).toList())
    }
}
