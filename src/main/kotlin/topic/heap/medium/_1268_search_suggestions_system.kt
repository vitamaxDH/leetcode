package topic.heap.medium

import kotlin.math.min

class _1268_search_suggestions_system {
    class Trie {
        val root = TrieNode()

        class TrieNode {
            val children: Array<TrieNode?> = arrayOfNulls(26)
            val wordIndices = mutableListOf<Int>()
        }

        fun insert(words: Array<String>) {
            var cur: TrieNode?
            for (wordIdx in words.indices) {
                cur = root
                val word = words[wordIdx]
                for (c in word) {
                    val idx = c - 'a'
                    if (cur!!.children[idx] == null) {
                        cur.children[idx] = TrieNode()
                    }
                    cur = cur.children[idx]!!
                    cur.wordIndices.add(wordIdx)
                }
            }
        }

        fun wordIndices(word: String): List<List<Int>> {
            var cur = root
            val res = mutableListOf<MutableList<Int>>()
            repeat(word.length) { res.add(mutableListOf()) }
            for (cIdx in word.indices) {
                val idx = word[cIdx] - 'a'
                if (cur.children[idx] == null) continue
                cur = cur.children[idx]!!
                res[cIdx].addAll(cur.wordIndices)
            }
            return res
        }
    }

    fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
        products.sort()
        val trie = Trie()
        trie.insert(products)
        return trie.wordIndices(searchWord).map {
            val words = mutableListOf<String>()
            for (idx in 0 .. min(2, it.lastIndex)) {
                words.add(products[it[idx]])
            }
            words
        }
    }

}

fun main() {
    with(_1268_search_suggestions_system()) {
//        println(suggestedProducts(arrayOf("mobile", "mouse", "moneypot", "monitor", "mousepad"), "mouse"))
//        println(suggestedProducts(arrayOf("havana"), "havana"))
//        println(suggestedProducts(arrayOf("havana"), "tatiana"))
        println(suggestedProducts(arrayOf("mobile","mouse","moneypot","monitor","mousepad"), "mouse"))
    }
}
