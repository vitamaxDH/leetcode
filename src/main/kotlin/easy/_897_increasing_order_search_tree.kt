package easy

import common.TreeNode

/**
 *
 */
class _897_increasing_order_search_tree {
    fun increasingBST(root: TreeNode?): TreeNode? {
        root ?: return null

        val dummy = TreeNode(0)
        var cur = dummy

        fun walk(node: TreeNode?) {
            node ?: return
            walk(node.left)
            cur.right = node
            cur = node
            cur.left = null
            walk(node.right)
        }

        walk(root)
        return dummy.right
    }

}
