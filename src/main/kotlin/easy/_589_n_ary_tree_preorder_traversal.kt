package easy

import common.Node

class _589_n_ary_tree_preorder_traversal {
    fun preorder(root: Node?): List<Int> {
        val res = mutableListOf<Int>()

        fun walk(node: Node?): Unit = with(node) {
            this ?: return@with
            res.add(this.`val`)
            children.forEach(::walk)
        }
        walk(root)
        return res
    }
}
