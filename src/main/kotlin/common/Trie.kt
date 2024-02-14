package common

class Trie {
    class TrieNode {
        var isEnd = false
        val children: Array<TrieNode?> = arrayOfNulls(26)
    }

    val root = TrieNode()

    fun insert(s: String) {
        var cur = root
        for (c in s) {
            val idx = c - 'a'
            if (cur.children[idx] == null) {
                cur.children[idx] = TrieNode()
            }
            cur = cur.children[idx]!!
        }
        cur.isEnd = true
    }

    fun searchNode(s: String): TrieNode? {
        var cur = root
        for (c in s) {
            val idx = c - 'a'
            cur = cur.children[idx] ?: return null
        }
        return cur
    }

    fun search(s: String): Boolean {
        val node = searchNode(s)
        return node?.isEnd == true
    }

    fun startsWith(s: String): Boolean {
        return searchNode(s) != null
    }

}
// Usage example
fun main() {
    val trie = Trie()

    trie.insert("hello")
    trie.insert("world")

    println("Does 'hello' exist in the trie? ${trie.search("hello")}")
    println("Does 'world' exist in the trie? ${trie.search("world")}")
    println("Does 'helloworld' exist in the trie? ${trie.search("helloworld")}")
    println("Does any word start with 'he'? ${trie.startsWith("he")}")
}
