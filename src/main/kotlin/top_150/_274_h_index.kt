package top_150

object _274_h_index {
    fun hIndex(citations: IntArray): Int {
        citations.sort()
        var hIdx = 0
        for (i in citations.indices) {
            val citation = citations[i]
            if (citation == 0) continue
            val tillEnd = citations.size - i
            val hIdxCand = minOf(tillEnd, citation)
            hIdx = maxOf(hIdx, hIdxCand)
        }
        return hIdx
    }
}

fun main() {
    with(_274_h_index) {
        println(hIndex(intArrayOf(0,1,3,5,6)))
        println(hIndex(intArrayOf(1,1,3)))
        println(hIndex(intArrayOf(100)))
        println(hIndex(intArrayOf(0,0,4,4)))
    }
}
