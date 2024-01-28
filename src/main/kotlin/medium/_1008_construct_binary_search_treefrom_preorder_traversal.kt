package medium

import common.TreeNode
import common.printTree

/**
 * 1. When creating a new node, it should start from the root node
 * 2. In a recursive fashion, left and the right should be filled to the root node of each recursion
 */
class _1008_construct_binary_search_treefrom_preorder_traversal {
    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        fun walk(l: Int, r: Int): TreeNode? {
            if (l > r) return null

            return TreeNode(preorder[l]).apply {
                var c = l + 1
                while (c <= r && preorder[c] < `val`) {
                    c++
                }

                left = walk(l + 1, c - 1)
                right = walk(c, r)
            }
        }

        return walk(0, preorder.lastIndex)
    }
}

fun main() {
    with(_1008_construct_binary_search_treefrom_preorder_traversal()) {
        printTree(bstFromPreorder(intArrayOf(8,5,1,7,10,12)))
    }
}
