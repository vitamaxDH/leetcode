package common

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()

    companion object {
        fun of(vararg arr: Int?): Node? {
            if (arr.isEmpty() || arr[0] == null) return null

            val root = Node(arr[0]!!)
            val queue: MutableList<Node> = mutableListOf(root)
            var i = 1

            while (i < arr.size) {
                val parent = queue.removeAt(0)

                val children = mutableListOf<Node?>()
                while (i < arr.size && arr[i] != null) {
                    val child = Node(arr[i]!!)
                    children.add(child)
                    queue.add(child)
                    i++
                }

                parent.children = children
                i++ // Skip the null that marks the end of children for this parent
            }

            return root
        }
    }
}

