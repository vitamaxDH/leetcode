package topic.tree.easy

import common.TreeNode

class ___501_find_modein_binary_search_tree {
    var curVal = 0
    var curCount = 0
    var maxCount = 0
    val map = mutableMapOf<Int, Int>()

    fun findMode(root: TreeNode?): IntArray {
        root?.printTree()
        var node = root
        while (node != null) {
            if (node.left == null) {
                handleMode(node.`val`)
                node = node.right
            } else {
                var cur = node.left
                while (cur?.right != null && cur.right != node) {
                    cur = cur.right
                }
                if (cur?.right == node) {
                    cur.right = null
                    node = node.right
                } else {
                    handleMode(node.`val`)
                    cur?.right = node
                    node = node.left
                }
            }
        }
        return intArrayOf()
    }

    fun handleMode(v: Int) {
        if (curVal != v) {
            curVal = v
            curCount = 0
        }
        curCount++
        if (curCount > maxCount) {
            maxCount = curCount
            map[v] = maxCount
        } else if (curCount == maxCount) {
            map[v] = maxCount
        }
    }
}

fun main() {
//    println(_501_find_modein_binary_search_tree().findMode(TreeNode.fromList(1,null,2,2)).toList())
//    println(_501_find_modein_binary_search_tree().findMode(TreeNode.fromList(0)).toList())
    println(___501_find_modein_binary_search_tree().findMode(TreeNode.fromList(1,0,1,0,0,1,1,0)).toList())
}
