package topic.tree.easy

import common.TreeNode

object _572_subtreeof_another_tree {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        root ?: return false
        if (isSame(root, subRoot)) return true
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    private fun isSame(s: TreeNode?, t: TreeNode?): Boolean {
        if (s == null && t == null) return true
        if (s == null || t == null) return false

        if (s.`val` != t.`val`) return false

        return isSame(s.left, t.left) && isSame(s.right, t.right)
    }
}

fun main() {
    with(_572_subtreeof_another_tree) {
//        println(isSubtree(TreeNode.fromList(3,4,5,1,2), TreeNode.fromList(4,1,2)))
//        println(isSubtree(TreeNode.fromList(3,4,5,1,2,null,null,null,null,0), TreeNode.fromList(4,1,2)))
//        println(isSubtree(TreeNode.fromList(3,4,5,1,2), TreeNode.fromList(4,1,2,1)))
//        println(isSubtree(TreeNode.fromList(1), TreeNode.fromList(0)))
        println(isSubtree(TreeNode.fromList(1,1), TreeNode.fromList(1)))
    }
}
