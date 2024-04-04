package easy

import java.util.PriorityQueue

object _3093_longest_common_suffix_queries {
    fun stringIndices(wordsContainer: Array<String>, wordsQuery: Array<String>): IntArray {
        val cands = PriorityQueue<Pair<Int, Int>> { a, b ->
            a.second - b.second
        }
        val res = IntArray(wordsQuery.size)
        var shortestLen = Int.MAX_VALUE
        var shortestLenIdx = 0
        for (i in wordsQuery.indices) {
            val q = wordsQuery[i]
            cands.clear()
            var lcsLen = 0
            for (j in wordsContainer.indices) {
                val w = wordsContainer[j]
                var lcsLenCand = 0
                while (lcsLenCand < q.length && lcsLenCand < w.length) {
                    if (w[w.lastIndex - lcsLenCand] == q[q.lastIndex - lcsLenCand]) {
                        lcsLenCand++
                    } else {
                        break
                    }
                }
                if (lcsLen < lcsLenCand) {
                    lcsLen = lcsLenCand
                    cands.clear()
                    cands.add(Pair(j, w.length))
                } else if (lcsLen == lcsLenCand && w.length >= lcsLen) {
                    val lcs = q.substring(q.length - lcsLen)
                    if (w.lastIndexOf(lcs) != -1) {
                        cands.add(Pair(j, w.length))
                    } else {
                        if (shortestLen > w.length) {
                            shortestLen = w.length
                            shortestLenIdx = j
                        }
                    }
                }
            }

            res[i] = if (cands.isNotEmpty()) cands.poll().first else shortestLenIdx
        }
        return res
    }
}

fun main() {
    with(_3093_longest_common_suffix_queries) {
        println(stringIndices(arrayOf("abcd", "bcd", "xbcd"), arrayOf("cd", "bcd", "xyz")).toList())
        println(stringIndices(arrayOf("abcdefgh", "poiuygh", "ghghgh"), arrayOf("gh", "acbfgh", "acbfegh")).toList())
    }
}
