package topic.tree.easy

import common.TreeNode

class _872_leaf_similar_trees {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val root1vals = mutableListOf<Int>()
        val root2vals = mutableListOf<Int>()

        fun walk(node: TreeNode?, list: MutableList<Int>) {
            node ?: return

            if (node.left == null && node.right == null) {
                list.add(node.`val`)
            } else {
                walk(node.left, list)
                walk(node.right, list)
            }
        }

        walk(root1, root1vals)
        walk(root2, root2vals)

        if (root1vals.size != root2vals.size) return false
        for (i in root1vals.indices) {
            if (root1vals[i] != root2vals[i]) return false
        }
        return true
    }
}

fun main() {
    with(_872_leaf_similar_trees()) {
//        println(leafSimilar(
//            TreeNode.fromList(3,5,1,6,2,9,8,null,null,7,4),
//            TreeNode.fromList(3,5,1,6,7,4,2,null,null,null,null,null,null,9,8),
//        ))
//        println(leafSimilar(
//            TreeNode.fromList(1,2,3),
//            TreeNode.fromList(1,3,2),
//        ))
        println(leafSimilar(
            TreeNode.fromList(3,5,1,6,7,4,2,null,null,null,null,null,null,9,11,null,null,8,10),
            TreeNode.fromList(3,5,1,6,2,9,8,null,null,7,4),
        ))
    }
}
