import java.util.LinkedList
import java.util.Queue

fun <T> dfs(node: TreeNode<T>?) {
    if (node == null) return
    println(node.value) // Process the node
    dfs(node.left)
    dfs(node.right)
}

fun <T> bfs(root: TreeNode<T>?) {
    if (root == null) return
    val queue: Queue<TreeNode<T>> = LinkedList()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val node = queue.remove()
        println(node.value) // Process the node
        node.left?.let { queue.add(it) }
        node.right?.let { queue.add(it) }
    }
}

class TreeNode<T>(val value: T, var left: TreeNode<T>? = null, var right: TreeNode<T>? = null)

fun <T> printTree(root: TreeNode<T>?, prefix: String = "", isTail: Boolean = true) {
    root?.right?.let {
        printTree(it, prefix + if (isTail) "    " else "|   ", false)
    }
    println(prefix + (if (isTail) "└── " else "├── ") + root?.value)
    root?.left?.let {
        printTree(it, prefix + if (isTail) "    " else "|   ", true)
    }
}
