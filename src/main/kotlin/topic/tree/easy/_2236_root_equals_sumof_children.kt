package topic.tree.easy

import common.TreeNode

class _2236_root_equals_sumof_children {
    fun checkTree(root: TreeNode?): Boolean {
        return root!!.`val` == root.left!!.`val` + root.right!!.`val`
    }
}
