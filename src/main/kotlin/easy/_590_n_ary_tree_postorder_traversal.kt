package easy

import common.Node

class _590_n_ary_tree_postorder_traversal {
    fun postorder(root: Node?): List<Int> {
        val result = mutableListOf<Int>()

        fun walk(node: Node?): Unit = with(node) {
            this ?: return@with
            children.forEach(::walk)
            result.add(this.`val`)
        }
        walk(root)
        return result
    }
}
