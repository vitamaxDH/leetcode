package topic.tree.easy

import common.Node
import kotlin.math.max

class _559_maximum_depthof_n_ary_tree {
    fun maxDepth(root: Node?): Int {
        var maxDepth = Int.MIN_VALUE
        fun walk(node: Node?, depth: Int) {
            node ?: return
            maxDepth = max(maxDepth, depth)
            node.children.forEach {
                walk(it, depth + 1)
            }
        }
        walk(root, 1)
        return maxDepth
    }
}

fun main() {
    with(_559_maximum_depthof_n_ary_tree()) {
        println(maxDepth(Node.of(1,null,3,2,4,null,5,6)))
        println(maxDepth(Node.of(1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14)))
    }
}
