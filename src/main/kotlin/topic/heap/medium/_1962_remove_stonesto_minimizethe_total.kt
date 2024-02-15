package topic.heap.medium

import java.util.PriorityQueue

class _1962_remove_stonesto_minimizethe_total {
    fun minStoneSum(piles: IntArray, k: Int): Int {
        val pq = PriorityQueue<Int> { a, b -> b - a }
        piles.forEach { pq.add(it) }
        repeat(k) {
            val poll = pq.poll()
            if (poll % 2 == 0) pq.add(poll / 2)
            else pq.add((poll / 2) + 1)
        }
        return pq.sum()
    }
}

fun main() {
    with(_1962_remove_stonesto_minimizethe_total()) {
        println(minStoneSum(intArrayOf(5,4,9), 2))
        println(minStoneSum(intArrayOf(4,3,6,7), 3))
    }
}
