package topic.linkedlist.medium

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}

class _116_populating_next_right_pointersin_each_node {
    fun connect(root: Node?): Node? {
        root ?: return null
        fun walk(node: Node?) {
            node ?: return
            node.left?.next = node.right
            node.right?.next = node.next?.left
            walk(node.left)
            walk(node.right)
        }
        walk(root)
        return root
    }
}
