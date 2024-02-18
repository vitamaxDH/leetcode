package topic.tree.easy

import common.TreeNode

class _700_searchina_binary_search_tree {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        root ?: return null
        if (root.`val` == `val`) return root
        return searchBST(root.left, `val`) ?: searchBST(root.right, `val`)
    }
}
