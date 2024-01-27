class UnionFind(n: Int) {
    private val parent = IntArray(n) { it }
    private val rank = IntArray(n) { 0 }
    private val groups = mutableMapOf<Int, MutableSet<Int>>()

    init {
        for (i in 0 until n) {
            groups[i] = mutableSetOf(i)
        }
    }

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x]) // Path compression
        }
        return parent[x]
    }

    fun union(x: Int, y: Int) {
        val xRoot = find(x)
        val yRoot = find(y)
        if (xRoot != yRoot) {
            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot
                groups[yRoot]?.addAll(groups[xRoot]!!)
                groups.remove(xRoot)
            } else if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot
                groups[xRoot]?.addAll(groups[yRoot]!!)
                groups.remove(yRoot)
            } else {
                parent[yRoot] = xRoot
                rank[xRoot]++
                groups[xRoot]?.addAll(groups[yRoot]!!)
                groups.remove(yRoot)
            }
        }
    }

    fun printGroups() {
        println("Current Groups:")
        groups.forEach { (key, value) ->
            println("Group led by $key: $value")
        }
    }
}

fun main() {
    val uf = UnionFind(10)

    println("Before any unions:")
    uf.printGroups()

    uf.union(2, 3)
    uf.union(3, 4)
    uf.union(8, 9)

    println("\nAfter unions:")
    uf.printGroups()
}
