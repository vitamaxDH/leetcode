package easy

import common.TreeNode

fun sumOfLeftLeaves(root: TreeNode?): Int {
    root ?: return 0
    if (root.left == null && root.right == null) return 0
    val lefts = mutableListOf<Int>()
    fun sub(root: TreeNode?) {
        root ?: return
        val left = root.left
        val right = root.right
        if (left == null && right == null) return
        left?.let {
            if (it.left == null && it.right == null) {
                lefts.add(it.`val`)
            }
        }
        sub(left)
        sub(right)
    }
    sub(root)
    return lefts.sum()
}
