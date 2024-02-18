package topic.heap.medium

import java.util.PriorityQueue

class _2285_maximum_total_importanceof_roads {
    fun maximumImportance(n: Int, roads: Array<IntArray>): Long {
        val map = mutableMapOf<Int, Int>()
        for (road in roads) {
            map[road[0]] = map[road[0]]?.run { this + 1 } ?: 1
            map[road[1]] = map[road[1]]?.run { this + 1 } ?: 1
        }
        val pq = PriorityQueue<Map.Entry<Int,Int>> { a, b ->
            b.value - a.value
        }.apply { addAll(map.entries) }

        var importance = n
        while (pq.isNotEmpty()) {
            val entry = pq.poll()
            map[entry.key] = importance--
        }
        var result = 0L
        for (road in roads) {
            result += map[road[0]]!!
            result += map[road[1]]!!
        }
        return result
    }
}

fun main() {
    with(_2285_maximum_total_importanceof_roads()) {
        println(maximumImportance(5, arrayOf(
            intArrayOf(0,1),
            intArrayOf(1,2),
            intArrayOf(2,3),
            intArrayOf(0,2),
            intArrayOf(1,3),
            intArrayOf(2,4),
        )))
        println(maximumImportance(5, arrayOf(
            intArrayOf(0,1),
            intArrayOf(1,2),
        )))
        println(maximumImportance(5, arrayOf(
            intArrayOf(0,1),
        )))
    }
}
